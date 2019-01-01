package com.zty.controller;

import com.zty.eneity.Province;
import com.zty.eneity.User;
import com.zty.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
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

    @RequestMapping(value = "/AddUser")
    public void AddUser() {
        User us = new User(null, "1350763", "123456", "457", "1", "1.png", "zty", "1", "0", "河南", "郑州", "冻结", new Date(), null);
        userService.Regist(us);
    }

    @RequestMapping("/SelectAll")
    public List<User> SelectAll() {
        return userService.SelectAll();
    }

    @RequestMapping("/Login")
    public Object Login(String phone, String password, String code) {
        return userService.QueryOne("13507633979", "123456", null);
    }

    @RequestMapping("/UpdateUser")
    public Object UpdateUser(String uid, String gender, String photo, String location, String description, String nickname, String province, String city, String password) {
        return userService.UpdateOne("1", "m", "999.png", "河南省济源市", "我很专一", "戏子", "河南省", "济源市", "123457");
    }

}
