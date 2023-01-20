package com.fcynnek.assignment6;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class SalesPOJO {
// this class will be used to store the data from the three separate CSV files
	
	private LocalDate date;
	private Long sales;

	
	
	public LocalDate getDate() {
		return date;
	}
	public Long getSales() {
		return sales;
	}
	
	

	public void setDate(LocalDate formattedDate) {
		this.date = formattedDate;
	}
	public void setSales(Long sales) {
		this.sales = sales;
	}


	
}
