package com.fcynnek.assignment6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
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
	
	String teslaModel3 = "model3.csv";
	String teslaModelS = "modelS.csv";
	String teslaModelX = "modelX.csv";
	
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
		
		Integer numberOfLines = countLines(fileName);
		
		List<SalesPOJO> salesDataList = new ArrayList<SalesPOJO>();
		
		int i = 0;
		
		try {
			fileReader = new BufferedReader(new FileReader(fileName));
			
			String line = null;
			
			try {
				while ((line = fileReader.readLine()) != null) {
					String[] parsedLine = line.split(",");
					String parsedDate = parsedLine[0];
					String parsedSales = parsedLine[1];
					
					List<SalesPOJO> salesData = new ArrayList<SalesPOJO>();
					Date formattedDate = new SimpleDateFormat("MM-yyyy").parse(parsedDate);
					salesData.setDate(formattedDate);
					salesData.setSales(parsedSales);
					
				}
			} catch (IOException e) {
				System.out.println("I/O Exception ocurred while reading the file");
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println(".csv file error");
			e.printStackTrace();
		}
		
		
		return null;
		
	}
}
