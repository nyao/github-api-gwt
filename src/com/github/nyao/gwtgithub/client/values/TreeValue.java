package com.github.nyao.gwtgithub.client.values;


public class TreeValue extends GHValue<TreeValue.Prop> {

    public static enum Prop implements ValueProp {
        Path("path"),
        Mode("mode"),
        Type("type"),
        Sha("sha"),
        Tree("tree"),
        ;
        public final String value;

        private Prop(String value) {
            this.value = value;
        }

        @Override
        public String value() {
            return value;
        }
    }
    
    public void setPath(String path) {
        prop.put(Prop.Path, path);
    }

    public void setMode(String mode) {
        prop.put(Prop.Mode, mode);
    }

    public void setType(String type) {
        prop.put(Prop.Type, type);
    }

    public void setSha(String sha) {
        prop.put(Prop.Sha, sha);
    }

    public void setTree(TreeValue[] tree) {
        prop.put(Prop.Tree, tree);
    }
}
