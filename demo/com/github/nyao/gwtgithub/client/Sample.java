package com.github.nyao.gwtgithub.client;

import static com.google.gwt.query.client.GQuery.$;

import com.github.nyao.gwtgithub.client.models.Issue;
import com.github.nyao.gwtgithub.client.models.Issues;
import com.github.nyao.gwtgithub.client.models.Repositories;
import com.github.nyao.gwtgithub.client.models.Repository;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.Element;
import com.google.gwt.query.client.Function;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class Sample implements EntryPoint {

    final Sample self = this;
    GitHubApi api = new GitHubApi();

    @Override
    public void onModuleLoad() {
        $("#LoginSubmit").click(new Function() {
            @Override
            public boolean f(Event e) {
                api.getRepositories($("#Login").val(), new BuildRepositoryTable());
                return true;
            }
        });
        
        $("#TokenSubmit").click(new Function() {
            @Override
            public boolean f(Event e) {
                api.setAuthorization($("#Token").val());
                api.getMyRepository(new BuildRepositoryTable());
                return true;
            }
        });
    }

    private final class BuildRepositoryTable implements AsyncCallback<Repositories> {
        @Override
        public void onSuccess(Repositories result) {
            $("#Repositories tbody tr").remove();
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
        $(nameA).attr("href",   repository.getHtmlUrl())
                .attr("target", "_blank")
                .text("(_)");
        name.setInnerText(repository.getName());
        name.appendChild(nameA);
        tr.appendChild(name);
        
        Element issueSize = DOM.createTD();
        Element openIssues = DOM.createAnchor();
        issueSize.appendChild(openIssues);
        openIssues.setInnerText(String.valueOf(repository.openIssues()));
        tr.appendChild(issueSize);
        
        $(openIssues).click(new Function() {
            @Override
            public boolean f(Event e) {
                api.getIssues(repository, new AsyncCallback<Issues>() {
                    @Override
                    public void onSuccess(Issues result) {
                        $("#Issues tbody tr").remove();
                        JsArray<Issue> data = result.getData();
                        for (int i = 0; i < data.length(); i ++) {
                            addIssue(data.get(i));
                        }
                    }
                    @Override
                    public void onFailure(Throwable caught) {
                        GWT.log("error", caught);
                    }
                });
                return true;
            }
        });
        
        $("#Repositories tbody").append($(tr));
    }
    
    private void addIssue(final Issue issue) {
        Element tr = DOM.createTR();

        Element number = DOM.createTD();
        Element numberA = DOM.createAnchor();
        $(numberA).attr("href",   issue.getHtmlUrl())
                  .attr("target", "_blank")
                  .text("#" + String.valueOf(issue.getNumber()));
        number.appendChild(numberA);
        tr.appendChild(number);
        
        Element title = DOM.createTD();
        title.setInnerText(issue.getTitle());
        tr.appendChild(title);
        $("#Issues tbody").append($(tr));
    }
}
