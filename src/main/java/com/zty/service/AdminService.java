package com.zty.service;

import com.zty.eneity.Admin;

import javax.servlet.http.HttpSession;

public interface AdminService {
    public Admin Login(String name, String password, String CheckCode, HttpSession session);
}
