package com.cognizant.ormlearn.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
//	List<Country> findByNameLike(String pat);
	//List<Country> findByName(String name);
//	List<Country> findByName(String name);
//	List<Country> findByOrderByName();
	List<Country> findByNameContains(String pat);
	List<Country> findByNameContains(String pat,Sort sort);
	
//	

}
