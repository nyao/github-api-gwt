package com.github.nyao.gwtgithub.client.models;

import com.github.nyao.gwtgithub.client.values.GHProp;
import com.google.gwt.core.client.JavaScriptObject;

public class Blob extends JavaScriptObject {
    protected Blob() {
    }
    
    public final native String getContent() /*-{ return this.content; }-*/;
    
    public final native String getEncoding() /*-{ return this.encoding; }-*/;

    public static enum Prop implements GHProp {
        Content("content"),
        Encoding("encoding"),
        ;
        
        private final String value;
        
        private Prop(String value) {
            this.value = value;
        }

        @Override
        public String value() {
            return value;
        }
    }
}
