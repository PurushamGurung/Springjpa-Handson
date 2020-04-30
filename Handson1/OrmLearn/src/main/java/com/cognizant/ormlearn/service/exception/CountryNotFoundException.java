package com.cognizant.ormlearn.service.exception;

@SuppressWarnings("serial")
public class CountryNotFoundException extends Exception{

	public CountryNotFoundException() {}
	public CountryNotFoundException(String string) {
		// TODO Auto-generated constructor stub
		System.out.println(string);
	}

}
