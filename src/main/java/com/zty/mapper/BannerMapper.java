package com.zty.mapper;

import com.zty.eneity.Banner;
import com.zty.eneity.Header;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BannerMapper extends Mapper<Banner> {
    public Integer QueryTotal();

    public List<Banner> PageRows(@Param("Page") Integer Page, @Param("PageSize") Integer PageSize);

    public List<Header> QueryHeader();
}
