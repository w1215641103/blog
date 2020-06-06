package com.blog.dao;

import com.blog.pojo.Article;
import com.blog.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryMapper {

    List<Category> findCate();

    List<Article> findCateByName(int id);

    int countCate();

    int deleteCateById(int id);

    int addCate(Category category);

    int updateCate(Category category);
}
