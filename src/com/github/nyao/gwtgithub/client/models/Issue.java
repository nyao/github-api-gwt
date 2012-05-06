package com.github.nyao.gwtgithub.client.models;

import com.google.gwt.core.client.JavaScriptObject;

public class Issue extends JavaScriptObject {
    protected Issue() {
    }

    public final native int getNumber() /*-{ return this.number; }-*/;
    
    public final native String getTitle() /*-{ return this.title; }-*/;
    
    public final native String getUrl() /*-{ return this.url; }-*/;
    
    public final native String getHtmlUrl() /*-{ return this.html_url; }-*/;
}
