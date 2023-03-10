package org.example.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WorkInfo implements Serializable {

    /**
     * id : 257520
     * project_id : 1270
     * action_name : pushed to
     * target_id : null
     * target_iid : null
     * target_type : null
     * author_id : 13
     * target_title : null
     * created_at : 2023-03-03T18:13:14.562+08:00
     * author : {"id":13,"name":"zhu.guohui","username":"zhu.guohui","state":"active","avatar_url":"http://192.168.210.40:180/uploads/-/system/user/avatar/13/avatar.png","web_url":"http://192.168.210.40:180/zhu.guohui"}
     * push_data : {"commit_count":1,"action":"pushed","ref_type":"branch","commit_from":"7d97807f83f7a0990e8d5e5cc66c727545cc5f5c","commit_to":"9fefb441a554085bcb75ce1fa0c5c34a8d4c4bb2","ref":"中国贵州","commit_title":"解决getValue函数的bug","ref_count":null}
     * author_username : zhu.guohui
     */

    @SerializedName("id")
    private int id;
    @SerializedName("project_id")
    private int projectId;
    @SerializedName("action_name")
    private String actionName;
    @SerializedName("target_id")
    private Object targetId;
    @SerializedName("target_iid")
    private Object targetIid;
    @SerializedName("target_type")
    private Object targetType;
    @SerializedName("author_id")
    private int authorId;
    @SerializedName("target_title")
    private Object targetTitle;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("author")
    private AuthorBean author;
    @SerializedName("push_data")
    private PushDataBean pushData;
    @SerializedName("author_username")
    private String authorUsername;

    private ProjectInfo projectInfo;

    public ProjectInfo getProjectInfo() {
        return projectInfo;
    }

    public void setProjectInfo(ProjectInfo projectInfo) {
        this.projectInfo = projectInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public Object getTargetId() {
        return targetId;
    }

    public void setTargetId(Object targetId) {
        this.targetId = targetId;
    }

    public Object getTargetIid() {
        return targetIid;
    }

    public void setTargetIid(Object targetIid) {
        this.targetIid = targetIid;
    }

    public Object getTargetType() {
        return targetType;
    }

    public void setTargetType(Object targetType) {
        this.targetType = targetType;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public Object getTargetTitle() {
        return targetTitle;
    }

    public void setTargetTitle(Object targetTitle) {
        this.targetTitle = targetTitle;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public AuthorBean getAuthor() {
        return author;
    }

    public void setAuthor(AuthorBean author) {
        this.author = author;
    }

    public PushDataBean getPushData() {
        return pushData;
    }

    public void setPushData(PushDataBean pushData) {
        this.pushData = pushData;
    }

    public String getAuthorUsername() {
        return authorUsername;
    }

    public void setAuthorUsername(String authorUsername) {
        this.authorUsername = authorUsername;
    }
}
