package com.example.springbootwebsocket.controller;

import com.example.springbootwebsocket.config.WebSocketConfig;
import com.example.springbootwebsocket.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class UserController {
    @Autowired
    private WebSocketConfig webSocketConfig;

    @MessageMapping("/message")
    @SendTo("/topic/user")
    public UserResponce getUser(Name name, User user) {

        return new UserResponce(name.getName(), HtmlUtils.htmlEscape(user.getMessage()));

        //HtmlUtils.htmlEscape - Turn special characters into HTML character references
    }
    @MessageMapping("/notify")
    @SendTo("/topic/user")
    public UserResponce getUserCount(User user,Name name) {

        return new UserResponce(name.getName(), HtmlUtils.htmlEscape(user.getMessage()));
    }
}

