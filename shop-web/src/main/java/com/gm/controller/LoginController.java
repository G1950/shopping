package com.gm.controller;

import com.gm.common.Result;
import com.gm.common.ResultEnum;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author Gm
 * @Date 2020/7/13/013 23:04
 * @Version 1.0
 **/
@Controller
@RequestMapping("/seller")
public class LoginController {
    @RequestMapping("/login")
    public String toLogin() {
        return "../shoplogin";
    }

    @RequestMapping("/register")
    public String toRegister() {
        return "../register";
    }

    @GetMapping("/index")
    public String toIndex() {
        return "/admin/index";
    }

}
