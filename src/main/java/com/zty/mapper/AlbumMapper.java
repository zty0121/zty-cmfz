package com.zty.mapper;

import com.zty.eneity.Album;
import com.zty.eneity.TotalAlbum;
import com.zty.eneity.WenDetail;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AlbumMapper extends Mapper<Album> {
    public List<Album> PageRows(@Param("Page") Integer Page, @Param("PageSize") Integer PageSize);

    public List<Album> ExceptAlbum();

    public List<TotalAlbum> QueryTotalAlbum();

    public List<WenDetail> QueryWenDetail(String id);
}
