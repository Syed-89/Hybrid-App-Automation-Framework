package com.qa.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;

public class ProductCatalogueTests extends BaseTest{

	@Test(dataProvider="getData")
	public void verifyProductCatalogue(HashMap<String, String> input) throws InterruptedException
	{
		formPage.setName(input.get("name"));
		formPage.setGender(input.get("gender"));
		formPage.setCountry(input.get("Country"));
		formPage.clickOnLetShopBtn();
		productCatalogue.addToCartByIndex(0);
		productCatalogue.addToCartByIndex(0);
		String expectedTitle=productCatalogue.getTitle();
		Assert.assertEquals(expectedTitle, "Products");
		productCatalogue.goToCartPage();
		
	}
	
	

}
