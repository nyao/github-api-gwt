package com.github.nyao.gwtgithub.client.api;

import com.github.nyao.gwtgithub.client.models.issues.*;

import com.google.gwt.core.client.JavaScriptObject;

public class ALabel extends JavaScriptObject {
    protected ALabel() {
    }

    public final native Label getData() /*-{ return this.data; }-*/;
}
