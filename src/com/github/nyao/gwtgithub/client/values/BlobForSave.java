package com.github.nyao.gwtgithub.client.values;

import com.github.nyao.gwtgithub.client.models.Blob.Prop;

public class BlobForSave extends ValueForSave<GHProp> {

    public void setContent(String content) {
        prop.put(Prop.Content, content);
    }

    public void setEncoding(String encoding) {
        prop.put(Prop.Encoding, encoding);
    }
}
