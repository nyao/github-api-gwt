package com.github.nyao.gwtgithub.client.api;

import com.github.nyao.gwtgithub.client.models.issues.*;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class IssueComments extends JavaScriptObject {
    protected IssueComments() {
    }

    public final native JsArray<IssueComment> getData() /*-{ return this.data; }-*/;
}
