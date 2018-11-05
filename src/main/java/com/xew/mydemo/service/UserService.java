package com.xew.mydemo.service;

import com.xew.mydemo.model.User;
import com.xew.mydemo.vo.UserVO;

import java.util.List;


public interface UserService {
    void saveUser(UserVO userVO);
    User getUserByName(String name);
    boolean deleteUser(Long id);
    List<User> findAllUser();
}
