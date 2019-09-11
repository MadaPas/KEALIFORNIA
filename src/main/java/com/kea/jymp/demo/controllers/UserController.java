package com.kea.jymp.demo.controllers;


import com.kea.jymp.demo.models.User;
import com.kea.jymp.demo.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepo UserRepo;

    // Get all users
    @GetMapping("/api/users")
    @ResponseBody
    public List<User> findAll() {
        List<User> users = UserRepo.findAll();
        return users;
    }

    // Post new user
    @PostMapping("/api/users")
    @ResponseBody
    public int addOne(@RequestBody User newUser){
        return UserRepo.addOne(newUser);
    }

    // Get one user
    @GetMapping("/api/users/{id}")
    @ResponseBody
    public User findOne(@PathVariable int id) {
        return UserRepo.findOne(id);
    }

    // Delete one user
    @DeleteMapping("/api/users/{id}")
    @ResponseBody
    public void deleteOne(@PathVariable int id) {
        UserRepo.deleteOne(id);
    }

    // Update one user
    @PutMapping("/api/users/{id}")
    @ResponseBody
    public void updateOne(@PathVariable int id, @RequestBody User updatedObject){

        System.out.println("dd");
        System.out.println(updatedObject);
        UserRepo.updateOne(id, updatedObject);

    }

}
