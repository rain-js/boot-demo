package com.example.boot_demo.dao;

import com.example.boot_demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long>{
    User findByName(String name);
}
