package com.github.nyao.gwtgithub.client.values;

public class LabelValue extends GHValue<LabelValue.Prop> {

    public static enum Prop implements ValueProp {
        Url("url"), Name("name"), Color("color");

        private final String value;

        private Prop(String value) {
            this.value = value;
        }

        @Override
        public String value() {
            return value;
        }
    }

    public void setName(String name) {
        prop.put(Prop.Name, name);
    }

    public void setColor(String color) {
        prop.put(Prop.Color, color);
    }

    public void setUrl(String url) {
        prop.put(Prop.Url, url);
    }
}
