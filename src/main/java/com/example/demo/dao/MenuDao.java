package com.example.demo.dao;

import com.example.demo.entity.MenuEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 菜单Dao
 *
 * @date 2019-02-16 09:28:53
 */

@Repository
public interface MenuDao {

    /**
     * 查询所有菜单
     *
     * @return
     */
    List<MenuEntity> queryALlMenu();

    /**
     * 根据ID查询菜单对象
     *
     * @return
     */
    MenuEntity queryMenuById(Integer id);


    /**
     * 获取上级菜单
     *
     * @return
     */
    List<MenuEntity> queryParentMenu();

    /**
     * 保存菜单信息
     *
     * @param menu
     * @return
     */
    int saveMenu(MenuEntity menu);

    /**
     * 修改报错菜单
     * @param menu
     * @return
     */
    int saveEditMenu(MenuEntity menu);

}
