package com.github.nyao.gwtgithub.client.values;

import java.util.HashMap;

import com.google.gwt.core.client.JsonUtils;

public abstract class GHValue<T extends ValueProp> {

    protected HashMap<T, Object> prop = new HashMap<T, Object>();

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
            else if (value instanceof Boolean)
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
            } else if (value instanceof GHValue) {
                GHValue<?> v = (GHValue<?>) value;
                request.append("\"" + key.value() + "\": " + v.toJson()); // should be escaped value.
            } else if (value instanceof GHValue[]) {
                GHValue<?>[] vs = (GHValue[]) value;
                request.append("\"" + key.value() + "\": [");
                boolean startV = true;
                for (GHValue<?> v : vs) {
                    if (!startV) request.append(", "); else startV = false;
                    request.append(v.toJson()); // should be escaped value.
                }
                request.append("]");
            } else if (value == null)
                request.append("\"" + key.value() + "\": null");
        }
        return "{" + request.toString() + "}";
	}
}
