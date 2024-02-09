package com.qa.pageObjects.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndroidActions{

	AndroidDriver driver;
	
	public CartPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver) , this);
		
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productPrice;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalPrice;
	
	
	public List<WebElement> getProductPrice()
	{
		
		return productPrice;
		
		
	}
	
	public double getProductAmountSum()
	{
		  waitForElementToAppear(productPrice, driver);
		  int count= productPrice.size();
		  Double totalSum=0.00;
		  
		  for(int i=0; i<count; i++)
		  {
			  
			  String totalAmount=productPrice.get(i).getText();
			  Double price=getFormattedAmount(totalAmount);
			  totalSum=totalSum+price;
	}
		  return totalSum;
		  
}
	
	public double getTotalAmountDisplayed()
	{
		
		return getFormattedAmount(totalPrice.getText());
		
		
	}
}
