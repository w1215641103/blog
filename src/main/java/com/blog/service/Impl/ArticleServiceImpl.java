package com.blog.service.Impl;

import com.blog.dao.ArticleMapper;
import com.blog.pojo.Article;
import com.blog.service.ArticleService;
import com.blog.util.MarkdownUtil;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Override
    public List<Article> findAll() {
        return articleMapper.findAll();
    }

    @Override
    public List<Article> findByCateId(int id) {
        return articleMapper.findByCateId(id);
    }

    @Override
    public Article get(int id) {
        return articleMapper.get(id);
    }

    @Override
    public Article showArticle(int id) {
        return articleMapper.showArticle(id);
    }

    @Override
    public Article showAndArticle(int id){
        Article article = articleMapper.showArticle(id);
        Article a = new Article();
        BeanUtils.copyProperties(article,a);
        String content = a.getArticle_body();
        a.setArticle_body(MarkdownUtil.markdownToHtml(content));
        return a;
    }

    @Override
    public int addBrowseById(Article article) {
        return articleMapper.addBrowseById(article);
    }

    @Override
    public int countArticle() {
        return articleMapper.countArticle();
    }

    @Override
    public int deleteArticleById(int id) {
        return articleMapper.deleteArticleById(id);
    }

    @Override
    public int addArticle(Article article) {
        return articleMapper.addArticle(article);
    }

    @Override
    public int updateArticle(Article article) {
        return articleMapper.updateArticle(article);
    }

}
