package com.zty.controller;

import com.zty.dto.BannerDto;
import com.zty.eneity.Banner;
import com.zty.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping("/bc")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @RequestMapping("/BannerPage")
    public BannerDto QueryBannerPage(Integer page, Integer rows) {
        return bannerService.PageQuery(page, rows);
    }

    @RequestMapping("/UpdateBanner")
    public String Update(Banner b) {
        bannerService.UpateBanner(b);
        return null;
    }

    @RequestMapping("/AddBanner")
    public String AddBanner(Banner b, HttpSession session, MultipartFile file) throws IllegalStateException, IOException {
        System.out.println(b);
        bannerService.AddBanner(b, session, file);
        return null;
    }

    @RequestMapping("/DeleteBanner")
    public String DeleteBanner(Banner b) {

        bannerService.DeleteBanner(b);
        System.out.println("xxxxxxxxxxxxxxxxxxx");
        return "ok";
    }
}
