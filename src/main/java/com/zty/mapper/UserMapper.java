package com.zty.mapper;

import com.zty.eneity.Province;
import com.zty.eneity.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {
    public Integer QueryAllOneWeek();

    public Integer QueryAllTwoWeek();

    public Integer QueryAllThirdWeek();

    public List<Province> getAllMarginData();

    public List<Province> getAllMan();

}
