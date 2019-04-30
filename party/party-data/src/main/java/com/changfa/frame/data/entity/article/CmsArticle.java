package com.changfa.frame.data.entity.article;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import org.junit.ClassRule;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "cms_article")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class CmsArticle {

    private Integer id;
    private Integer companyId;
    private Integer categoryId;
    private String title;
    private String isLink;
    private String link;
    private String isStick;
    private Date pressTime;
    private String images;
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
    private String type;
    private Date statusTime;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "company_id", nullable = false)
    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "category_id", nullable = false)
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 255)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "is_link", nullable = true, length = 2)
    public String getIsLink() {
        return isLink;
    }

    public void setIsLink(String isLink) {
        this.isLink = isLink;
    }

    @Basic
    @Column(name = "link", nullable = true, length = 255)
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Basic
    @Column(name = "is_stick", nullable = true, length = 2)
    public String getIsStick() {
        return isStick;
    }

    public void setIsStick(String isStick) {
        this.isStick = isStick;
    }

    @Basic
    @Column(name = "press_time", nullable = true)
    public Date getPressTime() {
        return pressTime;
    }

    public void setPressTime(Date pressTime) {
        this.pressTime = pressTime;
    }

    @Basic
    @Column(name = "images", nullable = true, length = 500)
    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    @Basic
    @Column(name = "author", nullable = true, length = 32)
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "summary", nullable = true, length = 500)
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Basic
    @Column(name = "descri", nullable = true, length = 255)
    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    @Basic
    @Column(name = "source", nullable = true, length = 255)
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Basic
    @Column(name = "posid", nullable = true, length = 10)
    public String getPosid() {
        return posid;
    }

    public void setPosid(String posid) {
        this.posid = posid;
    }

    @Basic
    @Column(name = "release_time", nullable = true)
    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    @Basic
    @Column(name = "ineffective_time", nullable = true)
    public Date getIneffectiveTime() {
        return ineffectiveTime;
    }

    public void setIneffectiveTime(Date ineffectiveTime) {
        this.ineffectiveTime = ineffectiveTime;
    }

    @Basic
    @Column(name = "create_by", nullable = true)
    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    @Basic
    @Column(name = "create_time", nullable = true)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_by", nullable = true)
    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    @Basic
    @Column(name = "update_time", nullable = true)
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "status", nullable = true, length = 2)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "status_time", nullable = true)
    public Date getStatusTime() {
        return statusTime;
    }

    public void setStatusTime(Date statusTime) {
        this.statusTime = statusTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CmsArticle that = (CmsArticle) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(companyId, that.companyId) &&
                Objects.equals(categoryId, that.categoryId) &&
                Objects.equals(title, that.title) &&
                Objects.equals(isLink, that.isLink) &&
                Objects.equals(link, that.link) &&
                Objects.equals(isStick, that.isStick) &&
                Objects.equals(pressTime, that.pressTime) &&
                Objects.equals(images, that.images) &&
                Objects.equals(author, that.author) &&
                Objects.equals(summary, that.summary) &&
                Objects.equals(descri, that.descri) &&
                Objects.equals(source, that.source) &&
                Objects.equals(posid, that.posid) &&
                Objects.equals(releaseTime, that.releaseTime) &&
                Objects.equals(ineffectiveTime, that.ineffectiveTime) &&
                Objects.equals(createBy, that.createBy) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateBy, that.updateBy) &&
                Objects.equals(updateTime, that.updateTime) &&
                Objects.equals(status, that.status) &&
                Objects.equals(statusTime, that.statusTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, companyId, categoryId, title, isLink, link, isStick, pressTime, images, author, summary, descri, source, posid, releaseTime, ineffectiveTime, createBy, createTime, updateBy, updateTime, status, statusTime);
    }
}
