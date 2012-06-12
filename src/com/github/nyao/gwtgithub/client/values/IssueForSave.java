package com.github.nyao.gwtgithub.client.values;

import java.util.HashMap;

import com.github.nyao.gwtgithub.client.models.Issue;
import com.github.nyao.gwtgithub.client.models.Issue.Prop;
import com.google.gwt.core.client.JsonUtils;

public class IssueForSave {
	HashMap<Issue.Prop, Object> prop = new HashMap<Issue.Prop, Object>();
	
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
	
	public String toJson() {
        StringBuilder request = new StringBuilder();
        boolean start = true; // dirty but effective...
        for (Issue.Prop key : prop.keySet()) {
            if (!start) request.append(", "); else start = false;
            
            Object value = prop.get(key);
            if (value instanceof String)
                request.append("\"" + key.name() + "\": " + JsonUtils.escapeValue((String) value));
            else if (value instanceof Integer)
                request.append("\"" + key.name() + "\": " + value);
            else if (value instanceof String[]) {
                String[] vs = (String[]) value;
                request.append("\"" + key.name() + "\": [");
                boolean startV = true;
                for (String v : vs) {
                    if (!startV) request.append(", "); else startV = false;
                    request.append(JsonUtils.escapeValue(v) + ",");
                }
                request.append("]");
            }
            else if (value == null)
                request.append("\"" + key.name() + "\": null");
        }
        return "{" + request.toString() + "}";
	}
}
