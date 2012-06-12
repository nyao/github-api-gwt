package com.github.nyao.gwtgithub.client.api;

import com.github.nyao.gwtgithub.client.models.Repo;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class Repos extends JavaScriptObject {
    protected Repos() {
    }
    
    public final native JsArray<Repo> getData() /*-{ return this.data; }-*/;
}
