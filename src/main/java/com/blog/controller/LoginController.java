package com.blog.controller;


import com.blog.pojo.User;
import com.blog.service.UserService;
import com.github.pagehelper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UserService userService;


    @RequestMapping("login.out")
    public String loginout(HttpSession session){
        session.invalidate();
        return "manage/login_page";
    }

    @RequestMapping("login.do")
    public String logindo(){
        return "manage/login_page";
    }

    @RequestMapping("/login")
    public String login(HttpSession session, HttpServletRequest request){
            User user = new User();
        if(StringUtil.isEmpty(request.getParameter("name"))||StringUtil.isEmpty(request.getParameter("password"))){
            request.setAttribute("massage", "用户名或密码为空！");
        }else {
            user.setUser_account(request.getParameter("name"));
            user.setUser_pwd(request.getParameter("password"));
            user = userService.findUser(user);
            if(null != user) {
                session.setAttribute("user", user);
                return "manage/main_page";
            }else {
                request.setAttribute("massage", "用户名或密码错误！");
            }
        }
        return "manage/login_page";
    }
}
