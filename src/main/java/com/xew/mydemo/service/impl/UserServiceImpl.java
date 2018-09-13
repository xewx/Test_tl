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
    public boolean saveUser(User u) {
        if(u.getName() != null){
            userRepository.save(u);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public boolean deleteUser(Long id) {
        if(userRepository.findOne(id) != null){
            userRepository.delete(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public boolean updateUser(User u) {
        if(u != null){
            userRepository.save(u);
            return true;
        }else {
            return false;
        }
    }
}
