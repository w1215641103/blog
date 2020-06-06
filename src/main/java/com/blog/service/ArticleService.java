package com.blog.service;

import com.blog.pojo.Article;

import java.util.List;

public interface ArticleService {

    List<Article> findAll();

    List<Article> findByCateId(int id);

    Article get(int id);

    Article showArticle(int id);

    Article showAndArticle(int id);

    int addBrowseById(Article article);

    int countArticle();

    int deleteArticleById(int id);

    int addArticle(Article article);

    int updateArticle(Article article);
}
