package com.qa.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;

public class CartTests extends BaseTest {

	
	
	 @Test(dataProvider="getData") 
	  public void verifyTheCartPage(HashMap<String, String> input) throws InterruptedException {
	  
	  formPage.setName(input.get("name"));
	  formPage.setGender(input.get("gender"));
	  formPage.setCountry(input.get("Country"));
	  formPage.clickOnLetShopBtn();
      productCatalogue.addToCartByIndex(0);
	  productCatalogue.addToCartByIndex(0);
	  productCatalogue.goToCartPage();
	  double productAmountSum=cartpage.getProductAmountSum();
	  double totalAmount=cartpage.getTotalAmountDisplayed();
	  Assert.assertEquals(totalAmount, productAmountSum);
	  }

}
