package com.cognizant.ormlearn.springdatajpa.service;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.springdatajpa.model.Country;
import com.cognizant.ormlearn.springdatajpa.repos.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;

	@Transactional
	public List<Country> getNameMatching(String pat) {
		return countryRepository.findByNameContains(pat);
	}

	@Transactional
	public List<Country> getNameMatchingSorted(String pat) {
		return countryRepository.findByNameContains(pat, Sort.by("name"));
	}

}
