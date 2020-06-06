package com.blog.service.Impl;

import com.blog.dao.Ar_laMapper;
import com.blog.pojo.Ar_la;
import com.blog.pojo.Article;
import com.blog.service.Ar_laService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Ar_laServiceImpl implements Ar_laService {

    @Autowired
    Ar_laMapper ar_laMapper;

    @Override
    public int deleteByArId(int id) {
        return ar_laMapper.deleteByArId(id);
    }

    @Override
    public int addAr_la(Ar_la ar_la) {
        return ar_laMapper.addAr_la(ar_la);
    }

    @Override
    public int deleteByLaId(int id) {
        return ar_laMapper.deleteByLaId(id);
    }


}
