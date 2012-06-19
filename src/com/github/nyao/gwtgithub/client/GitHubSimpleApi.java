package com.github.nyao.gwtgithub.client;

import com.github.nyao.gwtgithub.client.models.AJSON;
import com.github.nyao.gwtgithub.client.models.Repo;
import com.github.nyao.gwtgithub.client.models.gitdata.Blob;
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
    
    public void getBlob(Reference ref, final String filename, final AsyncCallback<AJSON<Blob>> callback) {
        api.getCommit(ref, new AsyncCallback<AJSON<Commit>>() {
            @Override
            public void onSuccess(AJSON<Commit> result) {
                Commit commit = result.getData();
                api.getTree(repo, commit.getSha(), new AsyncCallback<AJSON<Tree>>() {
                    @Override
                    public void onSuccess(AJSON<Tree> result) {
                        Tree tree = result.getData();
                        findTree(tree, filename);
                        api.getBlob(repo, tree.getTree().get(0).getSha(), new AsyncCallback<AJSON<Blob>>() {
                            @Override
                            public void onSuccess(AJSON<Blob> result) {
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
    
    private Tree findTree(Tree tree, String filename) {
        for (int i = 0; i < tree.getTree().length();i ++) {
            Tree target = tree.getTree().get(i);
            if (target.getPath().equals(filename)) return target;
        }
        return null;
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
        blob.setEncoding("utf-8");
        blob.setContent(content);
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
                tree[0].setMode("100755");
                
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
