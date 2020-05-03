package com.example.springbootwebsocket;

import com.example.springbootwebsocket.controller.UserController;
import com.example.springbootwebsocket.model.Name;
import com.example.springbootwebsocket.model.User;
import com.example.springbootwebsocket.model.UserResponce;
import org.junit.Assert;
import org.junit.Test;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringBootWebsocketApplicationTests {

	@Test
	public void UserResponceTest() {
		UserController userController =  new UserController();
		User user = new User("Sohel");
		UserResponce userResponce = userController.getUser(user,new Name("Sohel"));

		System.out.println(userResponce.getContent());
		Assert.assertEquals(userResponce.getContent(),"Sohel : Sohel");
	}

}
