package com.zty.eneity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TotalUser {
    private String uid;
    private String password;
    private String farmington;
    private String nickname;
    private String gender;
    private String photo;
    private String location;
    private String province;
    private String city;
    private String description;
    private String phone;
}
