package com.cognizant.ormlearn.springdatajpa.service;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.springdatajpa.model.Stock;
import com.cognizant.ormlearn.springdatajpa.repos.StockRepository;

@Service
public class StockService {
 @Autowired
 private StockRepository stockRepository;
 
 @SuppressWarnings("deprecation")
@Transactional
 public List<Stock> testQuery1()
 {
	 return stockRepository.findByStcodeAndStdateBetween("FB",new Date(119,8,1),new Date(119,8,30));
 }
 
 @Transactional
 public List<Stock> testQuery2()
 {
	 return stockRepository.findByStcodeAndStopenGreaterThanOrStcloseGreaterThan("GOOGL",1250D,1250D);
 }
 
 @Transactional
 public List<Stock> testQuery3()
 {
	 return stockRepository.findTop3ByOrderByStvolumeDesc();
 }
 
 @Transactional
 public List<Stock> testQuery4()
 {
	 return stockRepository.findTop3ByStcodeOrderByStcloseAsc("NFLX");
 }
}
