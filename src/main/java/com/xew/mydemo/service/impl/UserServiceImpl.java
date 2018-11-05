package com.xew.mydemo.service.impl;

import com.xew.mydemo.dao.UserRepository;
import com.xew.mydemo.model.User;
import com.xew.mydemo.service.UserService;
import com.xew.mydemo.vo.UserVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(UserVO userVO) {
        User user = new User();
        user.setName(userVO.getName());
        user.setPassword(userVO.getPassword());
        user.setSex(userVO.getSex());
        user.setPhone(userVO.getPhone());
        user.setEmail(userVO.getEmail());
        user.setCreateDate(new Date());
        userRepository.save(user);
    }

    @Override
    public User getUserByName(String name) {
        if(StringUtils.isNotBlank(name)){
            User user=userRepository.findByName(name);
            return user;
        }else {
            return null;
        }
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
}
