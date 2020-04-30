package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.bean.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

	@Query(value = "select q from Question q  join fetch q.optionList   where q.id=1")
	public Question getQuestiontionById(int id);

}

