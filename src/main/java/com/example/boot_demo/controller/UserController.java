package com.example.boot_demo.controller;

import com.example.boot_demo.entity.User;
import com.example.boot_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // 返回JSON数据
@RequestMapping("/api/users") // 统一路径前缀
public class UserController {

    @Autowired // 依赖注入Service
    private UserService userService;

    // GET /api/users/1
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user); // 返回200状态码+数据
    }

    // GET /api/users/name?name=小明
    @GetMapping("/name")
    public ResponseEntity<User> getUserByName(@RequestParam String name) {
        User user = userService.getUserByName(name);
        return ResponseEntity.ok(user);
    }
}