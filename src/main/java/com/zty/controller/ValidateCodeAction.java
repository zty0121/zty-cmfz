package com.zty.controller;

import com.zty.util.CreateValidateCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class ValidateCodeAction {
    @RequestMapping("/code")
    public String createImage(HttpSession session, HttpServletResponse response) throws Exception {
        CreateValidateCode cvc = new CreateValidateCode();
        String code = cvc.getCode();
        //存入session作用
        session.setAttribute("code", code);
        System.out.println(code);
        cvc.write(response.getOutputStream());
        return null;
    }
}
