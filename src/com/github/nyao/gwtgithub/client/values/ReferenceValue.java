package com.github.nyao.gwtgithub.client.values;


public class ReferenceValue extends GHValue<ReferenceValue.Prop> {

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

    public void setSha(String sha) {
        prop.put(Prop.Sha, sha);
    }
}
