package com.github.nyao.gwtgithub.client.models;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class JSONs<T extends JavaScriptObject> extends JavaScriptObject {
    protected JSONs() {
    }

    public final native boolean isNotFound() /*-{ return this.message == "Not Found"; }-*/;
    
    public final native JsArray<T> getData() /*-{ return this.data; }-*/;
}
