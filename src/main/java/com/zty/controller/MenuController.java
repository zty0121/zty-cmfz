package com.zty.controller;

import com.zty.eneity.Menu;
import com.zty.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mc")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("/QueryAll")
    public List<Menu> QueryAll() {
        return menuService.QueryAllMenu();
    }
}
