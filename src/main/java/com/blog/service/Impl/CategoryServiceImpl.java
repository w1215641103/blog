package com.blog.service.Impl;

import com.blog.dao.CategoryMapper;
import com.blog.pojo.Article;
import com.blog.pojo.Category;
import com.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> findCate() {
        return categoryMapper.findCate();
    }

    @Override
    public List<Article> findCateByName(int id) {
        return categoryMapper.findCateByName(id);
    }

    @Override
    public int countCate() {
        return categoryMapper.countCate();
    }

    @Override
    public int deleteCateById(int id) {
        return categoryMapper.deleteCateById(id);
    }

    @Override
    public int addCate(Category category) {
        return categoryMapper.addCate(category);
    }

    @Override
    public int updateCate(Category category) {
        return categoryMapper.updateCate(category);
    }
}
