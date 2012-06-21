package com.github.nyao.gwtgithub.client.models.repos;

import java.util.Date;

import com.github.nyao.gwtgithub.client.models.users.GHUser;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;

public class Repo extends JavaScriptObject {
    protected Repo() {
    }

    public final native String getMirrorUrl() /*-{ return this.mirror_url; }-*/;
    
    public final native String getCloneUrl() /*-{ return this.clone_url; }-*/;

    public final native String getDescription() /*-{ return this.description; }-*/;

    public final native boolean HasDownloads() /*-{ return this.has_downloads; }-*/;

    public final native int getWatchers() /*-{ return this.watchers; }-*/;
    
    public final String getWatchersS() {return String.valueOf(getWatchers());}

    public final native String getFullName() /*-{ return this.full_name; }-*/;

    public final native boolean isFork() /*-{ return this.fork; }-*/;

    public final native String getHomepage() /*-{ return this.homepage; }-*/;

    public final native String getSshUrl() /*-{ return this.ssh_url; }-*/;
    
    public final native String getGitUrl() /*-{ return this.git_url; }-*/;

    public final native boolean hasWiki() /*-{ return this.has_wiki; }-*/;

    public final native boolean hasIssues() /*-{ return this.has_issues; }-*/;

    public final native int getForks() /*-{ return this.forks; }-*/;
    
    public final String getForksS() {return String.valueOf(getForks());}

    public final native int getSize() /*-{ return this.size; }-*/;

    public final String getSizeS() {return String.valueOf(getSize());}

    public final native String getSvnUrl() /*-{ return this.svn_url; }-*/;

    public final native boolean isPrivate() /*-{ return this["private"]; }-*/;

    public final native GHUser getOwner() /*-{ return this.owner; }-*/;
    
    public final native String getName() /*-{ return this.name; }-*/;
    
    public final native int openIssues() /*-{ return this.open_issues; }-*/;
    
    public final String openIssuesString() {return String.valueOf(openIssues());}

    public final native int getId() /*-{ return this.id; }-*/;
    
    public final native String getUrl() /*-{ return this.url; }-*/;

    public final native String getLanguage() /*-{ return this.language; }-*/;
    
    public final native String getHtmlUrl() /*-{ return this.html_url; }-*/;

    public final Date getPushedAt() { return DateTimeFormat.getFormat(PredefinedFormat.ISO_8601).parse(this.getPushedAtString()); }
    public final native String getPushedAtString() /*-{ return this.pushed_at; }-*/;

    public final Date getCreatedAt() { return DateTimeFormat.getFormat(PredefinedFormat.ISO_8601).parse(this.getCreatedAtString()); }
    public final native String getCreatedAtString() /*-{ return this.created_at; }-*/;

    public final Date getUpdatedAt() { return DateTimeFormat.getFormat(PredefinedFormat.ISO_8601).parse(this.getUpdatedAtString()); }
    public final native String getUpdatedAtString() /*-{ return this.updated_at; }-*/;
    
    
    // single only
    
    public final native GHUser getOrganization() /*-{ return this.organization; }-*/;

}
