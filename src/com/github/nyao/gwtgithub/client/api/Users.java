package com.github.nyao.gwtgithub.client.api;

import com.github.nyao.gwtgithub.client.models.GHUser;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class Users extends JavaScriptObject {
    protected Users() {
    }

    public final native JsArray<GHUser> getData() /*-{ return this.data; }-*/;
}
