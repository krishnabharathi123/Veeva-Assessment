package com.nbaproject.testcases;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.nbaproject.base.NbaProjectBaseClass;

public class SlideViewVerification extends NbaProjectBaseClass{
	
	@BeforeTest
	public void configureData() {
		testCaseName = "VerifySlideView";
		testDescription = "Verification of Slide View";
		nodes = "SlideView";
		authors = "Bharathi";
		category = "Smoke";
	}
	
	@Test
	public void verifySlideViewFunctionality() throws InterruptedException {
		
		System.out.println("*** Started Test case 2 Execution - Slide View verification ***");
		
		//Waiting for the slider becomes clickable and clicking
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'swiper-pagination')]/span[1]")));
			ele.click();
		} catch (Exception e) {

		}
		Thread.sleep(1000);
		
		// Get all the slide view options
		List<WebElement> slides = driver.findElements(By.xpath("//div[contains(@class,'swiper-slide')]"));
		slides = driver.findElements(By.xpath("//div[contains(@class,'swiper-slide')]//h3"));
		
		//Iterate through the size of the slider and get the text of each slide
		for(int i=0; i<slides.size();i++) {
			int j=i+1;
			WebElement swiper = driver.findElement(By.xpath("//div[contains(@class,'swiper-pagination')]/span["+j+"]"));
			click(swiper,"Slider"+j);
			System.out.println("Slider Text "+j+" "+slides.get(i).getText());
			Thread.sleep(5000);
			
		}
		
		System.out.println("*** Completed Test case 2  Execution - Slide View verification ***");
		System.out.println();
	}

}
