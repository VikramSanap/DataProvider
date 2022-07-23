package com.iris;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders1 {
	@DataProvider(name = "Books Data")
	public Object[][] dataProvider() throws IOException {
		ExcelReader excel = new ExcelReader();
		Object[][] obj2 =  excel.loadsheet("F:\\JARs\\BookData.xlsx", "Book");
		return obj2;
	}

}
