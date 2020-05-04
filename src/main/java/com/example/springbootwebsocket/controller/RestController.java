package com.example.springbootwebsocket.controller;

import com.example.springbootwebsocket.model.User;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @RequestMapping("/welcome")
    public String toAdd(User user) {
        return "welcome";
    }
}
