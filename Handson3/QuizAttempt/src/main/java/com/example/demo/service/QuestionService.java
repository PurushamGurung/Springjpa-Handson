package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.bean.Question;
import com.example.demo.repository.QuestionRepository;

@Component
public class QuestionService {
	private static final Logger LOGGER = LoggerFactory.getLogger(QuestionService.class);

	@Autowired
	QuestionRepository  questionRepository;
	
	
	public  Question getQuestiontionById(int id)
	{
		LOGGER.info("Start");
		Question question  = questionRepository.getQuestiontionById(id);
		LOGGER.info("question = {} ",question);
		LOGGER.info("end");
		return question;
		

		
	}

}
