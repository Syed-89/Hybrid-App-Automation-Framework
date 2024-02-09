package com.qa.testcases;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.qa.base.BaseTest;

public class FormPageTests extends BaseTest {
	
	

	@Test(dataProvider="getData")
	public void fillForm(HashMap<String, String> input) throws InterruptedException {

		formPage.setName(input.get("name"));
		formPage.setGender(input.get("gender"));
		formPage.setCountry(input.get("Country"));
		formPage.clickOnLetShopBtn();

	}
	
	
	
}