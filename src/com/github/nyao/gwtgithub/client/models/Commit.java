package com.github.nyao.gwtgithub.client.models;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class Commit extends JavaScriptObject {
    protected Commit() {
    }
    
    public final native String getSha() /*-{ return this.sha; }-*/;
    
    public final native String getUrl() /*-{ return this.url; }-*/;

    public final native Commiter getAuthor() /*-{ return this.author; }-*/;
    
    public final native Commiter getCommiter() /*-{ return this.commiter; }-*/;

    public final native String getMessage() /*-{ return this.message; }-*/;

    public final native Tree getTree() /*-{ return this.tree; }-*/;

    public final native JsArray<Tree> getParents() /*-{ return this.parents; }-*/;

}
