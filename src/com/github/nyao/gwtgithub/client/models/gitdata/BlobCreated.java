package com.github.nyao.gwtgithub.client.models.gitdata;

import com.google.gwt.core.client.JavaScriptObject;

public class BlobCreated extends JavaScriptObject {
    protected BlobCreated() {
    }
    
    public final native String getSha() /*-{ return this.sha; }-*/;
}
