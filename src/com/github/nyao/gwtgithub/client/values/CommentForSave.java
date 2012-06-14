package com.github.nyao.gwtgithub.client.values;

import com.github.nyao.gwtgithub.client.models.Comment.Prop;

public class CommentForSave extends ValueForSave<GHProp> {
	
	public void setBody(String body) {
		prop.put(Prop.Body, body);
	}
}
