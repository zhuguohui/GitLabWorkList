package org.example.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserInfo implements Serializable {

    /**
     * id : 13
     * name : zhu.guohui
     * username : zhu.guohui
     * state : active
     * avatar_url : http://192.168.210.40:180/uploads/-/system/user/avatar/13/avatar.png
     * web_url : http://192.168.210.40:180/zhu.guohui
     */

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("username")
    private String username;
    @SerializedName("state")
    private String state;
    @SerializedName("avatar_url")
    private String avatarUrl;
    @SerializedName("web_url")
    private String webUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }
}
