package com.github.nyao.gwtgithub.client.api;

import com.github.nyao.gwtgithub.client.models.issues.*;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class Issues extends JavaScriptObject {
    protected Issues() {
    }

    public final native JsArray<Issue> getData() /*-{ return this.data; }-*/;
}
