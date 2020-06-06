package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManageController {



    @RequestMapping("manage")
    public String manage(){
        return "manage/manage_page";
    }

    @RequestMapping("article_manage")
    public String article_manage(){
        return "manage/article_manage";
    }

    @RequestMapping("cate_manage")
    public String cate_manage(){
        return "manage/cate_manage";
    }

    @RequestMapping("label_manage")
    public String label_manage(){
        return "manage/label_manage";
    }

}
