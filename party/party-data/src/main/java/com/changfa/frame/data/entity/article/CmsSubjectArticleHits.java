package com.changfa.frame.data.entity.article;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "cms_subject_article_hits")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class CmsSubjectArticleHits {
    private Integer id;
    private Integer subjectArticleId;
    private String terminalType;
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
    @Column(name = "subject_article_id", nullable = false)
    public Integer getSubjectArticleId() {
        return subjectArticleId;
    }

    public void setSubjectArticleId(Integer subjectArticleId) {
        this.subjectArticleId = subjectArticleId;
    }

    @Basic
    @Column(name = "terminal_type", nullable = true, length = 2)
    public String getTerminalType() {
        return terminalType;
    }

    public void setTerminalType(String terminalType) {
        this.terminalType = terminalType;
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
        CmsSubjectArticleHits that = (CmsSubjectArticleHits) o;
        return id == that.id &&
                subjectArticleId == that.subjectArticleId &&
                Objects.equals(terminalType, that.terminalType) &&
                Objects.equals(createTime, that.createTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, subjectArticleId, terminalType, createTime);
    }
}
