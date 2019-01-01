package com.zty.service;

import com.zty.eneity.Province;
import com.zty.eneity.User;

import java.util.List;

public interface UserService {
    public Integer[] QueryCount();

    public List<Province> QueryAll();

    public void Regist(User u);

    public List<User> SelectAll();

    public Object QueryOne(String phone, String password, String code);

    public Object UpdateOne(String uid, String gender, String photo, String location, String description, String nickname, String province, String city, String password);
}
