package com.github.nyao.gwtgithub.client.models;

import com.google.gwt.core.client.JavaScriptObject;

public class AJSON<T extends JavaScriptObject> extends JavaScriptObject {
    protected AJSON() {
    }

    public final native boolean isNotFound() /*-{ return this.message == "Not Found"; }-*/;

    public final native T getData() /*-{ return this.data; }-*/;
}
