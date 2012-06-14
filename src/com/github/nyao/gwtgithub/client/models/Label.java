package com.github.nyao.gwtgithub.client.models;

import com.github.nyao.gwtgithub.client.values.GHProp;
import com.google.gwt.core.client.JavaScriptObject;

public class Label extends JavaScriptObject {
    protected Label() {
    }
    
    public final native String getColor() /*-{ return this.color; }-*/;
    
    public final native String getUrl() /*-{ return this.url; }-*/;
    
    public final native String getName() /*-{ return this.name; }-*/;

    public static enum Prop implements GHProp {
        Url("url"),
        Name("name"),
        Color("color");

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
