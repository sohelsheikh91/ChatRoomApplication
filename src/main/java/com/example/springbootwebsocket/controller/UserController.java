package com.example.springbootwebsocket.controller;

import com.example.springbootwebsocket.model.*;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;

@Controller
public class UserController {

    @MessageMapping("/hello")
    @SendTo("/topic/user")
    public UserResponce getUser(User user,Name name) {

        return new UserResponce(name.getName()+" : "+HtmlUtils.htmlEscape(user.getMessage()));
    }


//    @MessageMapping("/hi")
//    @SendTo("/topic/name")
//    public UserResponce getUser(Name name) {
//        return new UserResponce(HtmlUtils.htmlEscape(name.getName()));
//    }


}

