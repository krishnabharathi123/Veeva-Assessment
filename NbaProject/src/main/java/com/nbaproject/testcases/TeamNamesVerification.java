package com.nbaproject.testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.nbaproject.base.NbaProjectBaseClass;

public class TeamNamesVerification extends NbaProjectBaseClass{
	
	@BeforeTest
	public void configureData() {
		testCaseName = "VerifyTeamsName";
		testDescription = "Verification of Team names";
		nodes = "Teams";
		authors = "Bharathi";
		category = "Smoke";
	}
	
	@Test
	public void verifyTeamNames() throws InterruptedException {
		
		System.out.println("*** Started Test case 1 Execution - Team name verification ***");
		
		// Locating the Teams Menu
		WebElement eleTeams = locateElement("xpath", "//span[text()='Teams']");
		
		
		// Randomize the menu
		String[] teamNames = {"bulls", "cavaliers", "pistons", "celtics", "nets", "knicks", "sixers","raptors"};
		int random = new Random().nextInt(teamNames.length-1);
		System.out.println("Decided to click: "+teamNames[random]);		
		
		// Mouse over on the Teams Menu and click sub menu
		Actions builder = new Actions(driver);
		builder.moveToElement(eleTeams).click(driver.findElement(By.xpath("//li[@data-teamslug='"+teamNames[random]+"']"))).perform();
		
		
		// Get the window handles
		List<String> eachHandles = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(eachHandles.get(1));
		System.out.println(driver.getTitle());
		
		
		verifyTitleIgnoreCase(teamNames[random]);
		
		System.out.println("*** Completed Test case 1 Execution - Team name verification ***");
		System.out.println();
		
		
	}

}
