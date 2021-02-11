package com.TestP.qa.Testcases;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TestP.qa.Base.TestBase;
import com.TestP.qa.pages.HomePage;
import com.TestP.qa.pages.LoginPage;
import com.TestP.qa.pages.OpportunityPage;

public class ListOfCompanyAndProfiles extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	OpportunityPage opp;
	
	@BeforeMethod
	public void setUp() {
		initializationMethod();
		//Page Factory of object libraries
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		
	}
	
	@Test
	public void test() {
		try {
	
		// Click Sign IN button in landing Page
		if(!loginPage.clickSignInHomePage()) {
			throw new RuntimeException("Unable to click Sign In button in landing Page");
		}
		Thread.sleep(4000);
		
		//Select method{using Email} to login
		if(!loginPage.clickSignInMethodBtn("Email", driver)) {
			throw new RuntimeException("Unable to select Sign In method");
		}
		Thread.sleep(2000);
		
		//Login using email credentials
		if(!loginPage.login(prop.getProperty("username"), prop.getProperty("password"))) {
			throw new RuntimeException("Unable to Sign In");
		}
		Thread.sleep(2000);
		//Page factory of home page object library
		homePage = PageFactory.initElements(driver, HomePage.class);
		
		//Click on Opportunity in navigation bar
		if(!homePage.clickNavMenuBarBtn("Opportunity", driver)) {
			throw new RuntimeException("Unable to click Opportunity in navigation menu bar");
		}
		
		//using thread.sleep because havn't implemented fluent wait.
		Thread.sleep(4000);
		
		//page factory of Opportunity object library
		opp = PageFactory.initElements(driver, OpportunityPage.class);
		
		/*
		 * Printing the Name of Company and respective Profile in the page
		 */
		ArrayList<WebElement> comList = new ArrayList<WebElement>(opp.companyList);
		ArrayList<WebElement> proList = new ArrayList<WebElement>(opp.profileList);
		
		for(int i=0; i<comList.size(); i++) {
			System.out.println("Comapany Name : " + comList.get(i).getText());
			System.out.println("Profile Name : " + proList.get(i).getText());
			System.out.println(" ");
		}
		
		}catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
}
