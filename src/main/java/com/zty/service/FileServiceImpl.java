package com.zty.service;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.zty.eneity.Album;
import com.zty.mapper.AlbumMapper;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
/*
    @Override
    public List<Album> ImportFile(MultipartFile file, HttpSession session) {
       ImportParams params = new ImportParams();
        ServletContext scc = session.getServletContext();
        String s1 = scc.getRealPath("E:/easypoi.xls");
        System.out.println(s1);
        String s2 = s1+"\\"+file.getOriginalFilename();
        params.setTitleRows(1);
        params.setHeadRows(2);
        List<Album> list = null;
        FileInputStream fis = null;
        try {
            fis=new FileInputStream(s2);
            list = ExcelImportUtil.importExcel(fis,Album.class, params);
            for (Album album : list) {
                System.out.println(album);
            }
        }catch (NoSuchElementException e){
            //throw new NormalException("模板不能为空");
        } catch (Exception e) {
            e.printStackTrace();
            //throw new NormalException(e.getMessage());
        }
        return list;
        }
        */
}
