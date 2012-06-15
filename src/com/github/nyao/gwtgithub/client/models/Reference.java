package com.github.nyao.gwtgithub.client.models;

import com.google.gwt.core.client.JavaScriptObject;

public class Reference extends JavaScriptObject {
    protected Reference() {
    }
    
    public final native String getRef() /*-{ return this.ref; }-*/;
    
    public final native String getUrl() /*-{ return this.url; }-*/;

    public final native GHObject getObject() /*-{ return this.object; }-*/;

}
