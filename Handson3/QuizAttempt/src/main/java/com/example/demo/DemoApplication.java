package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.bean.User;
import com.example.demo.service.QuestionService;
import com.example.demo.service.UserService;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	private static UserService userS;
	@Autowired
	private static QuestionService qService;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		userS.getUserById(1);
		userS.getUserAttemptDetailFullQuestion(1, 1);
		userS.getUserAttemptDetailFull(1, 1);
		userS.getUserAttemptDetail(1, 1);
		qService.getQuestiontionById(1);
		
		 
	}

}
