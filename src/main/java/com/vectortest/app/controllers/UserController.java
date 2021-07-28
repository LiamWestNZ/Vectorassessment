package com.vectortest.app.controllers;

import com.vectortest.app.models.UserEntity;
import com.vectortest.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;



    @RequestMapping(method=RequestMethod.POST, value="/user")
    public String addUser(@RequestBody UserEntity userEntity){
        userService.addUser(userEntity);
        String response = "{\"success\": true, \"message\": User has been created successfully}";
        return response;
    }

    @RequestMapping("/user/{email}")
    public UserEntity getUser(@PathVariable String email){
        return userService.getUser(email);
    }

    @PutMapping("/user/{email}")
    public String updateUser(@RequestBody UserEntity userEntity, @PathVariable String email){
        userService.updateUser(email, userEntity);
        String response = "{\"success\": true, \"message\": The user was updated successfully.}";
        return response;
    }

    @DeleteMapping("/user/{email}")
    public String deleteUser(@PathVariable String email){
        userService.deleteUser(email);
        String response = "{\"success\": true, \"message\": The user was deleted successfully.}";
        return response;
    }

    @RequestMapping(value="/users")
    public List<UserEntity> getAllUsers(){
        return (userService.getAllUsers());
    }
}
