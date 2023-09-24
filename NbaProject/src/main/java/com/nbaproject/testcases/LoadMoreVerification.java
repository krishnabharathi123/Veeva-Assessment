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

public class LoadMoreVerification extends NbaProjectBaseClass{
	
	@BeforeTest
	public void configureData() {
		testCaseName = "VerifyLoadItems";
		testDescription = "Verification of Items loaded";
		nodes = "LoadItems";
		authors = "Bharathi";
		category = "Smoke";
	}
	
	
	@Test
	public void verifyLoadMoreFeature() throws InterruptedException {
		
		System.out.println("*** Started Test case 4 Execution - LoadMore verification ***");
		
		// Getting the count of element before clicking "Load More"
		
		List<WebElement> elements =locateElements("xpath", "//span[text()='Load more']/ancestor::div[@class='xsm:mx-5']//div[contains(@class,'flex-grow')]");
		int intialCount = elements.size();
		System.out.println("Initial Count: "+intialCount);
		reportStep("Before clicking load more", "pass");
		Thread.sleep(2000);
		
		// Getting the count of element after clicking "Load More"
		
		click(locateElement("xpath", "//span[text()='Load more']"));
		List<WebElement> elementsNew =locateElements("xpath", "//span[text()='Load more']/ancestor::div[@class='xsm:mx-5']//div[contains(@class,'flex-grow')]");
		int newCount = elementsNew.size();
		System.out.println("Final Count after clicking on load more: "+newCount);
		
		// Checking whether "Load More" loads 8 items
		if(newCount == intialCount+8) {
			System.out.println("The count increased by 8 as expected");
		}
		
		System.out.println("*** Completed Test case 4 Execution - LoadMore verification ***");
		System.out.println();
	}

}
