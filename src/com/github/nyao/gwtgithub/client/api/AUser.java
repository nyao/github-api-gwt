package com.github.nyao.gwtgithub.client.api;

import com.github.nyao.gwtgithub.client.models.GHUser;
import com.google.gwt.core.client.JavaScriptObject;

public class AUser extends JavaScriptObject {
    protected AUser() {
    }

    public final native GHUser getData() /*-{ return this.data; }-*/;
}
