package gitgwt.client;

import gitgwt.client.models.Issue;
import gitgwt.client.models.Issues;
import gitgwt.client.models.Repositories;
import gitgwt.client.models.Repository;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class Sample implements EntryPoint {

    private FlexTable stocksFlexTable = new FlexTable();

    final Sample self = this;

    final Element repositoriesElement = RootPanel.getBodyElement().getElementsByTagName("tbody").getItem(0);
    final Element issuesElement = RootPanel.getBodyElement().getElementsByTagName("tbody").getItem(1);
    
    @Override
    public void onModuleLoad() {
        final TextBox login = TextBox.wrap(RootPanel.get("Login").getElement());
        Button loginSubmit = Button.wrap(RootPanel.get("LoginSubmit").getElement());
        
        loginSubmit.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                String url = "https://api.github.com/users/" + login.getText() + "/repos";
                GitHubApi.getRepositories(url, self);
                event.preventDefault();
            }
        });
        
        new com.github.nyao.gwtgithub.client.GitHubApi().getRepositories("soundTricker", new AsyncCallback<com.github.nyao.gwtgithub.client.models.Repositories>() {
			
			@Override
			public void onSuccess(com.github.nyao.gwtgithub.client.models.Repositories result) {
				JsArray<com.github.nyao.gwtgithub.client.models.Repository> data = result.getData();
				
				com.github.nyao.gwtgithub.client.models.Repository repository = data.get(0);
				
				GWT.log(repository.getGitUrl());
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				GWT.log("error", caught);
			}
		});
        
    }
    
    private void addRepository(final Repository repository) {
        Element tr = DOM.createTR();
        
        Element name = DOM.createTD();
        Element nameA = DOM.createAnchor();
        name.setInnerText(repository.getName());
        name.appendChild(nameA);
        tr.appendChild(name);
        
        Element issueSize = DOM.createTD();
        Element a = DOM.createAnchor();
        issueSize.appendChild(a);
        a.setInnerText(String.valueOf(repository.openIssues()));
        tr.appendChild(issueSize);
        
        repositoriesElement.appendChild(tr);

        Anchor na = Anchor.wrap(nameA);
        na.setHref(repository.getHtmlUrl());
        na.setTarget("_blank");
        na.setText("(_)");
        
        Anchor.wrap(a).addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                String url = repository.getUrl() + "/issues";
                GitHubApi.getIssues(url, self);
            }
        });
    }
    
    private void addIssue(final Issue issue) {
        Element tr = DOM.createTR();

        Element number = DOM.createTD();
        Element numberA = DOM.createAnchor();
        number.appendChild(numberA);
        tr.appendChild(number);
        
        Element title = DOM.createTD();
        title.setInnerText(issue.getTitle());
        tr.appendChild(title);
        issuesElement.appendChild(tr);
        
        Anchor a = Anchor.wrap(numberA);
        a.setText("#" + String.valueOf(issue.getNumber()));
        a.setHref(issue.getHtmlUrl());
        a.setTarget("_blank");
    }

    public void callBackRepositories(JavaScriptObject jso) {
        if (jso == null) {
            return;
        }

        int length = repositoriesElement.getChildNodes().getLength();
        for (int i = 0; i < length; i ++) {
            repositoriesElement.getChildNodes().getItem(0).removeFromParent();
        }
        JsArray<Repository> data = asRepositories(jso).getData();
        for (int i = 0; i < data.length(); i ++) {
            Repository r = data.get(i);
            addRepository(r);
        }
    }
    
    public void callBackIssues(JavaScriptObject jso) {
        if (jso == null) {
            return;
        }

        int length = issuesElement.getChildNodes().getLength();
        for (int i = 0; i < length; i ++) {
            issuesElement.getChildNodes().getItem(0).removeFromParent();
        }
        JsArray<Issue> data = asIssues(jso).getData();
        for (int i = 0; i < data.length(); i ++) {
            Issue issue = data.get(i);
            addIssue(issue);
        }
    }

    private final native Issues asIssues(JavaScriptObject jso) /*-{
        return jso;
    }-*/;
    
    private final native Repositories asRepositories(JavaScriptObject jso) /*-{
        return jso;
    }-*/;
}
