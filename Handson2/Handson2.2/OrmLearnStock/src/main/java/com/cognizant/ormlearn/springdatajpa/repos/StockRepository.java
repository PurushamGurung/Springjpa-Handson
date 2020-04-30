package com.cognizant.ormlearn.springdatajpa.repos;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.ormlearn.springdatajpa.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer> {
	List<Stock> findByStcodeAndStdateBetween(String code,Date d1,Date d2);
	List<Stock> findByStcodeAndStopenGreaterThanOrStcloseGreaterThan(String code,Double p1,Double p2);
	List<Stock> findTop3ByOrderByStvolumeDesc();
	List<Stock> findTop3ByStcodeOrderByStcloseAsc(String code);
}
