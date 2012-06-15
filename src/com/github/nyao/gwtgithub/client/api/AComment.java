package com.github.nyao.gwtgithub.client.api;

import com.github.nyao.gwtgithub.client.models.issues.*;
import com.google.gwt.core.client.JavaScriptObject;

public class AComment extends JavaScriptObject {
    protected AComment() {
    }

    public final native IssueComment getData() /*-{ return this.data; }-*/;
}
