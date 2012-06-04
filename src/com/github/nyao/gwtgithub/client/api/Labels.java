package com.github.nyao.gwtgithub.client.api;

import com.github.nyao.gwtgithub.client.models.Label;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class Labels extends JavaScriptObject {
    protected Labels() {
    }

    public final native JsArray<Label> getData() /*-{ return this.data; }-*/;
}
