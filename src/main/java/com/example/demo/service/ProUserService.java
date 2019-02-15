package com.example.demo.service;


import com.example.demo.entity.ProUserAdminEntity;

import java.util.List;

/**
 * 用户service
 */
public interface ProUserService {

    /**
     * 查询所有用户
     * @return
     */
    List<ProUserAdminEntity> queryALl();

    /**
     * 根据用户ID获取用户对象
     * @param userId
     * @return
     */
    ProUserAdminEntity getUserById(String userId);

    /**
     * 新增用户
     * @param user
     * @return
     */
    int addUser(ProUserAdminEntity user);

    /**
     * 修改用户
     * @param user
     * @return
     */
    int mergeUser(ProUserAdminEntity user);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    int deleteUser(String userId);

}
