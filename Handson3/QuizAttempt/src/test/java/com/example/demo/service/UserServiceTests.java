package com.example.demo.service;

import java.util.List;

import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.bean.Question;
import com.example.demo.bean.User;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceTests.class);

	@Autowired
	UserService userService;

	@Autowired
	QuestionService questionService;

	@Test
	public void getUserTest() {
		LOGGER.info("Start");
		User user = userService.getUserById(1);
		LOGGER.info("End");
	}
//
//	@Test
//	public void getAllUserTest() {
//		LOGGER.info("Start");
//		List<User> userList = userService.getAllUser();
//		LOGGER.info("End");
//	}
//
//	@Test
//	public void getQuestionTest() {
//		LOGGER.info("Start");
//		Question question = questionService.getQuestiontionById(1);
//		LOGGER.info("End");
//	}
//
//	@Test
//	public void getUserAttemptDetail() {
//		LOGGER.info("Start");
//		User user = userService.getUserAttemptDetail(1, 1);
//		LOGGER.info("End");
//	}

	@Test
	public void getUserAttemptDetailFull() {
		LOGGER.info("Start");
		User user = userService.getUserAttemptDetailFull(1, 1);
		LOGGER.info("End");
	}

	@Test
	public void getUserAttemptDetailFullQuestion() {
		LOGGER.info("Start");
		User user = userService.getUserAttemptDetailFullQuestion(1, 1);
		LOGGER.info("End");
	}

}
