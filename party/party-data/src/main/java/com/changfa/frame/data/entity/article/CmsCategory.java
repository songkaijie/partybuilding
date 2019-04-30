package com.changfa.frame.data.entity.article;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "cms_category")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class CmsCategory {
    private Integer id;
    private Integer companyId;
    private Integer siteId;
    private Integer parentId;
    private Integer categoryStyleId;
    private Integer articleTypeId;
    private Integer level;
    private String name;
    private String articleType;
    private String href;
    private String hrefType;
    private String images;
    private Integer seq;
    private String descri;
    private Date onlineTime;
    private String status;
    private Date statusTime;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;

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
    @Column(name = "site_id", nullable = true)
    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    @Basic
    @Column(name = "parent_id", nullable = false)
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "article_type_id")
    public Integer getArticleTypeId() {
        return articleTypeId;
    }

    public void setArticleTypeId(Integer articleTypeId) {
        this.articleTypeId = articleTypeId;
    }

    @Basic
    @Column(name = "category_style_id", nullable = true)
    public Integer getCategoryStyleId() {
        return categoryStyleId;
    }

    public void setCategoryStyleId(Integer categoryStyleId) {
        this.categoryStyleId = categoryStyleId;
    }

    @Basic
    @Column(name = "level", nullable = false)
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "article_type", nullable = true, length = 2)
    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }

    @Basic
    @Column(name = "href", nullable = true, length = 255)
    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }


    @Basic
    @Column(name = "href_type")
    public String getHrefType() {
        return hrefType;
    }

    public void setHrefType(String hrefType) {
        this.hrefType = hrefType;
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
    @Column(name = "seq", nullable = true)
    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
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
    @Column(name = "online_time", nullable = true)
    public Date getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(Date onlineTime) {
        this.onlineTime = onlineTime;
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

    @Basic
    @Column(name = "create_by", nullable = true, length = 64)
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
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
    @Column(name = "update_by", nullable = true, length = 64)
    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CmsCategory that = (CmsCategory) o;
        return id == that.id &&
                companyId == that.companyId &&
                parentId == that.parentId &&
                level == that.level &&
                Objects.equals(siteId, that.siteId) &&
                Objects.equals(categoryStyleId, that.categoryStyleId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(articleType, that.articleType) &&
                Objects.equals(href, that.href) &&
                Objects.equals(images, that.images) &&
                Objects.equals(seq, that.seq) &&
                Objects.equals(descri, that.descri) &&
                Objects.equals(onlineTime, that.onlineTime) &&
                Objects.equals(status, that.status) &&
                Objects.equals(statusTime, that.statusTime) &&
                Objects.equals(createBy, that.createBy) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateBy, that.updateBy) &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, companyId, siteId, parentId, categoryStyleId, level, name, articleType, href, images, seq, descri, onlineTime, status, statusTime, createBy, createTime, updateBy, updateTime);
    }
}
