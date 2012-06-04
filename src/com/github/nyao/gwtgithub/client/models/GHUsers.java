package com.github.nyao.gwtgithub.client.models;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class GHUsers extends JavaScriptObject {
    protected GHUsers() {
    }

    public final native JsArray<Issue> getData() /*-{ return this.data; }-*/;
}
