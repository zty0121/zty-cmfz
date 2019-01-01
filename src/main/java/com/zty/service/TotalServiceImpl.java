package com.zty.service;

import com.zty.eneity.TotalAlbum;
import com.zty.eneity.TotalArticle;
import com.zty.eneity.User;
import com.zty.mapper.*;
import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TotalServiceImpl implements TotalService {
    @Autowired
    private BannerMapper bannerMapper;
    @Autowired
    private AlbumMapper albumMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private ChapterMapper chapterMapper;

    @Override
    public Object QueryHeader(String uid, String type, String sub_type) {
        if (uid == null || type == null) {
            return new Error("用户为空，或者请求类型为空");
        } else {
            if (type.equals("all")) {
                Map<String, Object> map = new HashedMap<>();
                map.put("header", bannerMapper.QueryHeader());  //轮播图
                List<TotalAlbum> albumlist = albumMapper.QueryTotalAlbum();
                List<TotalArticle> articlelist = articleMapper.QueryAllArticle();
                List<Object> list = new ArrayList<Object>();
                for (TotalAlbum totalAlbum : albumlist) {
                    list.add(totalAlbum);
                }
                for (TotalArticle totalArticle : articlelist) {
                    list.add(totalArticle);
                }
                map.put("body", list);//专辑
                return map;
            } else if (type.equals("wen")) {
                Map<String, Object> map = new HashedMap<>();
                List<TotalAlbum> albumlist = albumMapper.QueryTotalAlbum();
                Map<String, Object> albummap = new HashedMap<>();
                map.put("body", albumlist);//专辑
                return map;
            } else {
                if (sub_type != null) {
                    if (sub_type.equals("ssyj")) {
                        Map<String, Object> map = new HashMap<>();
                        //先通过uid查出这个人的上师的id
                        User u = new User(uid, null, null, null, null, null, null, null, null, null, null, null, null, null);
                        User us = userMapper.selectByPrimaryKey(u);  //上师的编号
                        articleMapper.QuerySomeArticle(us.getId());  //查询到自己上师的著作
                        map.put("GuruArticle", articleMapper.QuerySomeArticle(us.getId()));  //上师的文章集合
                        return map;
                    } else {
                        Map<String, Object> map = new HashMap<>();
                        map.put("OtherGuruArticle", articleMapper.QueryRestArticle());  //其他上师上师的文章集合
                        return map;
                    }
                } else {
                    return new Error("思的类型不能为空");
                }
            }
        }
    }

    @Override
    public Object WenDetail(String id, String uid) {
        if (uid == null || id == null) {
            return new Error("用户为空，或者专辑为空");
        } else {
            if (uid != null && id != null) {
                Map<String, Object> map = new HashedMap<>();
                map.put("introduction", albumMapper.QueryWenDetail(id));  //详情介绍
                map.put("list", chapterMapper.QueryOneList(id)); //章节详情
                return map;
            } else {
                return new Error("uid为空，或者id为空");
            }
        }
    }
}
