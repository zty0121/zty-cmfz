package com.zty.controller;

import com.zty.eneity.Province;
import com.zty.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/uc")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/UserCount")
    public Integer[] UserCount() {
        return userService.QueryCount();
    }

    @RequestMapping(value = "/UserAddress")
    public List<Province> getCountyMap() {
        return userService.QueryAll();
    }
}
