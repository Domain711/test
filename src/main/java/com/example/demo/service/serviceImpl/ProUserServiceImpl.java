package com.example.demo.service.serviceImpl;

import com.example.demo.dao.ProUserAdminDao;
import com.example.demo.entity.ProUserAdminEntity;
import com.example.demo.service.ProUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProUserServiceImpl implements ProUserService {

    @Autowired
    private ProUserAdminDao userDao;

    @Override
    public List<ProUserAdminEntity> queryALl() {
        List<ProUserAdminEntity> res = userDao.queryAll();
        return res;
    }

    @Override
    public int addUser(ProUserAdminEntity user) {
        int count = userDao.addUser(user);
        return count;
    }

    @Override
    public ProUserAdminEntity getUserById(String userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public int mergeUser(ProUserAdminEntity user) {
        int count = userDao.mergeUser(user);
        return count;
    }

    @Override
    public int deleteUser(String userId) {
        int count = userDao.deleteUser(userId);
        return count;
    }
}
