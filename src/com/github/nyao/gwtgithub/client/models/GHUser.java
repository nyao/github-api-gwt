package com.github.nyao.gwtgithub.client.models;

import com.google.gwt.core.client.JavaScriptObject;

public class GHUser extends JavaScriptObject {
    protected GHUser() {
    }

    public final native String getLogin() /*-{ return this.login; }-*/;

}