package com.github.nyao.gwtgithub.client.api;

import com.github.nyao.gwtgithub.client.models.Issue;
import com.google.gwt.core.client.JavaScriptObject;

public class AIssue extends JavaScriptObject {
    protected AIssue() {
    }

    public final native Issue getData() /*-{ return this.data; }-*/;
}
