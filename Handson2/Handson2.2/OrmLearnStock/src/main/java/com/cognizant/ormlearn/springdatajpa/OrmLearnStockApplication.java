package com.cognizant.ormlearn.springdatajpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.springdatajpa.model.Stock;
import com.cognizant.ormlearn.springdatajpa.service.StockService;



@SpringBootApplication
public class OrmLearnStockApplication {
	//private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnStockApplication.class);

	@Autowired
	private static StockService stockService;
	
	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(OrmLearnStockApplication.class, args);
		stockService=context.getBean(StockService.class);
		
		testQuery1();
		testQuery2();
		testQuery3();
		testQuery4();
		
	}
	
	private static void testQuery1()
	{
		System.out.println("Get all stock details of Facebook in the month of September 2019 :: ");
		List<Stock> stocks=stockService.testQuery1();
		System.out.println("\nst_code\tst_date\t\tst_open\tst_close st_volume");
		for(Stock stock:stocks)
			System.out.println(stock.getStcode()+"\t"+stock.getStdate()+"\t"+stock.getStopen()+"\t"+stock.getStclose()+"\t"+stock.getStvolume());
		
	}
	
	private static void testQuery2()
	{
		System.out.println("Get all google stock details where the stock price was greater than 1250 :: ");
		List<Stock> stocks=stockService.testQuery2();
		System.out.println("\nst_code\tst_date\t\tst_open\tst_close st_volume");
		for(Stock stock:stocks)
			System.out.println(stock.getStcode()+"\t"+stock.getStdate()+"\t"+stock.getStopen()+"\t"+stock.getStclose()+"\t"+stock.getStvolume());
		
	}
	
	private static void testQuery3()
	{
		System.out.println("Get all google stock details where the stock price was greater than 1250 :: ");
		List<Stock> stocks=stockService.testQuery3();
		System.out.println("\nst_code\tst_date\t\tst_open\tst_close st_volume");
		for(Stock stock:stocks)
			System.out.println(stock.getStcode()+"\t"+stock.getStdate()+"\t"+stock.getStopen()+"\t"+stock.getStclose()+"\t"+stock.getStvolume());
	}
	
	private static void testQuery4()
	{
		System.out.println("Identify three dates when Netflix stocks were the lowest :: ");
		List<Stock> stocks=stockService.testQuery4();
		System.out.println("\nst_code\tst_date\t\tst_open\tst_close st_volume");
		for(Stock stock:stocks)
			System.out.println(stock.getStcode()+"\t"+stock.getStdate()+"\t"+stock.getStopen()+"\t"+stock.getStclose()+"\t"+stock.getStvolume());
	}

	
}
