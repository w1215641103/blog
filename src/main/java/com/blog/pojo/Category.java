package com.blog.pojo;

public class Category {

    private int cate_id;
    private String cate_name;
    private Article article;

    public Category() {
        super();
    }

    @Override
    public String toString() {
        return "Category{" +
                "cate_id=" + cate_id +
                ", cate_name='" + cate_name + '\'' +
                ", article=" + article +
                '}';
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public int getCate_id() {
        return cate_id;
    }

    public void setCate_id(int cate_id) {
        this.cate_id = cate_id;
    }

    public String getCate_name() {
        return cate_name;
    }

    public void setCate_name(String cate_name) {
        this.cate_name = cate_name;
    }
}
