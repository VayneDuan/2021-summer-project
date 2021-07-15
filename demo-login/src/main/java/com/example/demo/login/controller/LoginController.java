package com.example.demo.login.controller;

import com.example.demo.login.service.LoginService;
import com.example.demo.pojo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @Autowired
    LoginService loginService;
    //登录
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/loginSuccess")
    public String loginSuccess(Model model, Member member) {
        //查询用户名是否存在
        Member userLogin1 = loginService.findById(member.getId().toString());
        if (userLogin1 != null) { //如果用户名存在
            if (userLogin1.getPasswd().equals(member.getPasswd())) {
                System.out.println(userLogin1.toString());
                return "success";
            } else {
                model.addAttribute("data", "密码不正确");
                return "login";
            }

        } else { //用户名不存在，直接返回到登录页面
            model.addAttribute("data", "该用户不存在，请先注册");
            return "login";
        }
    }

    //注册
    @RequestMapping("/toRegister")
    public String toRegister() {
        return "register";
    }

    @RequestMapping("/toRegisterSuccess")
    public String toRegisterSuccess(Model model, Member member) {
        //添加一条记录到数据库中
        int add = loginService.add(member);
        System.out.println("插入数据成功");
        model.addAttribute("data","注册成功，请登录");
        return "login";
    }
}
