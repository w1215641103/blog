package com.blog.dao;

import com.blog.pojo.Article;
import com.blog.pojo.Label;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface LabelMapper {

    List<Label> findLabel();

    List<Article> findArticleByLabel(int id);

    int countLabel();

    int deleteLabelById(int id);

    int addLabel(Label label);

    int updateLabel(Label label);
}
