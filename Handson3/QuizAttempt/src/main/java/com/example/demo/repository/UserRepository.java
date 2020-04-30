package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.bean.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value = "Select  u from User u left  join fetch  u.attemptList   where u.id=:id")
	public User getUserById(int id);

	@Query(value = "Select  u from User u  order by u.name")
	public List<User> getAllUser();

	@Query(value = "Select  u from User u left join fetch   u.attemptList a   where u.id=:userId  and   a.id=:attemptId")
	public User getUserAttemptDetail(int userId, int attemptId);

	@Query(value = "Select  u from User u  left join fetch   u.attemptList a left join  a.attemptQuestionList aql   where u.id=:userId  and   a.id=:attemptId")
	public User getUserAttemptDetailFull(int userId, int attemptId);

	@Query(value = "Select  u from User u  left join fetch   u.attemptList a left join    a.attemptQuestionList aql  join    aql.attemptOptionList  aol   where u.id=:userId  and   a.id=:attemptId")
    public User getUserAttemptDetailFullQuestion(int userId, int attemptId);

}
