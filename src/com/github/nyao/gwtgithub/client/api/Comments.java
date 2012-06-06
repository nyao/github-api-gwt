package com.github.nyao.gwtgithub.client.api;

import com.github.nyao.gwtgithub.client.models.Comment;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class Comments extends JavaScriptObject {
    protected Comments() {
    }

    public final native JsArray<Comment> getData() /*-{ return this.data; }-*/;
}
