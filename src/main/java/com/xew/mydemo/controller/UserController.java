package com.xew.mydemo.controller;

import com.xew.mydemo.model.User;
import com.xew.mydemo.service.UserService;
import com.xew.mydemo.util.ResultResponse;
import com.xew.mydemo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(value = "/xew")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResultResponse register(UserVO userVO){
        ResultResponse rr=new ResultResponse(false);
        System.out.println(userVO);
        User user = new User();
        user.setName(userVO.getName());
        user.setPassword(userVO.getPassword());
        user.setSex(userVO.getSex());
        user.setPhone(userVO.getPhone());
        user.setEmail(userVO.getEmail());
        userService.saveUser(user);
        rr.setResult(true);
        return rr;
    }

//    @GetMapping("/getAll")
//    public List<User> getAll() {
//        return userService.findAllUser();
//    }
//
//    @GetMapping("/search")
//    public User getOne(Long id) {
//        return userService.getUserById(id);
//    }
//
//    @PostMapping(value = "/save")
//    public boolean save(User user) {
//        return userService.saveUser(user);
//    }
//
//    @PutMapping(value = "/update")
//    public boolean update(User u) {
//        return userService.saveUser(u);
//    }
//
//    @GetMapping(value = "/delete")
//    public boolean delete(Long id) {
//        return userService.deleteUser(id);
//    }

//    @GetMapping("/a")
//    public ModelAndView index() {
//        ModelAndView mv=new ModelAndView();
//        mv.setViewName("../jsp/uploadfile");
//        return mv;
//    }
//    @GetMapping("/delete")
//    public
}
