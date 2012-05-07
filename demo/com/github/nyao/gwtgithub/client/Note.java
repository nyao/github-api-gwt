package com.github.nyao.gwtgithub.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;

public class Note implements EntryPoint {

    private static final String post_url = "...";

    @Override
    public void onModuleLoad() {
      RequestBuilder builder = new RequestBuilder(RequestBuilder.POST, post_url);
      
      try {
          builder.sendRequest("{\"title\": \"hogehoge\"}", new RequestCallback() {
              @Override
              public void onResponseReceived(Request request, Response response) {
                  System.out.println(response.getStatusCode());
                  System.out.println(response.getText());
              }
              
              @Override
              public void onError(Request request, Throwable exception) {
                  exception.printStackTrace();
              }
          });
      } catch (RequestException e) {
          e.printStackTrace();
      }
    }
}
