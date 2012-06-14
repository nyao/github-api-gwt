package com.github.nyao.gwtgithub.client.values;

import com.github.nyao.gwtgithub.client.models.Issue.Prop;

public class IssueForSave extends ValueForSave<Prop> {
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
