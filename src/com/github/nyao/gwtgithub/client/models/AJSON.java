package com.github.nyao.gwtgithub.client.models;

import com.google.gwt.core.client.JavaScriptObject;

public class AJSON<T extends JavaScriptObject> extends JavaScriptObject {
    protected AJSON() {
    }

    public final native String getMessage() /*-{ return this.message; }-*/;
    
    public final boolean isServerError() {System.out.println(getMessage()); return getMessage().equals("Server Error");}

    public final boolean isNotFound() {return getMessage().equals("Not Found");}

    public final native T getData() /*-{ return this.data; }-*/;
}
