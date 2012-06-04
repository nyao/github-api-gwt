package com.github.nyao.gwtgithub.client.models;

import com.google.gwt.core.client.JavaScriptObject;

public class GHUser extends JavaScriptObject {
    protected GHUser() {
    }

    public final native String getLogin() /*-{ if (this.data != null) {return this.data.login} else {return this.login;} }-*/;

    public final native String getGravatarId() /*-{ if (this.data != null) {return this.data.gravatar_id} else {return this.gravatar_id;} }-*/;

    public final native String getUrl() /*-{ if (this.data != null) {return this.data.url} else {return this.url;} }-*/;

    public final native String getAvatarUrl() /*-{ if (this.data != null) {return this.data.avatar_url} else {return this.avatar_url;} }-*/;

    public final native String getId() /*-{ if (this.data != null) {return this.data.id} else {return this.id;} }-*/;
}
