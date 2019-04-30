package com.changfa.frame.data.dto.user;

import java.util.Date;

/**
 * @Author: Song Kaijie
 * @Date: 2019/4/12
 */
public class UserArticleHistoryDTO {
    private String token;
    private Integer articleHistoryId;
    private Integer articleId;
    private String articleType;
    private String title;
    private String images;
    private Date createTime;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getArticleHistoryId() {
        return articleHistoryId;
    }

    public void setArticleHistoryId(Integer articleHistoryId) {
        this.articleHistoryId = articleHistoryId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
