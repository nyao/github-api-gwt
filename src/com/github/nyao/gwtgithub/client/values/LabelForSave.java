package com.github.nyao.gwtgithub.client.values;

import com.github.nyao.gwtgithub.client.models.Label.Prop;

public class LabelForSave extends ValueForSave<Prop> {
	
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
