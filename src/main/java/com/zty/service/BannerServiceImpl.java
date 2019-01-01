package com.zty.service;

import com.zty.dto.BannerDto;
import com.zty.eneity.Banner;
import com.zty.mapper.BannerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerMapper bannerMapper;
    @Override
    public BannerDto PageQuery(Integer page, Integer pageSize) {
        BannerDto bd = new BannerDto();
        bd.setTotal(bannerMapper.QueryTotal());
        bd.setRows(bannerMapper.PageRows(page, pageSize));
        return bd;
    }

    @Override
    public void UpateBanner(Banner b) {
        System.out.println(b);
        bannerMapper.updateByPrimaryKey(b);
    }

    @Override
    public void AddBanner(Banner b, HttpSession session, MultipartFile file) throws IllegalStateException, IOException {
        ServletContext scc = session.getServletContext();
        if ("on".equals(b.getStatus())) {
            b.setStatus("Y");
        } else {
            b.setStatus("N");
        }
        String s1 = scc.getRealPath("/img");
        String s2 = s1 + "\\" + file.getOriginalFilename();
        File file1 = new File(s2);
        file.transferTo(file1);
        b.setImg_path(file.getOriginalFilename());
        b.setPub_date(new Date());
        System.out.println(b + "14111111111111111111111111");
        bannerMapper.insert(b);
    }

    @Override
    public void DeleteBanner(Banner b) {
        bannerMapper.delete(b);
    }

}
