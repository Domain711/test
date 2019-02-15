package com.example.demo.dao;

import com.example.demo.entity.ProUserAdminEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 后台用户
 *
 * @date 2019-02-13 13:41:35
 */
@Repository
public interface ProUserAdminDao {


    /**
     * 新增
     *
     * @param user
     * @return
     */
    int addUser(ProUserAdminEntity user);

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    int mergeUser(ProUserAdminEntity user);

    /**
     * 删除用户
     *
     * @param userId
     * @return
     */
    int deleteUser(String userId);

    /**
     * 修改
     *
     * @param user
     * @return
     */
    int editUser(ProUserAdminEntity user);


    /**
     * 查询所有数据
     *
     * @return
     */
    List<ProUserAdminEntity> queryAll();

    /**
     * 根据用户ID获取用户对象
     *
     * @param userId
     * @return
     */
    ProUserAdminEntity getUserById(String userId);


}
