package com.vectortest.app.service;

import com.vectortest.app.exception.ApiRequestException;
import com.vectortest.app.models.UserEntity;
import com.vectortest.app.repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getAllUsers(){
        List<UserEntity> userList = new ArrayList<>();
        userRepository.findAll().forEach(userList::add);
        if(userList == null){
            throw new ApiRequestException("There are no users");
        }
        return userList;
    }

    public UserEntity getUser(String email) {
        if(!userRepository.existsById(email)){
            throw new ApiRequestException("That user does not exist");
        }
        return userRepository.findById(email).orElse(null);
    }

    public void addUser(UserEntity userEntity) {
        if(userRepository.existsById(userEntity.getEmail())){
            throw new ApiRequestException("That user already exists");
        }
        userRepository.save(userEntity);
    }

    public void updateUser(String email, UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    public void deleteUser(String email) {
        if(!userRepository.existsById(email)){
            throw new ApiRequestException("That user does not exist");
        }
        userRepository.deleteById(email);
    }
}



