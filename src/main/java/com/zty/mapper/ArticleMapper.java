package com.zty.mapper;

import com.zty.eneity.Article;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ArticleMapper extends Mapper<Article> {
    public List<Article> QueryArticle();
}
