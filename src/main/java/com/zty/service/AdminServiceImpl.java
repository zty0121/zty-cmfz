package com.zty.service;

import com.zty.eneity.Admin;
import com.zty.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    public Admin Login(String name, String password, String CheckCode, HttpSession session) {
        String s1 = (String) session.getAttribute("code");
        Admin a = new Admin(null, name, null);
        if (s1.equals(CheckCode)) {
            Admin as = adminMapper.selectOne(a);
            if (as == null) throw new RuntimeException();
            if (as.getPassword().equals(password)) {
                session.setAttribute("login", "ok");
                System.out.println("登录成功");
                return as;
            }
        }
        return null;
    }
}
