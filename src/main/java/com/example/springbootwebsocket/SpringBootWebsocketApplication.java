package com.example.springbootwebsocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
@RestController
public class SpringBootWebsocketApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebsocketApplication.class, args);
	}

	@GetMapping("/")
	public ModelAndView login() {
		return new ModelAndView("chat");
	}
}
