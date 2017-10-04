package com.xlpoc;

import java.util.List;

public class Client {
	public static void main(String[] args) {
		System.out.println("Hello World");
		String fileName = "";
		
		System.out.println("===============================XL 2013 Example=================================");
		fileName = "C:/Users/Hussain/Desktop/POC/ContMap.xlsx";
		System.out.println("file name :"+fileName);
		ReadXLSUtil readXLSUtil = new ReadXLSUtil();
		List<Country> countryList =  readXLSUtil.readXLSData(fileName);
		System.out.println("countryList ::"+countryList);
		readXLSUtil.displayCountry(countryList);
		
		System.out.println("===============================XL 97 2003 Example=================================");
		fileName = "C:/Users/Hussain/Desktop/POC/ContMapXL972003.xls";
		System.out.println("file name :"+fileName);
		countryList =  readXLSUtil.readXLSData(fileName);
		System.out.println("countryList ::"+countryList);
		readXLSUtil.displayCountry(countryList);
		
		System.out.println("===============================2013   Sample File=================================");
		fileName = "C:/Users/Hussain/Desktop/POC/XL2013/SAMPLE-XL-2013-data-sheet.xlsx";
		System.out.println("file name :"+fileName);
		countryList =  readXLSUtil.readXLSData(fileName);
		System.out.println("countryList ::"+countryList);
		readXLSUtil.displayCountry(countryList);
		
		System.out.println("===============================97-2003   Sample File=================================");
		fileName = "C:/Users/Hussain/Desktop/POC/XL97-2003/SAMPLE-XL-97-2003-data-sheet.xls";
		System.out.println("file name :"+fileName);
		countryList =  readXLSUtil.readXLSData(fileName);
		System.out.println("countryList ::"+countryList);
		readXLSUtil.displayCountry(countryList);
	}
}
