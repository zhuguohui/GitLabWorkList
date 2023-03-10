package org.example.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PushDataBean implements Serializable {
    /**
     * commit_count : 1
     * action : pushed
     * ref_type : branch
     * commit_from : 7d97807f83f7a0990e8d5e5cc66c727545cc5f5c
     * commit_to : 9fefb441a554085bcb75ce1fa0c5c34a8d4c4bb2
     * ref : 中国贵州
     * commit_title : 解决getValue函数的bug
     * ref_count : null
     */

    @SerializedName("commit_count")
    private int commitCount;
    @SerializedName("action")
    private String action;
    @SerializedName("ref_type")
    private String refType;
    @SerializedName("commit_from")
    private String commitFrom;
    @SerializedName("commit_to")
    private String commitTo;
    @SerializedName("ref")
    private String ref;
    @SerializedName("commit_title")
    private String commitTitle;
    @SerializedName("ref_count")
    private Object refCount;

    public int getCommitCount() {
        return commitCount;
    }

    public void setCommitCount(int commitCount) {
        this.commitCount = commitCount;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getRefType() {
        return refType;
    }

    public void setRefType(String refType) {
        this.refType = refType;
    }

    public String getCommitFrom() {
        return commitFrom;
    }

    public void setCommitFrom(String commitFrom) {
        this.commitFrom = commitFrom;
    }

    public String getCommitTo() {
        return commitTo;
    }

    public void setCommitTo(String commitTo) {
        this.commitTo = commitTo;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getCommitTitle() {
        return commitTitle;
    }

    public void setCommitTitle(String commitTitle) {
        this.commitTitle = commitTitle;
    }

    public Object getRefCount() {
        return refCount;
    }

    public void setRefCount(Object refCount) {
        this.refCount = refCount;
    }
}
