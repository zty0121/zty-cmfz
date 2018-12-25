package com.zty.eneity;

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
public class User implements Serializable {
    @Id
    private String id;
    private String phone;
    private String password;
    private String salt;
    private String sign;
    private String head_pic;
    private String name;
    private String dhama_id;
    private String sex;
    private String province;
    private String city;
    private String status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date reg_date;
}
