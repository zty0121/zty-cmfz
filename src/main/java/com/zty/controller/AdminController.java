package com.zty.controller;

import com.zty.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/ac")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/Login")
    private String Login(String name, String password, String enCode, HttpSession session) {
        adminService.Login(name, password, enCode, session);
        return "redirect:/main/main.jsp";
    }
}
