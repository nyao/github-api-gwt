package com.github.nyao.gwtgithub.client;

import com.github.nyao.gwtgithub.client.models.Repo;
import com.github.nyao.gwtgithub.client.models.gitdata.BlobCreated;
import com.github.nyao.gwtgithub.client.models.gitdata.Commit;
import com.github.nyao.gwtgithub.client.models.gitdata.Reference;
import com.github.nyao.gwtgithub.client.models.gitdata.Tree;
import com.github.nyao.gwtgithub.client.values.gitdata.BlobValue;
import com.github.nyao.gwtgithub.client.values.gitdata.CommitValue;
import com.github.nyao.gwtgithub.client.values.gitdata.ReferenceUpdateValue;
import com.github.nyao.gwtgithub.client.values.gitdata.TreeValue;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class GitHubSimpleApi {
    private GitHubApi api;
    private Repo repo;
    
    public GitHubSimpleApi(GitHubApi api, Repo repo) {
        this.api = api;
        this.repo = repo;
    }

    public void createSimpleCommitAndPush(final Reference ref, 
                                          final String filename, 
                                          final String content, 
                                          final String message,
                                          final AsyncCallback<Reference> callback) {
        createSimpleCommit(ref, filename, content, message, new AsyncCallback<Commit>() {
            @Override
            public void onSuccess(Commit commit) {
                ReferenceUpdateValue ruv = new ReferenceUpdateValue();
                ruv.setSha(commit.getSha());
                api.updateReference(repo, ref, ruv, callback);
            }
            
            @Override
            public void onFailure(Throwable caught) {
                callback.onFailure(caught);
            }
        });
    }

    public void createSimpleCommit(final Reference ref, 
                                   final String filename, 
                                   final String content, 
                                   final String message,
                                   final AsyncCallback<Commit> callback) {
        BlobValue blob = new BlobValue();
        blob.setContent(content);
        blob.setEncoding("utf-8");
        api.createBlob(repo, blob, new AsyncCallback<BlobCreated>() {
            @Override
            public void onSuccess(BlobCreated blob) {
                TreeValue rootTree = new TreeValue();
                TreeValue[] tree = new TreeValue[1];
                rootTree.setTree(tree);
                tree[0] = new TreeValue();
                tree[0].setSha(blob.getSha());
                tree[0].setPath(filename);
                tree[0].setType("blob");
                tree[0].setMode("100666");
                
                api.createTree(repo, rootTree, new AsyncCallback<Tree>() {
                    @Override
                    public void onSuccess(Tree tree) {
                        CommitValue commit = new CommitValue();
                        commit.setMessage(message);
                        commit.setTree(tree.getSha());
                        if (ref != null) {
                            commit.setParent(ref.getObject().getSha());
                        }
                        
                        api.createCommit(repo, commit, new AsyncCallback<Commit>() {
                            @Override
                            public void onSuccess(Commit result) {
                                callback.onSuccess(result);
                            }
                            
                            @Override
                            public void onFailure(Throwable caught) {
                                callback.onFailure(caught);
                            }
                        });
                    }

                    @Override
                    public void onFailure(Throwable caught) {
                        callback.onFailure(caught);
                    }
                });
            }

            @Override
            public void onFailure(Throwable caught) {
                callback.onFailure(caught);
            }
        });
    }
}
