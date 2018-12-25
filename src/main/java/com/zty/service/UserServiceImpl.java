package com.zty.service;

import com.zty.eneity.Province;
import com.zty.eneity.User;
import com.zty.mapper.UserMapper;
import com.zty.util.RandomSaltUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer[] QueryCount() {
        Integer u1 = userMapper.QueryAllOneWeek();
        Integer u2 = userMapper.QueryAllTwoWeek();
        Integer u3 = userMapper.QueryAllThirdWeek();
        Integer a[] = {u1, u2, u3};
        return a;
    }

    @Override
    public List<Province> QueryAll() {
        return userMapper.getAllMarginData();
    }

    @Override
    public void Regist(User u) {
        //MD5加密
        String s1 = u.getPassword(); //原密码
        String salt = RandomSaltUtil.generetRandomSaltCode();               //盐
        String realpassword = DigestUtils.md5Hex(s1) + salt;  //经过转化后的存进去的密码+盐
        u.setPassword(realpassword); //重新讲密码设置进去
        userMapper.insert(u);
    }
}
