package com.blog.controller;

import com.blog.pojo.Article;
import com.blog.pojo.Category;
import com.blog.service.ArticleService;
import com.blog.service.CategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    ArticleService articleService;

    @RequestMapping("/cate")
    public String findAllCate(Model model, @RequestParam(value = "id",defaultValue = "1")int id,
                              @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size){
        PageHelper.startPage(start,size,"article_id desc");
        List<Article> list =  categoryService.findCateByName(id);
        PageInfo<Article> page = new PageInfo<>(list);
        List<Category> listCate = categoryService.findCate();
        model.addAttribute("listCate",listCate);
        model.addAttribute("id",id);
        model.addAttribute("page", page);
        model.addAttribute("ArticleList",list);
        return "show/cate_page";
    }

    @RequestMapping("/listCate")
    @ResponseBody
    public Map<String,Object> listCate(@RequestParam(value = "page",defaultValue = "1")int page,
                                       @RequestParam(value = "limit", defaultValue = "10") int limit){
        PageHelper.startPage(page,limit,"cate_id");
        List<Category> listCate = categoryService.findCate();
        int count = categoryService.countCate();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", count);
        map.put("data", listCate);
        return map;
    }

    @RequestMapping(value = "/deleteCateById/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    private Map<String, Object> deleteCateById(@PathVariable("id") int id) {
        List<Article> articles = articleService.findByCateId(id);
        Map<String, Object> map = new HashMap<String, Object>();
        if (articles.size()!=0){
            map.put("status", 0);
        }else {
            int result = categoryService.deleteCateById(id);
            if (result > 0) {
                map.put("status", 1);
            } else {
                map.put("status", 0);
            }
        }
        return map;
    }

    @RequestMapping(value = "/addCate", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    private Map<String, Object> addCate(@RequestBody Category category) {
        int result = categoryService.addCate(category);
        Map<String, Object> map = new HashMap<String, Object>();
        if (result > 0) {
            map.put("status", 1);
        } else {
            map.put("status", 0);
        }
        return map;
    }

    @RequestMapping(value = "/upCate", method = RequestMethod.PUT,produces="application/json;charset=UTF-8")
    @ResponseBody
    private Map<String, Object> update(@RequestBody Category category) {
        int result = categoryService.updateCate(category);
        Map<String, Object> map = new HashMap<String, Object>();
        if (result > 0) {
            map.put("status", 1);
        } else {
            map.put("status", 0);
        }
        return map;
    }
}
