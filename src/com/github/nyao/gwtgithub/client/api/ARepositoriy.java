package com.github.nyao.gwtgithub.client.api;

import com.github.nyao.gwtgithub.client.models.Repository;
import com.google.gwt.core.client.JavaScriptObject;

public class ARepositoriy extends JavaScriptObject {
    protected ARepositoriy() {
    }
    
    public final native Repository getData() /*-{ return this.data; }-*/;
}
