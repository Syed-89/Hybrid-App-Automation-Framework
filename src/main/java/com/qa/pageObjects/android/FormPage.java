package com.qa.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndroidActions {

	AndroidDriver driver;
	
	public FormPage(AndroidDriver driver)
	{
	  super(driver);
      this.driver=driver;
      PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
	private WebElement femaleOption; 
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Male']")
	private WebElement maleOption; 
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	private WebElement countriesOption;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement letShopBtn;
	
	
	public void setName(String name) {
		
		nameField.sendKeys(name);
		driver.hideKeyboard();
		
	}
	
	public void setGender(String gender) {
		
		if(gender.contains("Female")) {
			
			femaleOption.click();
			
		}
		
		else {
			
			
			maleOption.click();
			
		}
		
	}
	
	public void setCountry(String countryName) {
		
		countriesOption.click();
		scrollToText(countryName);
	
		
	}
	
	public void clickOnLetShopBtn()
	{
		
		letShopBtn.click();
		
	}
	
	}
