package com.cognizant.ormlearn.springdatajpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.cognizant.ormlearn.springdatajpa.model.Country;
import com.cognizant.ormlearn.springdatajpa.model.CountrySearchPattern;
import com.cognizant.ormlearn.springdatajpa.service.CountryService;

@Controller
public class CountryController {

	@Autowired
	CountryService countryService;
	
	
	@RequestMapping(value="/letsee",method=RequestMethod.GET)
	public String showStartPage(@ModelAttribute("country") CountrySearchPattern csp)
	{
		return "checkthis";
	}
	
	@RequestMapping(value="/submitPatternMatching",method=RequestMethod.POST)
	public String getDetails(@ModelAttribute("country") CountrySearchPattern csp,ModelMap map)
	{
		List<Country> countries=countryService.getNameMatching(csp.getCode());
		map.put("countries", countries);
		return "result1";
	}
	@RequestMapping(value="/submitPatternMatchingWithSort",method=RequestMethod.POST)
	public String getDetailss(@ModelAttribute("country") CountrySearchPattern csp,ModelMap map)
	{
		List<Country> countries=countryService.getNameMatchingSorted(csp.getCode());
		map.put("countries", countries);
		return "result2";
	}
}
