package com.blog.service;

import com.blog.pojo.Article;
import com.blog.pojo.Label;

import java.util.List;

public interface LabelService {

    List<Label> findLabel();

    List<Article> findArticleByLabel(int id);

    int countLabel();

    int deleteLabelById(int id);

    int addLabel(Label label);

    int updateLabel(Label label);
}
