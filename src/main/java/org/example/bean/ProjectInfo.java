package org.example.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;


public class ProjectInfo implements Serializable {

    /**
     * id : 1731
     * description : 西藏网信办（舆情）APP
     * name : WXB-舆情
     * name_with_namespace : cdtrs / 移动开发部 / 网信行业 / 西藏网信办 / WXB-舆情
     * path : wxb-yq-flutter
     * path_with_namespace : cdtrs/application/wxb/wxb-xz/wxb-yq-flutter
     * created_at : 2021-10-25T10:27:18.747+08:00
     * default_branch : master
     * tag_list : []
     * ssh_url_to_repo : ssh://git@192.168.210.40:10010/cdtrs/application/wxb/wxb-xz/wxb-yq-flutter.git
     * http_url_to_repo : https://git.trscd.com.cn/cdtrs/application/wxb/wxb-xz/wxb-yq-flutter.git
     * web_url : http://192.168.210.40:180/cdtrs/application/wxb/wxb-xz/wxb-yq-flutter
     * readme_url : http://192.168.210.40:180/cdtrs/application/wxb/wxb-xz/wxb-yq-flutter/-/blob/master/README.md
     * avatar_url : null
     * forks_count : 0
     * star_count : 0
     * last_activity_at : 2023-03-02T15:51:29.184+08:00
     */

    @SerializedName("id")
    private int id;
    @SerializedName("description")
    private String description;
    @SerializedName("name")
    private String name;
    @SerializedName("name_with_namespace")
    private String nameWithNamespace;
    @SerializedName("path")
    private String path;
    @SerializedName("path_with_namespace")
    private String pathWithNamespace;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("default_branch")
    private String defaultBranch;
    @SerializedName("ssh_url_to_repo")
    private String sshUrlToRepo;
    @SerializedName("http_url_to_repo")
    private String httpUrlToRepo;
    @SerializedName("web_url")
    private String webUrl;
    @SerializedName("readme_url")
    private String readmeUrl;
    @SerializedName("avatar_url")
    private Object avatarUrl;
    @SerializedName("forks_count")
    private int forksCount;
    @SerializedName("star_count")
    private int starCount;
    @SerializedName("last_activity_at")
    private String lastActivityAt;
    @SerializedName("tag_list")
    private List<?> tagList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameWithNamespace() {
        return nameWithNamespace;
    }

    public void setNameWithNamespace(String nameWithNamespace) {
        this.nameWithNamespace = nameWithNamespace;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPathWithNamespace() {
        return pathWithNamespace;
    }

    public void setPathWithNamespace(String pathWithNamespace) {
        this.pathWithNamespace = pathWithNamespace;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDefaultBranch() {
        return defaultBranch;
    }

    public void setDefaultBranch(String defaultBranch) {
        this.defaultBranch = defaultBranch;
    }

    public String getSshUrlToRepo() {
        return sshUrlToRepo;
    }

    public void setSshUrlToRepo(String sshUrlToRepo) {
        this.sshUrlToRepo = sshUrlToRepo;
    }

    public String getHttpUrlToRepo() {
        return httpUrlToRepo;
    }

    public void setHttpUrlToRepo(String httpUrlToRepo) {
        this.httpUrlToRepo = httpUrlToRepo;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getReadmeUrl() {
        return readmeUrl;
    }

    public void setReadmeUrl(String readmeUrl) {
        this.readmeUrl = readmeUrl;
    }

    public Object getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(Object avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public int getForksCount() {
        return forksCount;
    }

    public void setForksCount(int forksCount) {
        this.forksCount = forksCount;
    }

    public int getStarCount() {
        return starCount;
    }

    public void setStarCount(int starCount) {
        this.starCount = starCount;
    }

    public String getLastActivityAt() {
        return lastActivityAt;
    }

    public void setLastActivityAt(String lastActivityAt) {
        this.lastActivityAt = lastActivityAt;
    }

    public List<?> getTagList() {
        return tagList;
    }

    public void setTagList(List<?> tagList) {
        this.tagList = tagList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectInfo that = (ProjectInfo) o;
        return id == that.id && forksCount == that.forksCount && starCount == that.starCount && Objects.equals(description, that.description) && Objects.equals(name, that.name) && Objects.equals(nameWithNamespace, that.nameWithNamespace) && Objects.equals(path, that.path) && Objects.equals(pathWithNamespace, that.pathWithNamespace) && Objects.equals(createdAt, that.createdAt) && Objects.equals(defaultBranch, that.defaultBranch) && Objects.equals(sshUrlToRepo, that.sshUrlToRepo) && Objects.equals(httpUrlToRepo, that.httpUrlToRepo) && Objects.equals(webUrl, that.webUrl) && Objects.equals(readmeUrl, that.readmeUrl) && Objects.equals(avatarUrl, that.avatarUrl) && Objects.equals(lastActivityAt, that.lastActivityAt) && Objects.equals(tagList, that.tagList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, name, nameWithNamespace, path, pathWithNamespace, createdAt, defaultBranch, sshUrlToRepo, httpUrlToRepo, webUrl, readmeUrl, avatarUrl, forksCount, starCount, lastActivityAt, tagList);
    }
}
