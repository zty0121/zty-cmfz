package com.zty.controller;

import com.zty.eneity.Chapter;
import com.zty.service.ChapterService;
import org.apache.commons.io.FileUtils;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.TagException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

@RestController
@RequestMapping("/cc")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @RequestMapping("/AddOneChapter")
    public void AddOneChapter(Chapter c, HttpSession session, MultipartFile file) throws IOException, IllegalStateException, TagException, ReadOnlyFileException, CannotReadException, InvalidAudioFrameException {
        chapterService.AddOneChapter(c, session, file);
    }

    @RequestMapping("/DownLoad")
    public void DownLoad(HttpSession session, HttpServletResponse response, String url) throws IOException {
        String realPath = session.getServletContext().getRealPath("/music");
        File srcFile = new File(realPath + "/" + url);
        byte[] bs = FileUtils.readFileToByteArray(srcFile);
        // 设置响应头信息，以附件的形式下载
        response.setHeader("content-disposition", "attchment;filename=" + URLEncoder.encode(url, "utf-8"));
        // 使用响应输出流，往client输出文件内容
        ServletOutputStream sos = response.getOutputStream();
        sos.write(bs);
    }
}
