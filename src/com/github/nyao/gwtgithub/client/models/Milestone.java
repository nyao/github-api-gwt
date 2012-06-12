package com.github.nyao.gwtgithub.client.models;

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;

public class Milestone extends JavaScriptObject {
    protected Milestone() {
    }

    public final native String getTitle() /*-{ return this.title; }-*/;

    public final native int getOpenIssues() /*-{ return this.title; }-*/;

    public final native int getClosedIssues() /*-{ return this.closed_issues; }-*/;

    public final native String getState() /*-{ return this.state; }-*/;

    public final native String getDescription() /*-{ return this.description; }-*/;

    public final native String getUrl() /*-{ return this.url; }-*/;

    public final native GHUser getCreator() /*-{ return this.creator; }-*/;

    public final Date getDueOn() { return DateTimeFormat.getFormat(PredefinedFormat.DATE_TIME_FULL).parse(this.getDueOnString()); }

    public final native String getDueOnString() /*-{ return this.due_on; }-*/;

    public final native int getNumber() /*-{ return this.number; }-*/;

    public final native int getId() /*-{ return this.id; }-*/;

    public final Date getCreatedAt() { return DateTimeFormat.getFormat(PredefinedFormat.DATE_TIME_SHORT).parse(this.getCreatedAtString()); }
    
    public final native String getCreatedAtString() /*-{ return this.created_at; }-*/;

    public static enum Prop {
        title,
        description,
        state,
        due_on
    }
}
