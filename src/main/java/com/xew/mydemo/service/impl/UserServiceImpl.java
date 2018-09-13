package com.xew.mydemo.service.impl;

import com.xew.mydemo.dao.UserRepository;
import com.xew.mydemo.model.User;
import com.xew.mydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findOne(id);
    }
}
