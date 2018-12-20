package com.zty.service;

import com.zty.dto.BannerDto;
import com.zty.eneity.Banner;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;

public interface BannerService {
    public BannerDto PageQuery(Integer page, Integer pageSize);

    public void UpateBanner(Banner b);

    public void AddBanner(Banner b, HttpSession session, MultipartFile file) throws IOException;

    public void DeleteBanner(Banner b);
}
