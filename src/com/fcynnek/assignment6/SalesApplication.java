package com.fcynnek.assignment6;

import java.util.ArrayList;
import java.util.List;

public class SalesApplication {

	public static void main(String[] args) {

		// Files containing the sales data for the models
		String teslaModel3 = "model3.csv";
		String teslaModelS = "modelS.csv";
		String teslaModelX = "modelX.csv";

		FileService fileService = new FileService();
		SalesPOJO salesData = new SalesPOJO();
		
		
		
		List<SalesPOJO> salesDataList = fileService.readSalesData(teslaModel3);
		
		salesDataList.stream()
					 .forEach(item -> System.out.println(salesData.getDate() + " & " + salesData.getSales()));
		
	}

}
