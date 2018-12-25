package com.zty.controller;

import com.zty.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/fc")
public class FileController {
    @Autowired
    private FileService fileService;

    @RequestMapping("/ExceptFile")
    public String ExceptFile(HttpSession session) {
        fileService.ExceptFile(session);
        return "ok";
    }
}
