package com.github.nyao.gwtgithub.client.models;

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;

public class Milestone extends JavaScriptObject {
    protected Milestone() {
    }

    public final native String getTitle() /*-{ return this.title; }-*/;

    public final native int getOpenIssues() /*-{ return this.open_issues; }-*/;

    public final native int getClosedIssues() /*-{ return this.closed_issues; }-*/;

    public final native Date getCreatedAt() /*-{ return this.created_at; }-*/;

    public final native String getState() /*-{ return this.state; }-*/;

    public final native String getDescription() /*-{ return this.description; }-*/;

    public final native String getUrl() /*-{ return this.url; }-*/;

    public final native GHUser getCreator() /*-{ return this.creator; }-*/;

    public final native Date getDueOn() /*-{ return this.due_on; }-*/;

    public final native int getNumber() /*-{ return this.number; }-*/;

    public final native int getId() /*-{ return this.id; }-*/;
}
