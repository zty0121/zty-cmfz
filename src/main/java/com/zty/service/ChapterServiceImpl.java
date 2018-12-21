package com.zty.service;

import com.zty.eneity.Chapter;
import com.zty.mapper.ChapterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterMapper chapterMapper;

    @Override
    public void AddOneChapter(Chapter c, HttpSession session, MultipartFile file) throws IOException, IllegalStateException {
        ServletContext scc = session.getServletContext();
        String s1 = scc.getRealPath("/music");
        String s2 = s1 + "\\" + file.getOriginalFilename();
        File file1 = new File(s2);
        file.transferTo(file1);
        c.setId(UUID.randomUUID().toString().replace("-", ""));
        c.setUpload_date(new Date());
        c.setUrl(file.getOriginalFilename());
        chapterMapper.insert(c);
    }
}
