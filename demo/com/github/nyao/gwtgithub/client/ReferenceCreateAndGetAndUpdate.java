package com.github.nyao.gwtgithub.client;

import java.util.Date;

import com.github.nyao.gwtgithub.client.models.AJSON;
import com.github.nyao.gwtgithub.client.models.Repo;
import com.github.nyao.gwtgithub.client.models.gitdata.Reference;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ReferenceCreateAndGetAndUpdate implements EntryPoint {

    private final GitHubApi api = new GitHubApi();
    private Repo repo;

    @Override
    public void onModuleLoad() {
        
        api.setAccessToken("token");
        api.getRepo("login", "repo", new AsyncCallback<AJSON<Repo>>() {
            @Override
            public void onSuccess(AJSON<Repo> result) {
                repo = result.getData();
                api.getReferenceHead(repo, "boostgh", new AsyncCallback<AJSON<Reference>>() {
                    @Override
                    public void onSuccess(AJSON<Reference> result) {
                        Reference ref = result.getData();
                        System.out.println(ref.getRef());
                        System.out.println(ref.getUrl());
                        api.createSimpleCommitAndPush(repo, ref, "order.txt", 
                                                      new Date().toString(), "a message", 
                                                      new AsyncCallback<Reference>() {
                            @Override
                            public void onSuccess(Reference result) {
                                System.out.println(result.getRef());
                                System.out.println(result.getUrl());
                            }
                            
                            @Override
                            public void onFailure(Throwable caught) {
                                caught.printStackTrace();
                            }
                        });
                    }
                    
                    @Override
                    public void onFailure(Throwable caught) {
                        caught.printStackTrace();
                    }
                });
            }
            
            @Override
            public void onFailure(Throwable caught) {
                caught.printStackTrace();
            }
        });
    }

}
