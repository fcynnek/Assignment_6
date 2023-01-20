package com.fcynnek.assignment6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalesApplication {

	public static void main(String[] args) {

		// Files containing the sales data for the models
		String teslaModel3 = "model3.csv";
		String teslaModelS = "modelS.csv";
		String teslaModelX = "modelX.csv";

		FileService fileService = new FileService();
		
		
		
		
		List<SalesPOJO> salesDataList = fileService.readSalesData(teslaModel3);
		
		salesDataList.stream()
					 .forEach(salesData -> System.out.println(salesData.getDate().getYear() + " & " + salesData.getSales()));
		
		Map<Integer, Long> totalSalesPerYear = new HashMap<>();
		
		salesDataList.stream().forEach(salesData -> {
			Integer salesYear = salesData.getDate().getYear();
			Long salesValue = salesData.getSales();
			if (totalSalesPerYear.containsKey(salesYear)) {
				Long tempValue = totalSalesPerYear.get(salesYear);
				salesValue = tempValue + salesValue;
				totalSalesPerYear.put(salesYear, salesValue);
			} else {
				totalSalesPerYear.put(salesYear, salesValue);
			}
		});
		
		System.out.println();
	}

}
