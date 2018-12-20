package com.zty.service;

import com.zty.eneity.Menu;
import com.zty.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> QueryAllMenu() {
        return menuMapper.QueryAllByCategory();
    }
}
