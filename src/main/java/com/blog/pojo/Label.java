package com.blog.pojo;

public class Label {

    private int label_id;
    private String label_name;
    private Article article;

    public Label() {
        super();
    }

    @Override
    public String toString() {
        return "Label{" +
                "label_id=" + label_id +
                ", label_name='" + label_name + '\'' +
                ", article=" + article +
                '}';
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public int getLabel_id() {
        return label_id;
    }

    public void setLabel_id(int label_id) {
        this.label_id = label_id;
    }

    public String getLabel_name() {
        return label_name;
    }

    public void setLabel_name(String label_name) {
        this.label_name = label_name;
    }


}
