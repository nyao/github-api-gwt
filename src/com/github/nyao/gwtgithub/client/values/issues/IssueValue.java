package com.github.nyao.gwtgithub.client.values.issues;

import com.github.nyao.gwtgithub.client.values.GHValue;
import com.github.nyao.gwtgithub.client.values.ValueProp;

public class IssueValue extends GHValue<IssueValue.Prop> {

    public static enum Prop implements ValueProp {
        Title("title"),
        Body("body"),
        Assignee("assignee"),
        State("state"),
        Milestone("milestone"),
        Labels("labels");

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
		prop.put(Prop.Title, title);
	}
	
	public void setBody(String body) {
		prop.put(Prop.Body, body);
	}

	public void setAsignee(String user) {
		prop.put(Prop.Assignee, user);
	}

	public void setMilestone(Integer number) {
		prop.put(Prop.Milestone, number);
	}

	public void setLabels(String[] labels) {
		prop.put(Prop.Labels, labels);
	}
}
