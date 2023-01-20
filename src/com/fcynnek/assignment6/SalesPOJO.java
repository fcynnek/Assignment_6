package com.fcynnek.assignment6;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Date;

public class SalesPOJO {
// this class will be used to store the data from the three separate CSV files
	
	private YearMonth date;
	private Long sales;

	
	
	public YearMonth getDate() {
		return date;
	}
	public Long getSales() {
		return sales;
	}
	
	

	public void setDate(YearMonth formattedDate) {
		this.date = formattedDate;
	}
	public void setSales(Long sales) {
		this.sales = sales;
	}


	
}
