package com.github.nyao.gwtgithub.client.values.gitdata;

import com.github.nyao.gwtgithub.client.values.GHValue;
import com.github.nyao.gwtgithub.client.values.ValueProp;


public class ReferenceCreateValue extends GHValue<ReferenceCreateValue.Prop> {

    public static enum Prop implements ValueProp {
        Ref("ref"),
        Sha("sha"),
        ;
        public final String value;

        private Prop(String value) {
            this.value = value;
        }

        @Override
        public String value() {
            return value;
        }
    }
    
    public void setRef(String ref) {
        prop.put(Prop.Ref, ref);
    }

    public void setHeadRef(String ref) {
        prop.put(Prop.Ref, "refs/heads/" + ref);
    }

    public void setSha(String sha) {
        prop.put(Prop.Sha, sha);
    }
}
