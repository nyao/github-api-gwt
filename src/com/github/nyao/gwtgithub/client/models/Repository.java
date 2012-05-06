package com.github.nyao.gwtgithub.client.models;

import com.google.gwt.core.client.JavaScriptObject;

public class Repository extends JavaScriptObject {
    protected Repository() {
    }
    
    public final native String getName() /*-{ return this.name; }-*/;
    
    public final native String getUrl() /*-{ return this.url; }-*/;
    
    public final native String getGitUrl() /*-{ return this.git_url; }-*/;
    
    public final native String getHtmlUrl() /*-{ return this.html_url; }-*/;
    
    public final native int openIssues() /*-{ return this.open_issues; }-*/;
}
