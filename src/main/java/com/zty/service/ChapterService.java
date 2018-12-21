package com.zty.service;

import com.zty.eneity.Chapter;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;

public interface ChapterService {
    public void AddOneChapter(Chapter c, HttpSession session, MultipartFile file) throws IOException;
}
