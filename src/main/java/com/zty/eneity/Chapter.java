package com.zty.eneity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chapter implements Serializable {
    @Id
    @Excel(name = "编号")
    private String id;
    @Excel(name = "标题")
    private String title;
    @Excel(name = "文件大小")
    private String size;
    @Excel(name = "文件时长")
    private String duration;
    @Excel(name = "文件路径")
    private String url;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    @Excel(name = "发布日期", format = "YYYY年MM月dd日")
    private Date upload_date;
    @Excel(name = "专辑编号")
    private String album_id;
}
