package com.zty.mapper;

import com.zty.eneity.Album;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AlbumMapper extends Mapper<Album> {
    public List<Album> PageRows(@Param("Page") Integer Page, @Param("PageSize") Integer PageSize);
}
