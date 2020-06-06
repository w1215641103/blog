package com.blog.service;

import com.blog.pojo.Ar_la;
import com.blog.pojo.Article;

import java.util.List;

public interface Ar_laService {

    int deleteByArId(int id);

    int addAr_la(Ar_la ar_la);

    int deleteByLaId(int id);
}
