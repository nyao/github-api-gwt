package com.github.nyao.gwtgithub.client.values.gitdata;

import com.github.nyao.gwtgithub.client.values.GHValue;
import com.github.nyao.gwtgithub.client.values.ValueProp;


public class ReferenceUpdateValue extends GHValue<ReferenceUpdateValue.Prop> {

    public static enum Prop implements ValueProp {
        Sha("sha"),
        Force("force"),
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
    
    public void setForce(String force) {
        prop.put(Prop.Force, force);
    }

    public void setSha(String sha) {
        prop.put(Prop.Sha, sha);
    }
}
