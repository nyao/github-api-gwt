package com.github.nyao.gwtgithub.client.api;

import com.github.nyao.gwtgithub.client.models.Repository;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class Repositories extends JavaScriptObject {
    protected Repositories() {
    }
    
    public final native JsArray<Repository> getData() /*-{ return this.data; }-*/;
}
