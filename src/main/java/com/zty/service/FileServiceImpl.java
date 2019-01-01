package com.zty.service;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.zty.eneity.Album;
import com.zty.mapper.AlbumMapper;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class FileServiceImpl implements FileService {
    @Autowired
    private AlbumMapper albumMapper;

    @Override
    public void ExceptFile(HttpSession session) {
        List<Album> album = albumMapper.ExceptAlbum();
        ServletContext scc = session.getServletContext();
        for (Album a : album) {
            String s1 = scc.getRealPath("/img");
            System.out.println(s1);
            String s2 = s1 + "\\" + a.getCover_img();
            System.out.println(s2);
            a.setCover_img(s2);
        }
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("专辑详情单", "表一"),
                Album.class, album);
        try {
            workbook.write(new FileOutputStream(new File("E:/easypoi.xls")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void ImportFile(HttpSession session, MultipartFile file) {

    }
}
