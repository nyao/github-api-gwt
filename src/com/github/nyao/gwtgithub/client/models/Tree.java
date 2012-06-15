package com.github.nyao.gwtgithub.client.models;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class Tree extends JavaScriptObject {
    protected Tree() {
    }
    
    public final native String getSha() /*-{ return this.sha; }-*/;
    
    public final native String getUrl() /*-{ return this.url; }-*/;

    public final native String getPath() /*-{ return this.path; }-*/;
    
    public final native String getMode() /*-{ return this.mode; }-*/;
    
    public final native String getType() /*-{ return this.type; }-*/;
    
    public final native Integer getSize() /*-{ return this.size; }-*/;

    public final native JsArray<Tree> getTree() /*-{ return this.tree; }-*/;
}
