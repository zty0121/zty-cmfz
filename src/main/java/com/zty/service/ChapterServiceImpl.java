package com.zty.service;

import com.zty.eneity.Chapter;
import com.zty.mapper.ChapterMapper;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.TagException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterMapper chapterMapper;

    @Override
    public void AddOneChapter(Chapter c, HttpSession session, MultipartFile file) throws IOException, IllegalStateException, TagException, ReadOnlyFileException, CannotReadException, InvalidAudioFrameException {
        ServletContext scc = session.getServletContext();
        String s1 = scc.getRealPath("/music");
        String s2 = s1 + "\\" + file.getOriginalFilename();
        File file1 = new File(s2);
        file.transferTo(file1);
        Long l = file.getSize();
        Double size = Double.parseDouble(l.toString()) / 1024 / 1024;
        NumberFormat nf = NumberFormat.getNumberInstance();
        //保留两位小数
        nf.setMaximumFractionDigits(2);
        c.setSize(nf.format(size) + "MB");
        c.setId(UUID.randomUUID().toString().replace("-", ""));
        c.setUpload_date(new Date());
        c.setUrl(file.getOriginalFilename());
        //获取时长
        MP3File f = (MP3File) AudioFileIO.read(file1);
        MP3AudioHeader audioHeader = f.getMP3AudioHeader();
        Integer duration = audioHeader.getTrackLength();
        Integer hour = duration / 3600;   //小时
        Integer min = (duration - hour * 3600) / 60;   //分钟
        Integer seconds = (duration - hour * 3600 - min * 60);  //秒
        String Realduration = hour + ":" + min + ":" + seconds;
        c.setDuration(Realduration);
        chapterMapper.insert(c);
    }
}
