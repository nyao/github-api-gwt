package com.github.nyao.gwtgithub.client.api;

import com.github.nyao.gwtgithub.client.models.issues.*;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class Milestones extends JavaScriptObject {
    protected Milestones() {
    }
    
    public final native JsArray<Milestone> getData() /*-{ return this.data; }-*/;
}
