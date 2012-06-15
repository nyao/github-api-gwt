package com.github.nyao.gwtgithub.client.models;

import com.google.gwt.core.client.JavaScriptObject;

public class Commiter extends JavaScriptObject {
    protected Commiter() {
    }
    
    public final native String getDate() /*-{ return this.date; }-*/;
    
    public final native String getName() /*-{ return this.name; }-*/;

    public final native String getEmail() /*-{ return this.email; }-*/;

}
