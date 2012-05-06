package com.github.nyao.gwtgithub.client;

import com.github.nyao.gwtgithub.client.models.Repositories;
import com.google.gwt.jsonp.client.JsonpRequestBuilder;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class GitHubApi {

	private String accessToken = null;
	
	public void setAuthorization(String accessToken) {
		this.accessToken = accessToken;
	}
	
	private static final String BASE_URL = "https://api.github.com/";

	public void getMyRepository(AsyncCallback<Repositories> callback) {
		String url = addAutorization(BASE_URL + "user/repos");
		JsonpRequestBuilder jsonp = new JsonpRequestBuilder();
		jsonp.requestObject(url, callback);
	}
	
	public void getRepositories(String user, AsyncCallback<Repositories> callback) {
		String url = BASE_URL + "users/" + user + "/repos";
		JsonpRequestBuilder jsonp = new JsonpRequestBuilder();
		jsonp.requestObject(url, callback);
	}
	
	private String addAutorization(String url) {
		String prefix = "?";
		if(url.contains("?")) {
			prefix = "&";
		}
		
		url += prefix;

		if(accessToken != null) {
			url += "accessToken=" + accessToken;
		}
		return url;
	}
}
