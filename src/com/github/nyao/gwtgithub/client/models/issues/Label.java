package com.github.nyao.gwtgithub.client.models.issues;

import com.google.gwt.core.client.JavaScriptObject;

public class Label extends JavaScriptObject {
    protected Label() {
    }
    
    public final native String getColor() /*-{ return this.color; }-*/;
    
    public final native String getUrl() /*-{ return this.url; }-*/;
    
    public final native String getName() /*-{ return this.name; }-*/;

}
