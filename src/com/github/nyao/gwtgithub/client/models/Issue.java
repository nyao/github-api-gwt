package com.github.nyao.gwtgithub.client.models;

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class Issue extends JavaScriptObject {
    protected Issue() {
    }

    public final native int getNumber() /*-{ return this.number; }-*/;
    
    public final native String getTitle() /*-{ return this.title; }-*/;
    
    public final native String getUrl() /*-{ return this.url; }-*/;
    
    public final native String getHtmlUrl() /*-{ return this.html_url; }-*/;

    public final native String getState() /*-{ return this.state; }-*/;

    public final native GHUser getUser() /*-{ return this.user; }-*/;

    public final native Date getCreatedAt() /*-{ return this.created_at; }-*/;

    public final native Date getUpdatedAt() /*-{ return this.updated_at; }-*/;
    
    public final native String getBody() /*-{ return this.body; }-*/;
    
    public final native int getComments() /*-{ return this.comments; }-*/;
    
    public final native GHUser getAssignee() /*-{ return this.assignee; }-*/;
    
    public final native int getId() /*-{ return this.id; }-*/;
    
    public final native Milestone getMilestone() /*-{ return this.milestone; }-*/;
    
    public final native JsArray<Label> getLabels() /*-{ return this.labels; }-*/;
    
    public final native PullRequest getPullRequest() /*-{ return this.pull_request; }-*/;

    public static enum Prop {
        title,
        body,
        assignee,
        state,
        milestone,
        labels
    }
}
