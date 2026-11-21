package com.example.boot_demo.service;

import com.example.boot_demo.entity.User;

public interface UserService {
    User getUserById(Long id);
    User getUserByName(String name);
}
