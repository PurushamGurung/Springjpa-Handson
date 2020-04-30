package com.cognizant.ormlearn.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;

	@Transactional
	public List<Country> getAllCountries() {
		return countryRepository.findAll();
	}

	@Transactional
	public List<Country> getNameMatching(String pat) {
		return countryRepository.findByNameContains(pat);
	}

	@Transactional
	public List<Country> getNameMatchingSorted(String pat) {
		return countryRepository.findByNameContains(pat, Sort.by("name"));
	}

	public void saveCountry(String code, String name) {
		Country entity = new Country();
		entity.setCode(code);
		entity.setName(name);
		countryRepository.save(entity);

	}

	public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
//		Optional<Country> country=repos.findById(countryCode);
//		return country.get();
		// return repos.findById(countryCode).get();

		Optional<Country> result = countryRepository.findById(countryCode);
		if (result.isPresent()) {
			Country country = result.get();
			return country;
		} else
			throw new CountryNotFoundException("Wrong Code");
	}

	@Transactional
	public void addCountry(Country country) {
		countryRepository.save(country);
	}

	@Transactional
	public void updateCountry(String code, String name) {
		Country country = countryRepository.findById(code).get();
		country.setName(name);
		countryRepository.save(country);

	}

	@Transactional
	public void deleteCountry(String code) {
		countryRepository.deleteById(code);
	}

//	@Transactional
//	public List<Country> matchingCountry(String pat)
//	{
//		return countryRepository.findByNameLike("%"+pat+"%");
//	}
}
