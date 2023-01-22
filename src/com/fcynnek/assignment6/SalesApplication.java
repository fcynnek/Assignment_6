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

		
		generateYearlyReport(teslaModel3, "Model 3");
		System.out.println(""); // for spacing
		calculateBestMonth(teslaModel3, "Model 3");
		calculateWorstMonth(teslaModel3, "Model 3");
		System.out.println(""); // for spacing

		generateYearlyReport(teslaModelS, "Model S");
		System.out.println(""); // for spacing
		calculateBestMonth(teslaModelS, "Model S");
		calculateWorstMonth(teslaModelS, "Model S");
		System.out.println(""); // for spacing
		
		generateYearlyReport(teslaModelX, "Model X");
		System.out.println(""); // for spacing
		calculateBestMonth(teslaModelX, "Model X");
		calculateWorstMonth(teslaModelX, "Model X");
	}

	

	

	public static void generateYearlyReport(String fileName, String reportName) {
		FileService fileService = new FileService();
		List<SalesPOJO> salesDataList = fileService.readSalesData(fileName);
		Map<Integer, Long> totalSalesPerYear = new HashMap<>();
		
		salesDataList.stream()
					 .forEach(salesData -> {
						 Integer salesYear = salesData.getDate().getYear();
						 Long salesValue = salesData.getSales();
						 if (totalSalesPerYear.containsKey(salesYear)) {
							 Long currentValue = totalSalesPerYear.get(salesYear);
							 salesValue = currentValue + salesValue;
							 totalSalesPerYear.put(salesYear, salesValue);
						 } else {
							 totalSalesPerYear.put(salesYear, salesValue);
						 }
					 });
		System.out.println("Reference for checking: " + totalSalesPerYear);	
		System.out.println(reportName + " Yearly Sales Report\n---------------------------");
		totalSalesPerYear.forEach((year, sale) -> System.out.println(year + " -> " + sale));
	}

	public static void calculateBestMonth(String fileName, String reportName) {
		FileService fileService = new FileService();
		List<SalesPOJO> salesDataList = fileService.readSalesData(fileName);
		Map<YearMonth, Long> bestSalesMonth = new HashMap<>();
		
		salesDataList.stream()
					 .forEach(salesData -> {
						 YearMonth salesYearMonth = salesData.getDate();
						 Long salesValue = salesData.getSales();
						 Long currentMax = bestSalesMonth.get(salesYearMonth);
						 if (currentMax == null || salesValue > currentMax) {
							 bestSalesMonth.put(salesYearMonth, salesValue);
						 }
					 });
		YearMonth bestYearMonth = bestSalesMonth.entrySet().stream()
												.max(Map.Entry.comparingByValue())
												.map(entry -> entry.getKey())
												.orElse(null);
		System.out.println("The best month for " + reportName + " was: " + bestYearMonth);
	}
	
	public static void calculateWorstMonth(String fileName, String reportName) {
		FileService fileService = new FileService();
		List<SalesPOJO> salesDataList = fileService.readSalesData(fileName);
		Map<YearMonth, Long> worstSalesMonth = new HashMap<>();
		
		salesDataList.stream()
					 .forEach(salesData -> {
						 YearMonth salesYearMonth = salesData.getDate();
						 Long salesValue = salesData.getSales();
						 Long currentMin = worstSalesMonth.get(salesYearMonth);
						 if (currentMin == null || salesValue < currentMin) {
							 worstSalesMonth.put(salesYearMonth, salesValue);
						 }
					 });
		YearMonth worstYearMonth = worstSalesMonth.entrySet().stream()
												  .min(Map.Entry.comparingByValue())
												  .map(entry -> entry.getKey())
												  .orElse(null);
		System.out.println("The worst month for " + reportName + " was: " + worstYearMonth);
	}
}
