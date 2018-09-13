package com.xew.mydemo.service;

import com.xew.mydemo.dao.UserMapper;
import com.xew.mydemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    boolean saveUser(User u);
    User getUserById(Long id);
    boolean deleteUser(Long id);
    List<User> findAllUser();
    boolean updateUser(User id);

}
