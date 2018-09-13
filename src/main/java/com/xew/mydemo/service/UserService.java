package com.xew.mydemo.service;

import com.xew.mydemo.dao.UserMapper;
import com.xew.mydemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    List<User> getAllUser();
    User getUserById(Long id);

}
