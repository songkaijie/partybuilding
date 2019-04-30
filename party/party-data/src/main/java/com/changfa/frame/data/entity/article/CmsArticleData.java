package com.changfa.frame.data.entity.article;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cms_article_data")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class CmsArticleData {
    private Integer id;
    private Integer articleId;
    private String content;
    private String relation;

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
    @Column(name = "article_id", nullable = false)
    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    @Basic
    @Column(name = "content", nullable = true, length = 10240)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "relation", nullable = true, length = 255)
    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CmsArticleData that = (CmsArticleData) o;
        return id == that.id &&
                articleId == that.articleId &&
                Objects.equals(content, that.content) &&
                Objects.equals(relation, that.relation);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, articleId, content, relation);
    }
}
