package com.github.nyao.gwtgithub.client.api;

import com.github.nyao.gwtgithub.client.models.Milestone;
import com.google.gwt.core.client.JavaScriptObject;

public class AMilestone extends JavaScriptObject {
    protected AMilestone() {
    }

    public final native Milestone getData() /*-{ return this.data; }-*/;
}
