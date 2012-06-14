package com.github.nyao.gwtgithub.client.values;

import com.github.nyao.gwtgithub.client.models.Repo.Prop;


public class RepoForSave extends ValueForSave<Prop> {

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
