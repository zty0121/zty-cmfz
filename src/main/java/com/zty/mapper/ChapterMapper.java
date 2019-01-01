package com.zty.mapper;

import com.zty.eneity.Chapter;
import com.zty.eneity.ChapterList;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ChapterMapper extends Mapper<Chapter> {
    public List<ChapterList> QueryOneList(String id);
}
