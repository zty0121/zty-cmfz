package com.zty.service;

import com.zty.dto.AlbumDto;
import com.zty.eneity.Album;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public interface AlbumService {
    public AlbumDto PageQuery(Integer page, Integer pageSize);

    public Album QueryOneAlbum(String id);

    public void AddOneAlbum(Album a, HttpSession session, MultipartFile file) throws IOException;

    public List<Album> QueryAllAlbum();
}
