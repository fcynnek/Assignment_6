package com.fcynnek.assignment6;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class SalesPOJO {
// this class will be used to store the data from the three separate CSV files
	
	private LocalDateTime date;
	private Long sales;

	
	
	public LocalDateTime getDate() {
		return date;
	}
	public Long getSales() {
		return sales;
	}
	
	

	public void setDate(LocalDateTime formattedDate) {
		this.date = formattedDate;
	}
	public void setSales(Long sales) {
		this.sales = sales;
	}


	
}
