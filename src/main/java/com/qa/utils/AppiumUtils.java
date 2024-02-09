package com.qa.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumUtils {


	protected AppiumDriverLocalService service;
	
	public List<HashMap<String, String>> getJsonData(String jsonPath) throws Throwable
	{
		
		File file= new File(jsonPath);
		String jsonContent=FileUtils.readFileToString(file,StandardCharsets.UTF_8);
		ObjectMapper mapper= new ObjectMapper();
		List<HashMap<String, String>>data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){
		});
		return data;
	}
	
	public AppiumDriverLocalService startAppiumService(String ipAddress, int port)
	{
		
		service= new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Syed Danish\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
		.withIPAddress(ipAddress).usingPort(port).withTimeout(Duration.ofSeconds(500)).build();
		service.start();
		return service;
		
	}
	
	public String getScreenShot(String testCaseName, AppiumDriver driver) throws IOException {
		
		File source=driver.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
		
	}
	
	public void waitForElementToAppear(WebElement ele, AppiumDriver driver) {
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ele));
		
	}
	
	
	public void waitForElementToAppear(List<WebElement> ele, AppiumDriver driver) {
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(ele));
}

}
