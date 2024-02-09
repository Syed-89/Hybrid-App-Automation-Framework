package com.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import com.qa.pageObjects.android.CartPage;
import com.qa.pageObjects.android.FormPage;
import com.qa.pageObjects.android.ProductCatalogue;
import com.qa.utils.AppiumUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseTest extends AppiumUtils {
	
	protected AppiumDriverLocalService service;
	public AndroidDriver driver;
	protected FormPage formPage;
	protected ProductCatalogue productCatalogue;
	protected CartPage cartpage;
	protected Properties prop;
	protected FileInputStream fls;
	
	@BeforeClass
	public void configureAppium() throws InterruptedException, IOException {
	
	prop=new Properties();
	fls= new FileInputStream("C:\\Users\\Syed Danish\\eclipse-workspace\\HybridAppAutomationFramework\\src\\main\\java\\com\\qa\\configurations\\config.properties");
	prop.load(fls);
	String ipAddress=prop.getProperty("IPAddress");
	String port=prop.getProperty("Port");
    service=startAppiumService(ipAddress, Integer.parseInt(port));
    
	UiAutomator2Options options= new UiAutomator2Options();
	options.setDeviceName("Android Device");
	options.setApp(prop.getProperty("App"));
	options.setChromedriverExecutable(prop.getProperty("ChromeDriver"));
	driver = new AndroidDriver(service.getUrl(), options);
	formPage= new FormPage(driver);
	productCatalogue= new ProductCatalogue(driver);
	cartpage=new CartPage(driver);
	
	
	}
	
	
	@DataProvider
	public Object[][] getData() throws Throwable {
		
		List<HashMap<String, String>> data=getJsonData(prop.getProperty("AppData"));
		return new Object[][]{{data.get(0)}};
		
	}
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
		service.stop();
		
		
	}

}
