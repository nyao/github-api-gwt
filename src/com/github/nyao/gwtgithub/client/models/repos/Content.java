package com.github.nyao.gwtgithub.client.models.repos;

import com.github.nyao.gwtgithub.client.util.Base64;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class Content extends JavaScriptObject {
    protected Content() {
    }

    public final native String getType() /*-{ return this.type; }-*/;
    
    public final native String getEncoding() /*-{ return this.encoding; }-*/;

    public final native JsArray<Links> getLinks() /*-{ return this._links; }-*/;

    public final native int getSize() /*-{ return this.size; }-*/;
    
    public final native String getName() /*-{ return this.name; }-*/;

    public final native String getPath() /*-{ return this.path; }-*/;

    public final native String getContent() /*-{ return this.content; }-*/;
    
    public final String getDecodedContent() {return Base64.decode(getContent());}

    public final native String getSha() /*-{ return this.sha; }-*/;
    
    public static class Links extends JavaScriptObject {
        protected Links() {
        }
        public final native String getGit() /*-{ return this.git; }-*/;
        public final native String getSelf() /*-{ return this.self; }-*/;
        public final native String getHtml() /*-{ return this.html; }-*/;
    }
}
