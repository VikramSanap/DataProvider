package com.dataproviderdemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderClass {

//	@DataProvider(name = "FirstDP")
//	public Object[][] dataProvider() throws IOException {
//		Object[][] obj = null;
//		// Logic to read data from Excel
//		FileInputStream fis = new FileInputStream("D:\\Users\\Lenovo\\Documents\\Initials.xlsx");
//		XSSFWorkbook book = new XSSFWorkbook(fis);
//		XSSFSheet sheet = book.getSheetAt(0);

	@DataProvider(name = "FirstDP")
	public Object[][] dataProvider() throws IOException {
		String fileName = "D:\\Users\\Lenovo\\Documents\\Initials.xlsx";
		String sheetName = "Initials";
		Object[][] obj = null;
		Workbook book = null;
		// Logic to read data from Excel
		FileInputStream fis = new FileInputStream(fileName);

		if (fileName.endsWith("xls")) {
			book = new HSSFWorkbook(fis);
		} else {
			book = new XSSFWorkbook(fis);
		}
		Sheet sheet = book.getSheet(sheetName);

		int rows = sheet.getLastRowNum();//Rows are zero based so in the xlsx sheet of 
										 //having 10 rows LastRowNum = 9
											
		obj = new Object[rows][sheet.getRow(0).getLastCellNum() - 1];//cells are zero based so in the xlsx 
		//sheet of having 10 columns/cells LastCellNum = 9 but getLastCellNum() will return 9+1 ie. 10

		for (int i = 1; i <= rows; i++) {
			Row row = sheet.getRow(i);
			int cells = row.getLastCellNum(); 
			for (int j = 1; j < cells; j++) {
				Cell cell = row.getCell(j);
				obj[i - 1][j - 1] = cell.getStringCellValue();
			}
		}
		return obj;
	}

}
