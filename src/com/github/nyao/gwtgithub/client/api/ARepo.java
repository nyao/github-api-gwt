package com.github.nyao.gwtgithub.client.api;

import com.github.nyao.gwtgithub.client.models.Repo;
import com.google.gwt.core.client.JavaScriptObject;

public class ARepo extends JavaScriptObject {
    protected ARepo() {
    }
    
    public final native Repo getData() /*-{ return this.data; }-*/;
}
