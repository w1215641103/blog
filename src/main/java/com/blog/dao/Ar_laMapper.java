package com.blog.dao;

import com.blog.pojo.Ar_la;
import com.blog.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Ar_laMapper {

    int deleteByArId(int id);

    int addAr_la(Ar_la ar_la);

    int deleteByLaId(int id);
}
