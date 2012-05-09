package com.github.nyao.gwtgithub.client;

import com.github.nyao.gwtgithub.client.models.Issue;
import com.github.nyao.gwtgithub.client.models.Issues;
import com.github.nyao.gwtgithub.client.models.Repositories;
import com.github.nyao.gwtgithub.client.models.Repository;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class Sample implements EntryPoint {

    final Sample self = this;

    final Element repositoriesElement = RootPanel.getBodyElement().getElementsByTagName("tbody").getItem(0);
    final Element issuesElement = RootPanel.getBodyElement().getElementsByTagName("tbody").getItem(1);
    
    @Override
    public void onModuleLoad() {
        final TextBox login = TextBox.wrap(RootPanel.get("Login").getElement());
        Button loginSubmit = Button.wrap(RootPanel.get("LoginSubmit").getElement());
        final TextBox token = TextBox.wrap(RootPanel.get("Token").getElement());
        Button tokenSubmit = Button.wrap(RootPanel.get("TokenSubmit").getElement());
        
        loginSubmit.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                event.preventDefault();
                new GitHubApi().getRepositories(login.getText(), new BuildRepositoryTable());
            }
        });
        
        tokenSubmit.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                event.preventDefault();
                GitHubApi api = new GitHubApi();
                api.setAuthorization(token.getText());
                api.getMyRepository(new BuildRepositoryTable());
            }
        });
    }

    private final class BuildRepositoryTable implements AsyncCallback<Repositories> {
        @Override
        public void onSuccess(Repositories result) {
            int length = repositoriesElement.getChildNodes().getLength();
            for (int i = 0; i < length; i ++) {
                repositoriesElement.getChildNodes().getItem(0).removeFromParent();
            }
            JsArray<Repository> data = result.getData();
            for (int i = 0; i < data.length(); i ++) {
                Repository r = data.get(i);
                addRepository(r);
            }
        }

        @Override
        public void onFailure(Throwable caught) {
            GWT.log("error", caught);
        }
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
                event.preventDefault();
                new GitHubApi().getIssues(repository, new AsyncCallback<Issues>() {
                    @Override
                    public void onSuccess(Issues result) {
                        int length = issuesElement.getChildNodes().getLength();
                        for (int i = 0; i < length; i ++) {
                            issuesElement.getChildNodes().getItem(0).removeFromParent();
                        }
                        JsArray<Issue> data = result.getData();
                        for (int i = 0; i < data.length(); i ++) {
                            Issue issue = data.get(i);
                            addIssue(issue);
                        }
                    }
                    @Override
                    public void onFailure(Throwable caught) {
                        GWT.log("error", caught);
                    }
                });
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
}
