package com.fcynnek.assignment6;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SalesApplication {

	public static void main(String[] args) {

		// Files containing the sales data for the models
		String teslaModel3 = "model3.csv";
		String teslaModelS = "modelS.csv";
		String teslaModelX = "modelX.csv";

		
		
//		salesDataList.stream()
//					 .forEach(salesData -> System.out.println(salesData.getDate().getYear() + " & " + salesData.getSales()));
		FileService fileService = new FileService();
		List<SalesPOJO> salesDataList = fileService.readSalesData(teslaModel3);
		Map<Integer, Long> totalSalesPerYear = new HashMap<>();
		
		salesDataList.stream()
					 .forEach(salesData -> {
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
		System.out.println("Reference for checking: " + totalSalesPerYear);	
		System.out.println("Model 3 Yearly Sales Report\n---------------------------\n");
		totalSalesPerYear.forEach((year, sale) -> System.out.println(year + " -> " + sale));
		
		Map<YearMonth, Long> bestSalesMonth = new HashMap<>();
		
		salesDataList.stream().max(Comparator.comparingLong(salesDataList.get(0)));
//					 .forEach(salesData -> {
//						 YearMonth salesYearMonth = salesData.getDate();
//						 Long salesValue = salesData.getSales();
//						 if (bestSalesMonth.containsValue(salesValue) < salesValue) {
//							 
//						 }
//					 });
	
//		Map.Entry<yearMonth, sales> bestSalesMonth = null;
//		for (Map.Entry<yearMonth, sales> currentEntry : map.entrySet()) {
//			if (bestSalesMonth == null || currentEntry.getSales().c)
//		}
		
		
		
		
		
	}

}
