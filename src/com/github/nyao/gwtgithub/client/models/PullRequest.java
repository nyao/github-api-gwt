package com.github.nyao.gwtgithub.client.models;

import com.google.gwt.core.client.JavaScriptObject;

public class PullRequest extends JavaScriptObject {
    protected PullRequest() {
    }
    
    public final native String getPatchUrl() /*-{ return this.patch_url; }-*/;

    public final native String getDiffUrl() /*-{ return this.diff_url; }-*/;

    public final native String getHtmlUrl() /*-{ return this.html_url; }-*/;
}
