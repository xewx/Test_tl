package com.xew.mydemo.service;

import com.xew.mydemo.model.User;

import java.util.List;


public interface UserService {
    boolean saveUser(User u);
    User getUserByName(String name);
    boolean deleteUser(Long id);
    List<User> findAllUser();
}
