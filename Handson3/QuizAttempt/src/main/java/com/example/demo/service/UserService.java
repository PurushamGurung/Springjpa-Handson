package com.example.demo.service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.bean.Attempt;
import com.example.demo.bean.AttemptOption;
import com.example.demo.bean.AttemptQuestion;
import com.example.demo.bean.Option;
import com.example.demo.bean.Question;
import com.example.demo.bean.User;
import com.example.demo.repository.UserRepository;

@Component
public class UserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	@Autowired
	UserRepository userRepository;

	@Transactional
	public User getUserById(int id) {
		LOGGER.info("Start");
		User user = userRepository.getUserById(id);
		LOGGER.info("User = {}", user);
		LOGGER.info("attempt = {}", user.getAttemptList());
		LOGGER.info("end");
		return user;
	}

	@Transactional
	public List<User> getAllUser() {
		LOGGER.info("Start");
		List<User> userList = userRepository.getAllUser();
		LOGGER.info("UserList = {}", userList);
		LOGGER.info("end");
		return userList;
	}

	@Transactional
	public User getUserAttemptDetail(int userId, int attemptId) {
		LOGGER.info("Start");
		User user = userRepository.getUserAttemptDetail(userId, attemptId);
		LOGGER.info("User = {}", user);
		LOGGER.info("attempt = {}", user.getAttemptList());
		LOGGER.info("end");
		return user;
	}

	@Transactional
	public User getUserAttemptDetailFull(int userId, int attemptId) {
		LOGGER.info("Start");
		User user = userRepository.getUserAttemptDetailFull(userId, attemptId);
		LOGGER.info("User = {}", user);
		LOGGER.info("attempt = {}", user.getAttemptList());
		Set<Attempt> attemptList = user.getAttemptList();
		System.out.println(" User  =   " );
		System.out.println(user.getId() +"   " +user.getName() +"   "+user.getEmail());
		//System.out.println("attempt :    " + user.getAttemptList());
		for (Attempt attempt : attemptList) {
			System.out.println("Attempt :  " +attempt);
			Set<AttemptQuestion> attemptQuestionList = attempt.getAttemptQuestionList();
			for (AttemptQuestion attemptQuestion : attemptQuestionList) {
				Question  question =attemptQuestion.getQuestion();
				System.out.println(question.getId()+"   "+question.getQuestionText());

			}
		}

		LOGGER.info("end");
		return user;
	}
	
	
	
	@Transactional
	public User getUserAttemptDetailFullQuestion(int userId, int attemptId) {
		LOGGER.info("Start");
		User user = userRepository.getUserAttemptDetailFullQuestion(userId, attemptId);
		LOGGER.info("User = {}", user);
		LOGGER.info("attempt = {}", user.getAttemptList());
		Set<Attempt> attemptList = user.getAttemptList();
		System.out.println(" User  =   " );
		System.out.println(user.getId() +"   " +user.getName() +"   "+user.getEmail());
		//System.out.println("attempt :    " + user.getAttemptList());
		for (Attempt attempt : attemptList) {
			System.out.println("Attempt :  " +attempt);
			Set<AttemptQuestion> attemptQuestionList = attempt.getAttemptQuestionList();
			for (AttemptQuestion attemptQuestion : attemptQuestionList) {
				Question  question =attemptQuestion.getQuestion();
				System.out.println(question.getId()+"   "+question.getQuestionText());
				Set<AttemptOption> attemptOptionList =attemptQuestion.getAttemptOptionList();
				System.out.format("%-20s%-20s%-80s%-20s%-10s\n", "AttemptOptionId","OptionId","OptionText","GivenScore","Seleced");
				for (AttemptOption attemptOption : attemptOptionList) {
					Option  option = attemptOption.getOption();
					System.out.format("%-20s%-20s%-80s%-20s%-10s\n",attemptOption.getId() ,option.getId(),option.getOptionText(),option.getScore(), attemptOption.isSelected());
					
				}

			}
		}

		LOGGER.info("end");
		return user;
	}

//	@Transactional
//	public User getUserAttemptDetailFullQuestion(int userId, int attemptId) {
//		LOGGER.info("Start");
//		User user = userRepository.getUserAttemptDetailFullQuestion(userId, attemptId);
//		LOGGER.info("User = {}", user);
//		LOGGER.info("attempt = {}", user.getAttemptList());
//		Set<Attempt> attemptList = user.getAttemptList();
//		LOGGER.info("attempt list size:{}", attemptList.size());
//		for (Attempt attempt : attemptList) {
//			LOGGER.info("attemptDetailList = {}", attempt.getAttemptDetailList());
//			LOGGER.info("attemptDetailList size = {}", attempt.getAttemptDetailList().size());
//		}
//		System.out.println(" User  =   " + user);
//		// System.out.println("attempt : "+user.getAttemptList());
//		for (Attempt attempt : attemptList) {
//			System.out.println("Attempt : " + attempt);
//			List<AttemptQuestion> attemptDeatilList = attempt.getAttemptDetailList();
//			for (AttemptQuestion attemptDetail : attemptDeatilList) {
//				Option option = attemptDetail.getOption();
//				Question question = option.getQuestion();
//				System.out.println(question.getId() + "   " + question.getQuestionText());
//				for (Option option1 : question.getOptionList()) {
//					System.out.println(option1.getId() + "  " + option1.getOptionText() + "  " + option1.getScore() + "  "
//							+ attemptDetail.isSelected());
//
//				}
//			}
//		}
//		LOGGER.info("end");
//		return user;
//	}

}
