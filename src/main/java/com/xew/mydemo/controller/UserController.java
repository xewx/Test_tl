package com.xew.mydemo.controller;

import com.xew.mydemo.model.User;
import com.xew.mydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(value = "/xew")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String test(){
//        ModelAndView m = new ModelAndView();
//        m.setViewName("hello");
        return "hello world";
    }

    @GetMapping("/getAll")
    public List<User> getAll(){
        return userService.getAllUser();
    }

    @GetMapping("/search")
    public User getOne(Long id){
        return userService.getUserById(id);
    }

//    @GetMapping("/a")
//    public ModelAndView index() {
//        ModelAndView mv=new ModelAndView();
//        mv.setViewName("../jsp/uploadfile");
//        return mv;
//    }
//    @GetMapping("/delete")
//    public
}
