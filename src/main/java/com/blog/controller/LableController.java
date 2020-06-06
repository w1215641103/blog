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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LableController {

    @Autowired
    LabelService labelService;
    @Autowired
    Ar_laService ar_laService;

    @RequestMapping("/label")
    public String findAllLabel(Model model,@RequestParam(value = "id",defaultValue = "1")int id,
                               @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size){
        PageHelper.startPage(start,size,"article_id desc");
        List<Article> list =  labelService.findArticleByLabel(id);
        List<Label> findLabel= labelService.findLabel();
        PageInfo<Article> page = new PageInfo<>(list);
        model.addAttribute("id",id);
        model.addAttribute("page", page);
        model.addAttribute("ArticleList",list);
        model.addAttribute("findLabel",findLabel);
        return "show/label_page";
    }

    @RequestMapping("/listLabel")
    @ResponseBody
    public Map<String,Object> listLabel(@RequestParam(value = "page",defaultValue = "1")int page,
                                        @RequestParam(value = "limit", defaultValue = "10") int limit,
                                        HttpSession session){
        PageHelper.startPage(page,limit,"label_id");
        List<Label> listLabel = labelService.findLabel();
        int count = labelService.countLabel();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", count);
        map.put("data", listLabel);
        return map;
    }

    @RequestMapping(value = "/deleteLabelById/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    private Map<String, Object> deleteLabelById(@PathVariable("id") int id) {
        ar_laService.deleteByLaId(id);
        int result = labelService.deleteLabelById(id);
        Map<String, Object> map = new HashMap<String, Object>();
        if (result > 0) {
            map.put("status", 1);
        } else {
            map.put("status", 0);
        }
        return map;
    }

    @RequestMapping(value = "/addLabel", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    private Map<String, Object> addLabel(@RequestBody Label label) {
        int result = labelService.addLabel(label);
        Map<String, Object> map = new HashMap<String, Object>();
        if (result > 0) {
            map.put("status", 1);
        } else {
            map.put("status", 0);
        }
        return map;
    }

    @RequestMapping(value = "/upLabel", method = RequestMethod.PUT,produces="application/json;charset=UTF-8")
    @ResponseBody
    private Map<String, Object> upLabel(@RequestBody Label label) {
        int result = labelService.updateLabel(label);
        Map<String, Object> map = new HashMap<String, Object>();
        if (result > 0) {
            map.put("status", 1);
        } else {
            map.put("status", 0);
        }
        return map;
    }
}
