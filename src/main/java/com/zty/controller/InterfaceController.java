package com.zty.controller;

import com.zty.service.TotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tfc")
public class InterfaceController {
    @Autowired
    private TotalService totalService;

    @RequestMapping("Query")
    public Object test() {
        // totalService.QueryHeader("1","all",null);
        return totalService.QueryHeader("1", "all", null);
    }

    @RequestMapping("/WenDetail")
    public Object test1(String id, String uid) {
        return totalService.WenDetail("1", "1");
    }

}
