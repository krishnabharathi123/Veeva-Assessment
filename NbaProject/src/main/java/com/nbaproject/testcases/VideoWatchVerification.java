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

public class VideoWatchVerification extends NbaProjectBaseClass{
	
	@BeforeTest
	public void configureData() {
		testCaseName = "VerifyVideoWatch";
		testDescription = "Verification of Video streaming";
		nodes = "Video";
		authors = "Bharathi";
		category = "Smoke";
	}
	
	@Test
	public void verifyVideoStreaming() throws InterruptedException {
		
		System.out.println("*** Started Test case 3 Execution - Video Watch verification ***");
		
		// Click on Watch Video
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Watch Video']")));
			ele.click();
		} catch (Exception e) {

		}
		Thread.sleep(1000);
		
		click(locateElement("xpath", "//span[text()='Watch Video']"));
		
		// Confirm the video is getting played after few seconds
		Thread.sleep(10000);
		List<WebElement> video = locateElements("xpath", "//video");
		int size = video.size();
		if(size == 1) {
			reportStep("The video is being played", "pass");
			System.out.println("The video is played");
		}
		
		System.out.println("*** Completed Test case 3 Execution - Video Watch verification ***");
		System.out.println();
	}

}
