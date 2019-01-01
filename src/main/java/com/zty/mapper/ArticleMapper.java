package com.zty.mapper;

import com.zty.eneity.Article;
import com.zty.eneity.TotalArticle;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ArticleMapper extends Mapper<Article> {
    public List<TotalArticle> QuerySomeArticle(String id);

    public List<TotalArticle> QueryRestArticle();

    public List<TotalArticle> QueryAllArticle();
}
