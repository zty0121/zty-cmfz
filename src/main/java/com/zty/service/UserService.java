package com.zty.service;

import com.zty.eneity.Province;
import com.zty.eneity.User;

import java.util.List;

public interface UserService {
    public Integer[] QueryCount();

    public List<Province> QueryAll();

    public void Regist(User u);
}
