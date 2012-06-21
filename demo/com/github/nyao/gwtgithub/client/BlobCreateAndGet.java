package com.github.nyao.gwtgithub.client;

import com.github.nyao.gwtgithub.client.models.AJSON;
import com.github.nyao.gwtgithub.client.models.gitdata.Blob;
import com.github.nyao.gwtgithub.client.models.gitdata.BlobCreated;
import com.github.nyao.gwtgithub.client.models.repos.Repo;
import com.github.nyao.gwtgithub.client.util.Base64;
import com.github.nyao.gwtgithub.client.values.gitdata.BlobValue;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class BlobCreateAndGet implements EntryPoint {

    private final GitHubApi api = new GitHubApi();
    private Repo repo;

    @Override
    public void onModuleLoad() {
        
        api.setAccessToken("");
        api.getRepo("", "", new AsyncCallback<AJSON<Repo>>() {
            @Override
            public void onSuccess(AJSON<Repo> result) {
                repo = result.getData();
                BlobValue value = new BlobValue();
                value.setContent("Content of the blob");
                value.setEncoding("utf-8");
                api.createBlob(repo, value, new AsyncCallback<BlobCreated>() {
                    @Override
                    public void onSuccess(BlobCreated result) {
                        api.getBlob(repo, result.getSha(), new AsyncCallback<AJSON<Blob>>() {
                            @Override
                            public void onSuccess(AJSON<Blob> result) {
                                Blob blob = result.getData();
                                System.out.println("--");
                                System.out.println(blob.getEncoding());
                                System.out.println(blob.getContent());
                                System.out.println(Base64.decode(blob.getContent()));
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
