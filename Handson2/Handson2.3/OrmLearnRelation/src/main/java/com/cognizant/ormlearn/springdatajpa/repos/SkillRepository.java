package com.cognizant.ormlearn.springdatajpa.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.ormlearn.springdatajpa.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Integer> {

}
