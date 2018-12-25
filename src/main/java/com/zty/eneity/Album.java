package com.zty.eneity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ExcelTarget(value = "album")
public class Album implements Serializable {
    @Id
    @ExcelIgnore
    private String id;
    @Excel(name = "专辑名称", needMerge = true)
    private String title;
    @Excel(name = "数量", needMerge = true)
    private Integer count;
    @Excel(name = "头像", type = 2, width = 40, height = 20)
    private String cover_img;
    @Excel(name = "评分", needMerge = true)
    private Double score;
    @Excel(name = "作者", needMerge = true)
    private String author;
    @Excel(name = "读者", needMerge = true)
    private String broadcast;
    @Excel(name = "简介", needMerge = true)
    private String brief;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    @Excel(name = "发布日期", needMerge = true)
    private Date pub_date;
    @Transient
    @ExcelCollection(name = "章节详情")
    private List<Chapter> children;
}
