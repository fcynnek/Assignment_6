package com.fcynnek.assignment6;

import java.util.Date;

public class SalesPOJO {
// this class will be used to store the data from the three separate CSV files
	
	private Date date;
	private Long sales;
	
	
	public Date getDate() {
		return date;
	}
	public Long getSales() {
		return sales;
	}
	
	
	public void setDate(Date date) {
		this.date = date;
	}
	public void setSales(Long sales) {
		this.sales = sales;
	}
	
}
