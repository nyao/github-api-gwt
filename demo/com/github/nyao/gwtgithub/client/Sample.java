package com.github.nyao.gwtgithub.client;

import static com.google.gwt.query.client.GQuery.$;

import com.github.nyao.gwtgithub.client.models.Issue;
import com.github.nyao.gwtgithub.client.models.Issues;
import com.github.nyao.gwtgithub.client.models.Repositories;
import com.github.nyao.gwtgithub.client.models.Repository;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.GQuery;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class Sample implements EntryPoint {

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
        
        GQuery name = $("<td>").text(repository.getName())
                               .append($("<a>").attr("href",   repository.getHtmlUrl())
                                               .attr("target", "_blank")
                                               .text("(_)"));
        
        GQuery issueSize = $("<td>").append(
                            $("<a>").text(String.valueOf(repository.openIssues()))
                                    .click(new Function() {
                                        @Override
                                        public boolean f(Event e) {
                                            api.getIssues(repository, new BuildIssuesTable());
                                            return true;
                                        }
                                    }));
        
        GQuery tr = $("<tr>");
        tr.append(name);
        tr.append(issueSize);
        $("#Repositories tbody").append($(tr));
    }

    private final class BuildIssuesTable implements AsyncCallback<Issues> {
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
    }
    
    private void addIssue(Issue issue) {
        GQuery number = $("<td>").append(
                            $("<a>").attr("href",   issue.getHtmlUrl())
                                    .attr("target", "_blank")
                                    .text("#" + String.valueOf(issue.getNumber())));
        
        GQuery title = $("<td>").text(issue.getTitle());
        
        GQuery tr = $("<tr>");
        tr.append(number);
        tr.append(title);
        $("#Issues tbody").append(tr);
    }
}
