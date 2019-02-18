package com.example.demo.service.serviceImpl;

import com.example.demo.dao.MenuDao;
import com.example.demo.entity.MenuEntity;
import com.example.demo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 菜单实现类
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;

    @Override
    public List<MenuEntity> queryAllMenu() {
        List<MenuEntity> list = menuDao.queryALlMenu();
        return list;
    }

    @Override
    public MenuEntity queryMenuById(Integer id) {
        MenuEntity menu = menuDao.queryMenuById(id);
        return menu;
    }

    @Override
    public List<MenuEntity> queryParentMenu() {
        List<MenuEntity> list = menuDao.queryParentMenu();
        return list;
    }

    @Override
    public int saveMenu(MenuEntity menu) {
        int count = menuDao.saveMenu(menu);
        return count;
    }

    @Override
    public int saveEditMenu(MenuEntity menu) {
        int count = menuDao.saveEditMenu(menu);
        return count;
    }
}
