package com.blog.service;

import com.blog.pojo.Article;
import com.blog.pojo.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findCate();

    List<Article> findCateByName(int id);

    int countCate();

    int deleteCateById(int id);

    int addCate(Category category);

    int updateCate(Category category);
}
