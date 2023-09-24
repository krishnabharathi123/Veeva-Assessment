package com.nbaproject.base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.testframe.selenium.api.base.SeleniumWrapperClass;

public class NbaProjectBaseClass extends SeleniumWrapperClass{

	@BeforeMethod
	public void beforeMethod() {
		
		driver = startApp("chrome", "https://www.nba.com/warriors/");
		
		// if the x appears, close it
		try {
			driver.findElement(By.xpath("//div[text()='x']")).click();
		}catch(WebDriverException e) {
			System.out.println();
		}
		
		//accept cookies
		try {
			click(locateElement("xpath", "//button[text()='I Accept']"));
		}
		catch(Exception e) {
			
		}
		node = test.createNode(testCaseName);
	}

	@AfterMethod
	public void afterMethod() {
		quit();
	}
	
}
