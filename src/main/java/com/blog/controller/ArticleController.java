package com.blog.controller;

import com.blog.pojo.Ar_la;
import com.blog.pojo.Article;
import com.blog.pojo.Category;
import com.blog.pojo.Label;
import com.blog.service.Ar_laService;
import com.blog.service.ArticleService;
import com.blog.service.CategoryService;
import com.blog.service.LabelService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ArticleController {

    @Autowired
    ArticleService articleService;
    @Autowired
    Ar_laService ar_laService;
    @Autowired
    LabelService labelService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping("/home")
    public String findAll(Model model, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size){
        PageHelper.startPage(start,size,"article_id desc");
        List<Article> list =  articleService.findAll();
        PageInfo<Article> page = new PageInfo<>(list);
        model.addAttribute("page", page);
        model.addAttribute("ArticleList",list);
        return "show/home_page";
    }

    @RequestMapping("/listArticle")
    @ResponseBody
    public Map<String,Object> listArticle(@RequestParam(value = "page",defaultValue = "1")int page,
                                        @RequestParam(value = "limit", defaultValue = "10") int limit){
        PageHelper.startPage(page,limit,"article_id");
        List<Article> listArticle = articleService.findAll();
        int count = articleService.countArticle();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", count);
        map.put("data", listArticle);
        return map;
    }

    @RequestMapping(value = "/updateArticle")
    private String updateArticle(Model model,@RequestParam(value = "article_id") int id) {
        List<Label> listLabel = labelService.findLabel();
        List<Category> listCate = categoryService.findCate();
        model.addAttribute("list_radio",listCate);
        model.addAttribute("list_check",listLabel);
        Article showarticle = articleService.showArticle(id);
        model.addAttribute("showarticle",showarticle);
        return "manage/article_update";
    }

    @PostMapping("/updateSuccess")
    public String updateSuccess(@RequestParam("file") MultipartFile file, @RequestParam("article_id") int article_id,
                                @RequestParam("article_author") String article_author, @RequestParam("article_title")String article_title,
                                @RequestParam("article_body")String article_body, @RequestParam("article_desc")String article_desc,
                                @RequestParam("cate_id")int cate_id, @RequestParam(value = "label_id",required=false)List label_id){
        String fileName = file.getOriginalFilename();
        Date date = new Date();

        Article articles = new Article();
        articles.setArticle_author(article_author);
        articles.setArticle_title(article_title);
        articles.setArticle_body(article_body);
        articles.setArticle_desc(article_desc);
        articles.setArticle_cateid(cate_id);
        articles.setArticle_time(date);
        articles.setArticle_browse("0");
        articles.setArticle_img(fileName);
        articles.setArticle_id(article_id);
        articleService.updateArticle(articles);
        ar_laService.deleteByArId(article_id);
        if (label_id!=null) {
            Ar_la ar_las = new Ar_la();
            ar_las.setAr_id(article_id);
            for (Object a : label_id
            ) {
                int labelId = Integer.parseInt(a.toString());
                ar_las.setLa_id(labelId);
                ar_laService.addAr_la(ar_las);
            }
        }

        String filepath = ClassUtils.getDefaultClassLoader().getResource("static/img/").getPath();
        File dest = new File(filepath+fileName);

        try {
            file.transferTo(dest);
        }catch (IOException e){
        }
        return "manage/updateSuccess";
    }

    @RequestMapping(value = "/deleteArticleById/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    private Map<String, Object> deleteArticleById(@PathVariable("id") int article_id) {
        ar_laService.deleteByArId(article_id);
        int result = articleService.deleteArticleById(article_id);
        Map<String, Object> map = new HashMap<String, Object>();
        if (result > 0) {
            map.put("status", 1);
        } else {
            map.put("status", 0);
        }
        return map;
    }

    @RequestMapping("/article")
    public String showArticle(Model model, @RequestParam(value = "id", defaultValue = "0") int id){
        Article showArticle = articleService.showAndArticle(id);
        int browse = Integer.parseInt(showArticle.getArticle_browse());
        browse = browse+1;
        showArticle.setArticle_browse(String.valueOf(browse));
        articleService.addBrowseById(showArticle);
        model.addAttribute("showArticle",showArticle);
        return "show/article_page";
    }

    @RequestMapping("/aboutme")
    public String aboutMe(){
        return "show/aboutme_page";
    }

    @GetMapping("/articleAddPage")
    public String articleAddPage(Model model ){
        List<Label> listLabel = labelService.findLabel();
        List<Category> listCate = categoryService.findCate();
        model.addAttribute("list_radio",listCate);
        model.addAttribute("list_check",listLabel);
        return "manage/article_add";
    }

    @PostMapping("/addSuccess")
    public String addSuccess(@RequestParam("file") MultipartFile file, @RequestParam("article_author") String article_author,
                         @RequestParam("article_title")String article_title, @RequestParam("article_body")String article_body,
                         @RequestParam("article_desc")String article_desc, @RequestParam("cate_id")int cate_id,
                         @RequestParam(value = "label_id",required=false)List label_id){
        String fileName = file.getOriginalFilename();
        Date date = new Date();

        Article articles = new Article();
        articles.setArticle_author(article_author);
        articles.setArticle_title(article_title);
        articles.setArticle_body(article_body);
        articles.setArticle_desc(article_desc);
        articles.setArticle_cateid(cate_id);
        articles.setArticle_time(date);
        articles.setArticle_browse("0");
        articles.setArticle_img(fileName);
        articleService.addArticle(articles);
        if (label_id!=null) {
            Ar_la ar_las = new Ar_la();
            ar_las.setAr_id(articles.getArticle_id());
            for (Object a : label_id
            ) {
                int labelId = Integer.parseInt(a.toString());
                ar_las.setLa_id(labelId);
                ar_laService.addAr_la(ar_las);
            }
        }

        String filepath = ClassUtils.getDefaultClassLoader().getResource("static/img/").getPath();
        File dest = new File(filepath+fileName);
        System.out.println(filepath);
        System.out.println(dest);
        try {
            file.transferTo(dest);
        }catch (IOException e){
        }
        return "manage/addSuccess";
    }
}
