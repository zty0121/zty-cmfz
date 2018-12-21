package com.zty.controller;

import com.zty.dto.AlbumDto;
import com.zty.eneity.Album;
import com.zty.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/act")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @RequestMapping("/Albumpage")
    public AlbumDto QueryAlbumPage(Integer page, Integer rows) {
        return albumService.PageQuery(page, rows);
    }

    @RequestMapping("/QueryOneAlbum")
    public Album QueryOneAlbum(String id) {
        return albumService.QueryOneAlbum(id);
    }

    @RequestMapping("/AddOneAlbum")
    public String AddOneAlbum(Album a, HttpSession session, MultipartFile file) throws IOException {
        albumService.AddOneAlbum(a, session, file);
        return null;
    }

    @RequestMapping("/QueryAllAlbum")
    public List<Album> QueryAllAlbum() {
        return albumService.QueryAllAlbum();
    }
}
