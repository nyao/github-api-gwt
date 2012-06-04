package com.github.nyao.gwtgithub.client.models;

import com.google.gwt.core.client.JavaScriptObject;

public class PullRequest extends JavaScriptObject {
    protected PullRequest() {
    }
    
    public final native String getPatchUrl() /*-{ if (this.data != null) {return this.data.patch_url} else {return this.patch_url;} }-*/;

    public final native String getDiffUrl() /*-{ if (this.data != null) {return this.data.diff_url} else {return this.diff_url;} }-*/;

    public final native String getHtmlUrl() /*-{ if (this.data != null) {return this.data.html_url} else {return this.html_url;} }-*/;
}
