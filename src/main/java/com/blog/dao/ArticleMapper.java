package com.blog.dao;

import com.blog.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArticleMapper {

    List<Article> findAll();

    List<Article> findByCateId(int id);

    Article get(int id);

    Article showArticle(int id);

    int addBrowseById(Article article);

    int countArticle();

    int deleteArticleById(int id);

    int addArticle(Article article);

    int updateArticle(Article article);
}
