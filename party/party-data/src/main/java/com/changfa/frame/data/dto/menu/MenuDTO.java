package com.changfa.frame.data.dto.menu;

import java.io.Serializable;
import java.util.Date;

public class MenuDTO implements Serializable {

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCmsCategoryId() {
        return cmsCategoryId;
    }

    public void setCmsCategoryId(Integer cmsCategoryId) {
        this.cmsCategoryId = cmsCategoryId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }

    public Integer getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHrefType() {
        return hrefType;
    }

    public void setHrefType(String hrefType) {
        this.hrefType = hrefType;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
