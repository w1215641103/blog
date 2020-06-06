package com.blog.service.Impl;

import com.blog.dao.LabelMapper;
import com.blog.pojo.Article;
import com.blog.pojo.Label;
import com.blog.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    LabelMapper labelMapper;

    @Override
    public List<Label> findLabel() {
        return labelMapper.findLabel();
    }

    @Override
    public List<Article> findArticleByLabel(int id) {
        return labelMapper.findArticleByLabel(id);
    }

    @Override
    public int countLabel() {
        return labelMapper.countLabel();
    }

    @Override
    public int deleteLabelById(int id) {
        return labelMapper.deleteLabelById(id);
    }

    @Override
    public int addLabel(Label label) {
        return labelMapper.addLabel(label);
    }

    @Override
    public int updateLabel(Label label) {
        return labelMapper.updateLabel(label);
    }
}
