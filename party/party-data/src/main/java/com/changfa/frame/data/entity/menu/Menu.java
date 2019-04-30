package com.changfa.frame.data.entity.menu;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "menu")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class Menu {
    private Integer id;
    private Integer cmsCategoryId;
    private Integer companyId;
    private Integer parentId;
    private String articleType;
    private Integer menuLevel;
    private String name;
    private String hrefType;
    private String href;
    private String code;
    private Integer seq;
    private String status;
    private Date statusTime;
    private Date createTime;

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
    @Column(name = "cms_category_id", nullable = false)
    public Integer getCmsCategoryId() {
        return cmsCategoryId;
    }

    public void setCmsCategoryId(Integer cmsCategoryId) {
        this.cmsCategoryId = cmsCategoryId;
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
    @Column(name = "parent_id", nullable = false)
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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
    @Column(name = "menu_level", nullable = true)
    public Integer getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 32)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "href_type", nullable = true, length = 2)
    public String getHrefType() {
        return hrefType;
    }

    public void setHrefType(String hrefType) {
        this.hrefType = hrefType;
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
    @Column(name = "code", nullable = true, length = 32)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
    @Column(name = "create_time", nullable = true)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return id == menu.id &&
                cmsCategoryId == menu.cmsCategoryId &&
                companyId == menu.companyId &&
                parentId == menu.parentId &&
                Objects.equals(articleType, menu.articleType) &&
                Objects.equals(menuLevel, menu.menuLevel) &&
                Objects.equals(name, menu.name) &&
                Objects.equals(hrefType, menu.hrefType) &&
                Objects.equals(href, menu.href) &&
                Objects.equals(code, menu.code) &&
                Objects.equals(seq, menu.seq) &&
                Objects.equals(status, menu.status) &&
                Objects.equals(statusTime, menu.statusTime) &&
                Objects.equals(createTime, menu.createTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, cmsCategoryId, companyId, parentId, articleType, menuLevel, name, hrefType, href, code, seq, status, statusTime, createTime);
    }
}
