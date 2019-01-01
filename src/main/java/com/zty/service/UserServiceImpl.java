package com.zty.service;

import com.zty.eneity.CustomizationError;
import com.zty.eneity.Province;
import com.zty.eneity.TotalUser;
import com.zty.eneity.User;
import com.zty.mapper.UserMapper;
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
    /*    //MD5加密
        String s1 = u.getPassword(); //原密码
        String salt = RandomSaltUtil.generetRandomSaltCode();               //盐
        String realpassword = DigestUtils.md5Hex(s1) + salt;  //经过转化后的存进去的密码+盐
        u.setPassword(realpassword); //重新讲密码设置进去
     */
        userMapper.insert(u);
    }

    @Override
    public List<User> SelectAll() {
        return userMapper.selectAll();
    }

    @Override
    public Object QueryOne(String phone, String password, String code) {
        if (phone != null && password != null) {
            User u = new User(null, phone, null, null, null, null, null, null, null, null, null, null, null, null);
            User us = userMapper.selectOne(u);   //查到所对应的用户
            String realpassword = DigestUtils.md5Hex(password) + us.getSalt();  //经过转化后的存进去的密码+取出来的盐
            if (us.getPassword().equals(realpassword)) {
                String location = us.getProvince() + us.getCity();
                TotalUser tu = new TotalUser(us.getId(), us.getPassword(), us.getFarmington(), us.getName(), us.getSex(), us.getHead_pic(), location, us.getProvince(), us.getCity(), us.getSign(), us.getPhone());
                return tu;
            } else {
                return new CustomizationError("-200", "密码错误");
            }
        } else {
            return new CustomizationError("-200", "空");
        }
    }

    @Override
    public Object UpdateOne(String uid, String gender, String photo, String location, String description, String nickname, String province, String city, String password) {
        if (uid != null) {
            User u = new User();
            u.setId(uid);
            User us = userMapper.selectByPrimaryKey(u);//查一个
            String realpassword = DigestUtils.md5Hex(password) + us.getSalt(); //生成新密码
            us.setSex(gender);//设置男女
            us.setProvince(province); //设置省
            us.setName(nickname); //设置昵称
            us.setCity(city); //设置城市
            us.setPassword(realpassword);  //设置新的md5加密后的密码
            us.setHead_pic(photo);
            us.setSign(description); //设置个人签名
            userMapper.updateByPrimaryKey(us);
            TotalUser tu = new TotalUser(us.getId(), us.getPassword(), us.getFarmington(), us.getName(), us.getSex(), us.getHead_pic(), location, us.getProvince(), us.getCity(), us.getSign(), us.getPhone());
            return tu;
        } else {
            return new CustomizationError("-200", "修改超时失败");
        }
    }
}
