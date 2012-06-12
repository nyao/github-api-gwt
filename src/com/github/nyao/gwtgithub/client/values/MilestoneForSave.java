package com.github.nyao.gwtgithub.client.values;

import java.util.Date;

import com.github.nyao.gwtgithub.client.models.Milestone.Prop;

public class MilestoneForSave extends ValueForSave<Prop> {
	
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
