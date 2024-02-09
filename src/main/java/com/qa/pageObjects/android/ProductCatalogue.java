package com.qa.pageObjects.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductCatalogue extends AndroidActions{

	AndroidDriver driver;
	
   	  
	public ProductCatalogue(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements((new AppiumFieldDecorator(driver)), this);
		// TODO Auto-generated constructor stub
	}
	  
	  @AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
	  private List<WebElement> addToCart;
	  
	  @AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	  private WebElement cartBtn;
	  
	  @AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/toolbar_title']")
	  private WebElement title;

	  
	  
	  public void addToCartByIndex(int index) {
		  
		  waitForElementToAppear(addToCart,driver);
		  addToCart.get(index).click();
		  
	  }
	  
	  public void goToCartPage() throws InterruptedException
	  {
		  cartBtn.click();
		  
	  }
	  
	  public String getTitle()
	  {
		  waitForElementToAppear(title,driver);
		  String productCatalogeTitle=title.getText();
		  return productCatalogeTitle;
		  
		  
	  }
	  
}
