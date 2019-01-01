package com.zty.eneity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "banner")
public class Header implements Serializable {
    private String id;  //id
    private String thumbnail;  //图片地址
    private String desc;  //描述
}
