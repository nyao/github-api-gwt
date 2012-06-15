package com.github.nyao.gwtgithub.client.api;

import com.github.nyao.gwtgithub.client.models.issues.*;

import com.google.gwt.core.client.JavaScriptObject;

public class AMilestone extends JavaScriptObject {
    protected AMilestone() {
    }

    public final native Milestone getData() /*-{ return this.data; }-*/;
}
