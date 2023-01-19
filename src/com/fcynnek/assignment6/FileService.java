package com.fcynnek.assignment6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Formatter;
import java.time.format.*;

public class FileService {
// this class will read the three CSV files 
	
	public static Integer countLines (String fileName) {
		
		BufferedReader fileReader = null;
		
		int numberOfLines = 0;
		
		try {
			fileReader = new BufferedReader(new FileReader(fileName));
			try {
				while ((fileReader.readLine()) != null) {
					numberOfLines = numberOfLines + 1;
				}
			} catch (IOException e) {
				System.out.println("I/O exception ocurred while reading the file");
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println(".csv file error");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				System.out.println("I/O exception ocurred while closing the reader");
				e.printStackTrace();
			}
		}
		return numberOfLines;
	}
	
	public List<SalesPOJO> readSalesData (String fileName) {
		
		BufferedReader fileReader = null;
		
		Integer numberOfLines = countLines(fileName); // I don't think I need this now?
		
		List<SalesPOJO> salesDataList = new ArrayList<SalesPOJO>();
		
		try {
			fileReader = new BufferedReader(new FileReader(fileName));
			
			String line = null;
			
			try {
				while ((line = fileReader.readLine()) != null) {
					String[] parsedLine = line.split(",");
					String parsedDate = parsedLine[0];
					String parsedSales = parsedLine[1];
					
					SalesPOJO salesData = new SalesPOJO();
					LocalDateTime formattedDate = LocalDateTime.parse(parsedDate, DateTimeFormatter.ofPattern("MM-yy"));
					salesData.setDate(formattedDate);
					Long stringToLong = Long.parseLong(parsedSales);
					salesData.setSales(stringToLong);
										
					salesDataList.add(salesData);
					
				}
			} catch (IOException e) {
				System.out.println("I/O Exception ocurred while reading the file");
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println(".csv file error");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				System.out.println("I/O Exception ocurred while closing the reader");
				e.printStackTrace();
			}
		}
		
		
		return salesDataList;
		
	}
}
