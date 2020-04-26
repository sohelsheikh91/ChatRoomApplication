package com.example.springbootwebsocket.controller;

import com.example.springbootwebsocket.model.Greeting;
import com.example.springbootwebsocket.model.Message;
import com.example.springbootwebsocket.model.User;
import com.example.springbootwebsocket.model.UserResponce;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class UserController {

    @MessageMapping("/user")
    @SendTo("/topic/user")
    public UserResponce getUser(User user) {
        return new UserResponce(HtmlUtils.htmlEscape(user.getName()));
    }


}

