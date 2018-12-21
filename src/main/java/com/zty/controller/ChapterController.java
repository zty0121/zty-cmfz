package com.zty.controller;

import com.zty.eneity.Chapter;
import com.zty.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping("/cc")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @RequestMapping("/AddOneChapter")
    public void AddOneChapter(Chapter c, HttpSession session, MultipartFile file) throws IOException, IllegalStateException {
        chapterService.AddOneChapter(c, session, file);
    }
}
