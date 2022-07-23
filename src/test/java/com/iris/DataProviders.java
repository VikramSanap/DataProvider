package com.iris;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "Books Data")
	public Object[][] dataProvider() {
		Object[][] obj = { { "Old man and the sea", "Earnest Hamingway" }, { "Sun also rises", "Earnest Hamingway" },
				{ "Kosala      ", "Bhalchandra Nemade" }, { "Ravan      ", "Sharad Tandale" },
				{ "Half Girlfriend", "Chetan Bhagat" }

		};
		return obj;
	}

	@DataProvider(name = "Order Data")
	public Object[][] orderdata() {

		Object[][] obj = null;
		{

			return obj;

		}
	}
}
