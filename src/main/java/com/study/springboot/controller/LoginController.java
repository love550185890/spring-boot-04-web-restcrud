package com.study.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping(value = "/user/login")
    public String login(String username,
                        String password,
                        HttpServletRequest request,
                        HttpSession session,
                        Map<String,Object> map) {
        if (!StringUtils.isEmpty(username) && "123456".equals(password)){
            //登录成功,把用户保存到session中
            session.setAttribute("loginUser",username);
            //防止表单重复提交，重定向到main.html（添加视图解析器指向dashboard.html）
            return "redirect:/main.html";
        }else {
            //登录失败，提示错误信息
            map.put("msg","用户名或密码错误");
            return "login";
        }
    }
}
