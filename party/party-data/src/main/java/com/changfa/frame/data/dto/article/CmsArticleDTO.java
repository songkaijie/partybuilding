package com.changfa.frame.data.dto.article;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class CmsArticleDTO implements Serializable {
    private Integer articleId;
    private Integer companyId;
    private Integer categoryId;
    private String title;
    private String isLink;
    private String link;
    private String isStick;
    private Date pressTime;
    private String author;
    private String summary;
    private String descri;
    private String source;
    private String posid;
    private Date releaseTime;
    private Date ineffectiveTime;
    private Integer createBy;
    private Date createTime;
    private Integer updateBy;
    private Date updateTime;
    private String status;
    private Date statusTime;
    private String content;
    private List<String> images;
    private String detail;
    private List<Map<String, Object>> relation;
    private int hits;
    private String articleType;
    private String image;
    private String subjectTitle;
    private Integer subjectArticleId;


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSubjectTitle() {
        return subjectTitle;
    }

    public void setSubjectTitle(String subjectTitle) {
        this.subjectTitle = subjectTitle;
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

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsLink() {
        return isLink;
    }

    public void setIsLink(String isLink) {
        this.isLink = isLink;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getIsStick() {
        return isStick;
    }

    public void setIsStick(String isStick) {
        this.isStick = isStick;
    }

    public Date getPressTime() {
        return pressTime;
    }

    public void setPressTime(Date pressTime) {
        this.pressTime = pressTime;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPosid() {
        return posid;
    }

    public void setPosid(String posid) {
        this.posid = posid;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Date getIneffectiveTime() {
        return ineffectiveTime;
    }

    public void setIneffectiveTime(Date ineffectiveTime) {
        this.ineffectiveTime = ineffectiveTime;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStatusTime() {
        return statusTime;
    }

    public void setStatusTime(Date statusTime) {
        this.statusTime = statusTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public List<Map<String, Object>> getRelation() {
        return relation;
    }

    public void setRelation(List<Map<String, Object>> relation) {
        this.relation = relation;
    }

    public Integer getSubjectArticleId() {
        return subjectArticleId;
    }

    public void setSubjectArticleId(Integer subjectArticleId) {
        this.subjectArticleId = subjectArticleId;
    }
}
