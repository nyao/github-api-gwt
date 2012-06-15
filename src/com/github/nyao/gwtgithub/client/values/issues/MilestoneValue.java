package com.github.nyao.gwtgithub.client.values.issues;

import java.util.Date;

import com.github.nyao.gwtgithub.client.values.GHValue;
import com.github.nyao.gwtgithub.client.values.ValueProp;

public class MilestoneValue extends GHValue<MilestoneValue.Prop> {

    public static enum Prop implements ValueProp {
        title("title"),
        description("description"),
        state("state"),
        due_on("due_on");

        private final String value;
        
        private Prop(String value) {
            this.value = value;
        }

        @Override
        public String value() {
            return value;
        }
    }
    
	public void setTitle(String title) {
		prop.put(Prop.title, title);
	}
	
	public void setState(String state) {
		prop.put(Prop.state, state);
	}

	public void setDescription(String description) {
		prop.put(Prop.description, description);
	}

	public void setDueOn(Date dueOn) {
		prop.put(Prop.due_on, dueOn);
	}
}
