package com.github.nyao.gwtgithub.client;

import com.github.nyao.gwtgithub.client.api.AUser;
import com.github.nyao.gwtgithub.client.api.Comments;
import com.github.nyao.gwtgithub.client.api.Issues;
import com.github.nyao.gwtgithub.client.api.Milestones;
import com.github.nyao.gwtgithub.client.api.Repositories;
import com.github.nyao.gwtgithub.client.api.Users;
import com.github.nyao.gwtgithub.client.models.Comment;
import com.github.nyao.gwtgithub.client.models.Issue;
import com.github.nyao.gwtgithub.client.models.Milestone;
import com.github.nyao.gwtgithub.client.models.Repository;
import com.github.nyao.gwtgithub.client.values.CommentForSave;
import com.github.nyao.gwtgithub.client.values.IssueForSave;
import com.github.nyao.gwtgithub.client.values.MilestoneForSave;
import com.github.nyao.gwtgithub.client.values.ValueForSave;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.jsonp.client.JsonpRequestBuilder;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class GitHubApi {

    private String accessToken = null;
    private String baseUrl = "https://api.github.com/";

    public void setGitHubURL(String url) {
        this.baseUrl = url;
    }

    public void setAuthorization(String accessToken) {
        this.accessToken = accessToken;
    }

    public void getUser(AsyncCallback<AUser> callback) {
        get(baseUrl + "user", callback);
    }

    public void getMyRepositories(AsyncCallback<Repositories> callback) {
        get(baseUrl + "user/repos", callback);
    }

    public void getRepositories(String user, AsyncCallback<Repositories> callback) {
        get(baseUrl + "users/" + user + "/repos", callback);
    }

    public void getOrganizations(String user, AsyncCallback<Users> callback) {
        get(baseUrl + "users/" + user + "/orgs", callback);
    }

    public void getOrganizations(AsyncCallback<Users> callback) {
        get(baseUrl + "user/orgs", callback);
    }

    public void getIssues(String user, String repository, AsyncCallback<Issues> callback) {
        get(baseUrl + "repos/" + user + "/" + repository + "/issues", callback);
    }

    public void getIssues(Repository repository, AsyncCallback<Issues> callback) {
        get(repository.getUrl() + "/issues", callback);
    }

    public void createIssue(Repository r, IssueForSave prop, final AsyncCallback<Issue> callback) {
        post(r.getUrl() + "/issues", prop, callback);
    }

    public void editIssue(Repository r, Issue issue, IssueForSave prop,
            final AsyncCallback<Issue> callback) {
        if (issue == null) {
            createIssue(r, prop, callback);
        } else {
            post(r.getUrl() + "/issues/" + issue.getNumber(), prop, callback);
        }
    }

    public void getComments(Repository r, Issue issue, AsyncCallback<Comments> callback) {
        get(r.getUrl() + "/issues/" + issue.getNumber() + "/comments", callback);
    }

    public void createComment(Repository r, Issue issue, CommentForSave prop,
            final AsyncCallback<Comment> callback) {
        post(r.getUrl() + "/issues/" + issue.getNumber() + "/comments", prop, callback);
    }

    public void getMilestones(Repository r, AsyncCallback<Milestones> callback) {
        get(r.getUrl() + "/milestones", callback);
    }

    public void createMilestone(Repository r, MilestoneForSave prop,
            final AsyncCallback<Milestone> callback) {
        post(r.getUrl() + "/milestones", prop, callback);
    }

    private <T extends JavaScriptObject> void get(String url, final AsyncCallback<T> callback) {
        String requestUrl = addAutorization(url);
        GWT.log("[GET]" + requestUrl);
        JsonpRequestBuilder jsonp = new JsonpRequestBuilder();
        jsonp.requestObject(requestUrl, callback);
    }

    private <T extends JavaScriptObject> void post(String url, ValueForSave<?> request,
            final AsyncCallback<T> callback) {
        String requestUrl = addAutorization(url);
        RequestBuilder builder = new RequestBuilder(RequestBuilder.POST, requestUrl);
        String requestJson = request.toJson();
        GWT.log("[POST]" + requestUrl + "\n" + requestJson);
        try {
            builder.sendRequest(requestJson, new RequestCallback() {
                @Override
                public void onResponseReceived(Request request, Response response) {
                    T result = JsonUtils.safeEval(response.getText());
                    callback.onSuccess(result);
                }

                @Override
                public void onError(Request request, Throwable exception) {
                    callback.onFailure(exception);
                }
            });
        } catch (RequestException e) {
            callback.onFailure(e);
        }
    }

    private String addAutorization(String url) {
        String prefix = "?";
        if (url.contains("?")) {
            prefix = "&";
        }

        if (accessToken != null) {
            url += prefix + "access_token=" + accessToken;
        }
        return url;
    }
}
