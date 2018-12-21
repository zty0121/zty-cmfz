package com.zty.service;

import com.zty.dto.AlbumDto;
import com.zty.eneity.Album;
import com.zty.mapper.AlbumMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumMapper albumMapper;

    public AlbumDto PageQuery(Integer page, Integer pageSize) {
        AlbumDto ad = new AlbumDto();
        albumMapper.selectCount(new Album());
        ad.setTotal(albumMapper.selectCount(null));
        ad.setRows(albumMapper.PageRows(page, pageSize));
        return ad;
    }

    @Override
    public Album QueryOneAlbum(String id) {
        Album a = new Album();
        a.setId(id);
        return albumMapper.selectByPrimaryKey(a);
    }

    @Override
    public void AddOneAlbum(Album a, HttpSession session, MultipartFile file) throws IOException, IllegalStateException {
        ServletContext scc = session.getServletContext();
        String s1 = scc.getRealPath("/img");
        String s2 = s1 + "\\" + file.getOriginalFilename();
        File file1 = new File(s2);
        file.transferTo(file1);
        a.setCover_img(file.getOriginalFilename());
        albumMapper.insert(a);
    }

    @Override
    public List<Album> QueryAllAlbum() {
        return albumMapper.selectAll();
    }
}
