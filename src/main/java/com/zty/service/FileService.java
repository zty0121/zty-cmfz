package com.zty.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

public interface FileService {
    public void ExceptFile(HttpSession session);

    public void ImportFile(HttpSession session, MultipartFile file);
}
