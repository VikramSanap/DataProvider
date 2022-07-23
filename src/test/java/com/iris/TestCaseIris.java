package com.iris;

import org.testng.annotations.Test;

import com.dataproviderdemo.DataProviderClass;

public class TestCaseIris {
	@Test(dataProvider="Books Data", dataProviderClass = DataProviders1.class)
	public void m1(String bookTitle, String author) {
	System.out.println("Book Title :"+bookTitle+"\t"+"Author Name :"+author);
	System.out.println();
	System.out.println();
	}
}