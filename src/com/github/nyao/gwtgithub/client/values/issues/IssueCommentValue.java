package com.github.nyao.gwtgithub.client.values.issues;

import com.github.nyao.gwtgithub.client.values.GHValue;
import com.github.nyao.gwtgithub.client.values.ValueProp;

public class IssueCommentValue extends GHValue<IssueCommentValue.Prop> {

    public static enum Prop implements ValueProp {
        Body("body"), ;

        private final String value;

        private Prop(String value) {
            this.value = value;
        }

        @Override
        public String value() {
            return value;
        }
    }

    public void setBody(String body) {
        prop.put(Prop.Body, body);
    }
}
