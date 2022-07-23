package com.dataproviderdemo;

import org.testng.annotations.Test;

public class TestCase {
	@Test(dataProvider="FirstDP", dataProviderClass = DataProviderClass.class)
	public void m1(String initials, String fullNames) {
	System.out.println("Initials :"+initials+"\t"+"Full Name :"+fullNames);
	System.out.println();
	System.out.println();
	}

}