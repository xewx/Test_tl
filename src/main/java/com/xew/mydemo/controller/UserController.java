package com.xew.mydemo.controller;

import com.xew.mydemo.model.User;
import com.xew.mydemo.service.UserService;
import com.xew.mydemo.util.ResultResponse;
import com.xew.mydemo.vo.UserVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResultResponse register(UserVO userVO){
        ResultResponse rr=new ResultResponse(false);
        if(userVO!=null) {
            if(userService.getUserByName(userVO.getName())==null) {
                try {
                    userService.saveUser(userVO);
                    rr.setResult(true);
                } catch (Exception e) {
                    rr.setMessage("Save fail!");
                }
            }else {
                rr.setMessage("User name already exists!");
            }
        }
        return rr;
    }

    @PostMapping("/login")
    public String login(String name, String password, HttpServletRequest request){
        User user = userService.getUserByName(name);
        if(user==null){
            return "UserName dose not exist!";
        }
        if(password.equals(user.getPassword())){
            request.getSession().setAttribute("userId",user.getId());
            request.getSession().setAttribute("userName",name);
            return "Success";
        }else{
            return "Password Wrong";
        }
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
