package com.github.nyao.gwtgithub.client.values;


public class RepoValue extends GHValue<RepoValue.Prop> {

    public static enum Prop implements ValueProp {
        Name("name"),
        Description("description"),
        Homepage("homepage"),
        Private("private"),
        HasIssues("has_issues"),
        HasWiki("has_wiki"),
        HasDownload("has_downloads"),
        TeamID("team_id"),
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
    
    public void setName(String name) {
        prop.put(Prop.Name, name);
    }

    public void setDescription(String desc) {
        prop.put(Prop.Description, desc);
    }

    public void setHomepage(String homepage) {
        prop.put(Prop.Homepage, homepage);
    }

    public void setPrivate(Boolean value) {
        prop.put(Prop.Private, value);
    }

    public void setHasIssues(Boolean hasIssues) {
        prop.put(Prop.HasIssues, hasIssues);
    }

    public void setHasWiki(Boolean hasWiki) {
        prop.put(Prop.HasWiki, hasWiki);
    }

    public void setHasDownload(Boolean hasDownload) {
        prop.put(Prop.HasDownload, hasDownload);
    }

    public void setTeamID(Integer teamId) { // create only
        prop.put(Prop.Name, teamId);
    }
}
