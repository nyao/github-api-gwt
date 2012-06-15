package com.github.nyao.gwtgithub.client.values;

public class BlobValue extends GHValue<BlobValue.Prop> {

    public static enum Prop implements ValueProp {
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

    public void setContent(String content) {
        prop.put(Prop.Content, content);
    }

    public void setEncoding(String encoding) {
        prop.put(Prop.Encoding, encoding);
    }
}
