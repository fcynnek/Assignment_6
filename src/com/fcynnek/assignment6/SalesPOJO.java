package com.fcynnek.assignment6;

import java.util.Date;

public class SalesPOJO {
// this class will be used to store the data from the three separate CSV files
	
	private Date model3_date;
	private Long model3_sales;
	private Date modelS_date;
	private Long modelS_sales;
	private Date modelX_date;
	private Long modelX_sales;
	
	
	public Date getModel3_date() {
		return model3_date;
	}
	public Long getModel3_sales() {
		return model3_sales;
	}
	public Date getModelS_date() {
		return modelS_date;
	}
	public Long getModelS_sales() {
		return modelS_sales;
	}
	public Date getModelX_date() {
		return modelX_date;
	}
	public Long getModelX_sales() {
		return modelX_sales;
	}
	
	
	public void setModel3_date(Date model3_date) {
		this.model3_date = model3_date;
	}
	public void setModel3_sales(Long model3_sales) {
		this.model3_sales = model3_sales;
	}
	public void setModelS_date(Date modelS_date) {
		this.modelS_date = modelS_date;
	}
	public void setModelS_sales(Long modelS_sales) {
		this.modelS_sales = modelS_sales;
	}
	public void setModelX_date(Date modelX_date) {
		this.modelX_date = modelX_date;
	}
	public void setModelX_sales(Long modelX_sales) {
		this.modelX_sales = modelX_sales;
	}
	
	
}
