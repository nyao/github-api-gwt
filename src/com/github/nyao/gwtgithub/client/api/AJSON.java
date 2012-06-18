package com.github.nyao.gwtgithub.client.api;

import com.google.gwt.core.client.JavaScriptObject;

public class AJSON<T extends JavaScriptObject> extends JavaScriptObject {
    protected AJSON() {
    }

    public final native T getData() /*-{ return this.data; }-*/;
}