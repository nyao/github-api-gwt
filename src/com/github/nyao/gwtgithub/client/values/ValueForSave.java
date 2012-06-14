package com.github.nyao.gwtgithub.client.values;

import java.util.HashMap;

import com.google.gwt.core.client.JsonUtils;

public abstract class ValueForSave<T extends GHProp> {

    HashMap<T, Object> prop = new HashMap<T, Object>();

    public String toJson() {
        StringBuilder request = new StringBuilder();
        boolean start = true; // dirty but effective...
        for (T key : prop.keySet()) {
            if (!start) request.append(", "); else start = false;
            
            Object value = prop.get(key);
            if (value instanceof String)
                request.append("\"" + key.value() + "\": " + JsonUtils.escapeValue((String) value));
            else if (value instanceof Integer)
                request.append("\"" + key.value() + "\": " + value);
            else if (value instanceof String[]) {
                String[] vs = (String[]) value;
                request.append("\"" + key.value() + "\": [");
                boolean startV = true;
                for (String v : vs) {
                    if (!startV) request.append(", "); else startV = false;
                    request.append(JsonUtils.escapeValue(v));
                }
                request.append("]");
            }
            else if (value == null)
                request.append("\"" + key.value() + "\": null");
        }
        return "{" + request.toString() + "}";
	}
}
