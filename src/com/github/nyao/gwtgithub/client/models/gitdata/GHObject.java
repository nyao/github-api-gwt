package com.github.nyao.gwtgithub.client.models.gitdata;

import com.google.gwt.core.client.JavaScriptObject;

public class GHObject extends JavaScriptObject {
    protected GHObject() {
    }
    
    public final native String getType() /*-{ return this.type; }-*/;
    
    public final native String getSha() /*-{ return this.sha; }-*/;

    public final native String getUrl() /*-{ return this.url; }-*/;

}
