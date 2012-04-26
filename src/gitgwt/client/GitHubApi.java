package gitgwt.client;

public class GitHubApi {

    public native static void getRepositories(String url, Sample handler) /*-{
        var callback = "foo";
        if (url.indexOf("?") == -1) {
            url += "?callback=" + callback;
        } else {
            url += "&callback=" + callback;
        }
        
        var script = document.createElement("script");
        script.setAttribute("src", url);
        script.setAttribute("type", "text/javascript");
        
        window[callback] = function(jsonObj) {
            handler.@gitgwt.client.Sample::callBackRepositories(Lcom/google/gwt/core/client/JavaScriptObject;)(jsonObj);
            window[callback + "done"] = true;
        }
        
        setTimeout(function() {
            if (!window[callback + "done"]) {
                handler.@gitgwt.client.Sample::callBackRepositories(Lcom/google/gwt/core/client/JavaScriptObject;)(null);
            }
            
            document.body.removeChild(script);
            delete window[callback];
            delete window[callback + "done"];
        }, 1000);
        
        document.body.appendChild(script);
    }-*/;

    public native static void getIssues(String url, Sample handler) /*-{
        var callback = "foo";
        if (url.indexOf("?") == -1) {
            url += "?callback=" + callback;
        } else {
            url += "&callback=" + callback;
        }
        
        var script = document.createElement("script");
        script.setAttribute("src", url);
        script.setAttribute("type", "text/javascript");
        
        window[callback] = function(jsonObj) {
            handler.@gitgwt.client.Sample::callBackIssues(Lcom/google/gwt/core/client/JavaScriptObject;)(jsonObj);
            window[callback + "done"] = true;
        }
        
        setTimeout(function() {
            if (!window[callback + "done"]) {
                handler.@gitgwt.client.Sample::callBackIssues(Lcom/google/gwt/core/client/JavaScriptObject;)(null);
            }
            
            document.body.removeChild(script);
            delete window[callback];
            delete window[callback + "done"];
        }, 1000);
        
        document.body.appendChild(script);
    }-*/;
}
