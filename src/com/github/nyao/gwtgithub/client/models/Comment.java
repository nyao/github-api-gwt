package com.github.nyao.gwtgithub.client.models;

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;

public class Comment extends JavaScriptObject {
    protected Comment() {
    }

    public final native String getUrl() /*-{ return this.url; }-*/;
    
    public final native String getBody() /*-{ return this.body; }-*/;
    
    public final native GHUser getUser() /*-{ return this.user; }-*/;

    public final native Date getCreatedAt() /*-{ return this.created_at; }-*/;

    public final native Date getUpdatedAt() /*-{ return this.updated_at; }-*/;
}
