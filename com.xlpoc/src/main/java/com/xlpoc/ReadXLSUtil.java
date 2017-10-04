package com.xlpoc;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXLSUtil {
	public List<Country> readXLSData(String fileName){
		List<Country> countryList = new ArrayList<Country>();
		
		try{
			FileInputStream fis = new FileInputStream(fileName);
			Workbook workbook = null;
			if(fileName.toLowerCase().endsWith("xlsx")){
				workbook = new XSSFWorkbook(fis);
			}
			else if(fileName.toLowerCase().endsWith("xls")) {
				workbook = new HSSFWorkbook(fis);
			}
			int numberOfSheets = 	workbook.getNumberOfSheets();
			
			for(int i=0; i< numberOfSheets; i++){
				Sheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rowIterator = sheet.iterator();
				while(rowIterator.hasNext()){
					String name = "";
					String code = "";
					Row row = rowIterator.next();
					Iterator<Cell> cellIerator = row.cellIterator();
					while(cellIerator.hasNext()){
						Cell cell = cellIerator.next();
						if(code.equalsIgnoreCase("")){
							code = cell.getStringCellValue().trim();
						}
						else if(name.equalsIgnoreCase("")){
							name = cell.getStringCellValue().trim();
						}
						else{
							System.out.println("No data");
						}
						break;
						
					}
					Country country = new Country(code, name);
					countryList.add(country);
				}
			}
			fis.close();
		}
		catch (Exception e) {
			System.out.println("Error :"+e.getMessage());
		}
		return countryList;
	}
	
	public void displayCountry(List<Country> countryList){
		Country country;
		for(int i=0; i<countryList.size(); i++){
			country = countryList.get(i);
			System.out.println(country);
		}
	}
}
