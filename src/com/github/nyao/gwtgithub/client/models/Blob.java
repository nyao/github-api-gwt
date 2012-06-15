package com.github.nyao.gwtgithub.client.models;

import com.google.gwt.core.client.JavaScriptObject;

public class Blob extends JavaScriptObject {
    protected Blob() {
    }
    
    public final native String getContent() /*-{ return this.content; }-*/;
    
    public final native String getEncoding() /*-{ return this.encoding; }-*/;

}
