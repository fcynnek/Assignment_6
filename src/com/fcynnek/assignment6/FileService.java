package com.fcynnek.assignment6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

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
	
	public ArrayList<SalesPOJO> readSalesData (String fileName) {
		
		BufferedReader fileReader = null;
		
		Integer numberOfLines = countLines(fileName);
		
		ArrayList<SalesPOJO> salesDataList = new ArrayList<SalesPOJO>();
		
		int i = 0;
		
		try {
			fileReader = new BufferedReader(new FileReader(fileName));
			
			String line = null;
			
			try {
				while ((line = fileReader.readLine()) != null) {
					String[] parsedLine = line.split(",");
					Date parsedDate = parsedLine[0];
					String parsedSales = parsedLine[1];
					
					SalesPOJO salesData = new SalesPOJO();
					salesData.setDate(parsedDate);
					
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
