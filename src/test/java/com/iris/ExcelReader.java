package com.iris;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelReader {

	public static Object[][] loadsheet(String fileName, String sheetName) throws IOException {

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

		int rows = sheet.getLastRowNum();

		obj = new Object[rows][sheet.getRow(0).getLastCellNum() - 1];

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

	public static void main(String[] args) {

	}

}

//			case NUMERIC: {
//				int num = (int) cell.getNumericCellValue();
//				System.out.println(num);
//				break;
//			}
//			case STRING: {
//				String Value = cell.getStringCellValue();
//				System.out.println(Value);
//				break;
//			}
//			default: {
//				break;
//			}
//			}
//		}
//		return obj;
//	}
//
//	public static void main(String[] args) throws IOException {
//		
