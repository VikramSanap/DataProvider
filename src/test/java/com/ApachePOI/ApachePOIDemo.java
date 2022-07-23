package com.ApachePOI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ApachePOIDemo {
	@DataProvider(name = "FirstDP1")
	@Test
	public void dataProvider() throws IOException {
		Object[][] obj = null;
		// Logic to read data from Excel
		FileInputStream fis = new FileInputStream("D:\\Users\\Lenovo\\Documents\\Initials.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(fis);
		XSSFSheet sheet = book.getSheetAt(0);
		XSSFRow row = sheet.getRow(1);
		Cell cell = row.getCell(1);
		System.out.println(row.getCell(1).getStringCellValue() + "\t" + row.getCell(2).getStringCellValue());
		// return obj;
	}
}
