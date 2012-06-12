package com.github.nyao.gwtgithub.client;

import com.github.nyao.gwtgithub.client.api.AUser;
import com.github.nyao.gwtgithub.client.api.Comments;
import com.github.nyao.gwtgithub.client.api.Issues;
import com.github.nyao.gwtgithub.client.api.Milestones;
import com.github.nyao.gwtgithub.client.api.Repos;
import com.github.nyao.gwtgithub.client.api.Users;
import com.github.nyao.gwtgithub.client.models.Comment;
import com.github.nyao.gwtgithub.client.models.Issue;
import com.github.nyao.gwtgithub.client.models.Milestone;
import com.github.nyao.gwtgithub.client.models.Repo;
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
    private boolean authorized = false;

    public void setGitHubURL(String url) {
        this.baseUrl = url;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    
    public boolean isAuthorized() {
        return this.authorized;
    }

    public void getUser(final AsyncCallback<AUser> callback) {
        AsyncCallback<AUser> hook = new AsyncCallback<AUser>() {
            @Override
            public void onSuccess(AUser result) {
                authorized = true;
                callback.onSuccess(result);
            }
            
            @Override
            public void onFailure(Throwable caught) {
                callback.onFailure(caught);
            }
        };
        get(baseUrl + "user", hook);
    }

    public void getRepos(AsyncCallback<Repos> callback) {
        get(baseUrl + "user/repos", callback);
    }

    public void getRepos(String user, AsyncCallback<Repos> callback) {
        get(baseUrl + "users/" + user + "/repos", callback);
    }

    public void getOrgs(String user, AsyncCallback<Users> callback) {
        get(baseUrl + "users/" + user + "/orgs", callback);
    }

    public void getOrgs(AsyncCallback<Users> callback) {
        get(baseUrl + "user/orgs", callback);
    }

    public void getIssues(String user, String repository, AsyncCallback<Issues> callback) {
        get(baseUrl + "repos/" + user + "/" + repository + "/issues", callback);
    }

    public void getIssues(Repo repository, AsyncCallback<Issues> callback) {
        get(repository.getUrl() + "/issues", callback);
    }

    public void createIssue(Repo r, IssueForSave prop, final AsyncCallback<Issue> callback) {
        post(r.getUrl() + "/issues", prop, callback);
    }

    public void editIssue(Repo r, Issue issue, IssueForSave prop,
            final AsyncCallback<Issue> callback) {
        if (issue == null) {
            createIssue(r, prop, callback);
        } else {
            post(r.getUrl() + "/issues/" + issue.getNumber(), prop, callback);
        }
    }

    public void getComments(Repo r, Issue issue, AsyncCallback<Comments> callback) {
        get(r.getUrl() + "/issues/" + issue.getNumber() + "/comments", callback);
    }

    public void createComment(Repo r, Issue issue, CommentForSave prop,
            final AsyncCallback<Comment> callback) {
        post(r.getUrl() + "/issues/" + issue.getNumber() + "/comments", prop, callback);
    }

    public void getMilestones(Repo r, AsyncCallback<Milestones> callback) {
        get(r.getUrl() + "/milestones", callback);
    }

    public void createMilestone(Repo r, MilestoneForSave prop,
            final AsyncCallback<Milestone> callback) {
        post(r.getUrl() + "/milestones", prop, callback);
    }

    public void saveMilestone(Repo r, Milestone m, MilestoneForSave prop,
            final AsyncCallback<Milestone> callback) {
        if (m ==null) {
            createMilestone(r, prop, callback);
        } else {
            post(r.getUrl() + "/milestones/" + m.getNumber(), prop, callback);
        }
    }

    public void saveMilestone(Repo r, String number, MilestoneForSave prop,
            final AsyncCallback<Milestone> callback) {
        if (number ==null) {
            createMilestone(r, prop, callback);
        } else {
            post(r.getUrl() + "/milestones/" + number, prop, callback);
        }
    }

    private <T extends JavaScriptObject> void get(String url, final AsyncCallback<T> callback) {
        String requestUrl = makeRequestUrl(url);
        GWT.log("[GET]" + requestUrl);
        JsonpRequestBuilder jsonp = new JsonpRequestBuilder();
        jsonp.requestObject(requestUrl, callback);
    }

    private <T extends JavaScriptObject> void post(String url, ValueForSave<?> request,
            final AsyncCallback<T> callback) {
        String requestUrl = makeRequestUrl(url);
        RequestBuilder builder = new RequestBuilder(RequestBuilder.POST, requestUrl);
        String requestJson = request.toJson();
        final StringBuilder log = new StringBuilder();
        log.append("[POST]" + requestUrl + "\n" + requestJson);
        try {
            builder.sendRequest(requestJson, new RequestCallback() {
                @Override
                public void onResponseReceived(Request request, Response response) {
                    T result = JsonUtils.safeEval(response.getText());
                    log.append("\n\n--" + response.getStatusText() + "\n" + response.getText());
                    callback.onSuccess(result);
                    GWT.log(log.toString());
                }

                @Override
                public void onError(Request request, Throwable e) {
                    log.append("\n\n--" + e.getStackTrace());
                    callback.onFailure(e);
                    GWT.log(log.toString());
                }
            });
        } catch (RequestException e) {
            log.append("\n\n--" + e.getStackTrace());
            callback.onFailure(e);
            GWT.log(log.toString());
        }
    }

    private String makeRequestUrl(String url) {
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
