package com.example.boot_demo.service;

import com.example.boot_demo.dao.UserDao;
import com.example.boot_demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Long id) {
        return userDao.findById(id).orElse(null);
    }

    @Override
    public User getUserByName(String name) {
        return userDao.findByName(name);
    }
}
