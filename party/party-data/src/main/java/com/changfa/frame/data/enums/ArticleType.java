package com.changfa.frame.data.enums;

/**
 * @Author: Song Kaijie
 * @Date: 2019/4/15
 */
public enum ArticleType {
    /**
     * 栏目文章
     */
    CMS_ARTICLE("C"),

    /**
     * 专题文章
     */
    CMS_SUBJECT_ARTICLE("S");

    private String value;

    public String getValue() {
        return value;
    }

    ArticleType(String value) {
        this.value = value;
    }
}
