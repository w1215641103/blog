package com.blog.pojo;

import java.util.Date;
import java.util.List;

public class Article {
    private int article_id;
    private String article_author;
    private String article_title;
    private String article_body;
    private String article_desc;
    private Date article_time;
    private String article_browse;
    private String article_img;
    private int article_cateid;
    private Category category;
    private Label label;

    public Article() {
    }

    @Override
    public String toString() {
        return "Article{" +
                "article_id=" + article_id +
                ", article_author='" + article_author + '\'' +
                ", article_title='" + article_title + '\'' +
                ", article_body='" + article_body + '\'' +
                ", article_desc='" + article_desc + '\'' +
                ", article_time=" + article_time +
                ", article_browse='" + article_browse + '\'' +
                ", article_img='" + article_img + '\'' +
                ", article_cateid=" + article_cateid +
                ", category=" + category +
                ", label=" + label +
                '}';
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public String getArticle_author() {
        return article_author;
    }

    public void setArticle_author(String article_author) {
        this.article_author = article_author;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getArticle_body() {
        return article_body;
    }

    public void setArticle_body(String article_body) {
        this.article_body = article_body;
    }

    public String getArticle_desc() {
        return article_desc;
    }

    public void setArticle_desc(String article_desc) {
        this.article_desc = article_desc;
    }

    public Date getArticle_time() {
        return article_time;
    }

    public void setArticle_time(Date article_time) {
        this.article_time = article_time;
    }

    public String getArticle_browse() {
        return article_browse;
    }

    public void setArticle_browse(String article_browse) {
        this.article_browse = article_browse;
    }

    public String getArticle_img() {
        return article_img;
    }

    public void setArticle_img(String article_img) {
        this.article_img = article_img;
    }

    public int getArticle_cateid() {
        return article_cateid;
    }

    public void setArticle_cateid(int article_cateid) {
        this.article_cateid = article_cateid;
    }
}