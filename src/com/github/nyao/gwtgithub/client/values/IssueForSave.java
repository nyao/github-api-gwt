package com.github.nyao.gwtgithub.client.values;

import com.github.nyao.gwtgithub.client.models.Issue.Prop;

public class IssueForSave extends ValueForSave<Prop> {
	public void setTitle(String title) {
		prop.put(Prop.title, title);
	}
	
	public void setBody(String body) {
		prop.put(Prop.body, body);
	}

	public void setAsignee(String user) {
		prop.put(Prop.assignee, user);
	}

	public void setMilestone(Integer number) {
		prop.put(Prop.milestone, number);
	}

	public void setLabels(String[] labels) {
		prop.put(Prop.labels, labels);
	}
}
