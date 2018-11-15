package com.imooc.firstappdemo.controller;

import com.imooc.firstappdemo.domain.User;
import com.imooc.firstappdemo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//此注解包括两部分内容，第一，它是一个Controller，二，它返回的是一个ResponseBody
@Slf4j
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    //@Autowired可写可不写，此处只是为了理解方便
    //构造器进行注入的方式，好处：1、不能修改；2、可以提早的进行初始化
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository ;
    }

    @PostMapping("/person/save")
    public User save(@RequestParam("name") String name) {
        User user = new User();
        user.setName(name);
        if(userRepository.save(user)){
//            System.out.printf("用户对象:" + user + "保存成功! ");
            log.info("【保存用户对象】user={}", user);
        }

        return user;
    }

}
