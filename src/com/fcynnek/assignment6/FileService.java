package com.fcynnek.assignment6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
	
	public SalesPOJO[] readSalesData (String fileName) {
		
		BufferedReader fileReader = null;
		
		Integer numberOfLines = countLines(fileName);
		
		SalesPOJO[] salesData = new SalesPOJO[numberOfLines];
		
		int i = 0;
		
		try {
			fileReader = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			System.out.println(".csv file error");
			e.printStackTrace();
		}
		
		
		return null;
		
	}
}
