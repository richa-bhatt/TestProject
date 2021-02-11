package com.TestP.qa.Testcases;

import java.util.ArrayList;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TestP.qa.Base.TestBase;
import com.TestP.qa.pages.HomePage;
import com.TestP.qa.pages.LoginPage;
import com.TestP.qa.pages.OpportunityPage;

public class filters extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	OpportunityPage oppPage;

	@BeforeMethod
	public void setUp() {
		initializationMethod();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
	}


	@Test
	public void test() {
		boolean flag;
		try {
			//Click Sign IN button in landing page
			if(!(flag = loginPage.clickSignInHomePage())) {
				throw new RuntimeException("Unable to click sign In button");
			}
			

			Thread.sleep(4000);
			//Select signIn method as Email , used Dynamic xpath
			if(!loginPage.clickSignInMethodBtn("Email", driver)) {
				
				throw new RuntimeException("Unable to select Sign In method");
			}


			//Login using email Credentials
			if(!loginPage.login(prop.getProperty("username"), prop.getProperty("password"))) {
				throw new RuntimeException("Unable to Sign In");
			}

			//Page factory of home page object libraries
			homePage = PageFactory.initElements(driver, HomePage.class);

			//Click Opportunity in navigation bar , used dynamic xpath
			if(!homePage.clickNavMenuBarBtn("Opportunity", driver)) {
				throw new RuntimeException("Unable to click 'Opportunity' Navigation menu bar");
			}

			Thread.sleep(4000);
			//page factory of Opportunity object library
			oppPage = PageFactory.initElements(driver, OpportunityPage.class);


			/********************************
			 * Checking if Job Type Filter working properly
			 *********************************/
			try {
				if(!oppPage.clickFilterType("Job Type", driver)) {
					throw new RuntimeException("Unable to click filter name");
				}
				Thread.sleep(2000);

				if(!oppPage.selectFilterType("Full-Time", driver)) {
					throw new RuntimeException("Unable to click Select filter type");
				}
				Thread.sleep(2000);

				if(!oppPage.clickApply()) {
					throw new RuntimeException("Unable to click Apply button");
				}
				Thread.sleep(2000);

				for(WebElement str : oppPage.listofTypesOfJob) {
					String strstr = str.getText();
					if(!(strstr=="Full-Time")) {
						throw new RuntimeException("Filter not working properly");
					}else {
						System.out.println("Job filter working properly");
					}
				}
			}catch(Exception e) {
				e.getMessage();
			}
			if(!oppPage.clickFilterType("Job Type", driver)) {
				throw new RuntimeException("Unable to click Filter Name to clear ");
			}
			Thread.sleep(2000);

			if(!oppPage.clickClear()) {
				throw new RuntimeException("Unable to click Clear 01");
			}
			Thread.sleep(2000);


			/*******************************
			 * Checking Remote location filter
			 *********************************/
			try {

				if(!oppPage.clickFilterType("Location", driver)) {
					throw new RuntimeException("Unable to click 'Location' filter type");
				}
				Thread.sleep(4000);
				if(!oppPage.selectCheckboxRemoteLocation()) {
					throw new RuntimeException("Unable to select 'Remote location' filter");
				}
				Thread.sleep(2000);
				oppPage.clickApply();
				for(WebElement str : oppPage.listofRemoteJobs) {
					String strstr = str.getText();
					if(!(strstr.contains("Remote"))) {
						throw new RuntimeException("Filter not working properly");
					}else {
						System.out.println("Location filter working properly");
					}

				}

			}catch(Exception e) {
				e.getMessage();
			}

			if(!oppPage.clickFilterType("Location", driver)) {
				throw new RuntimeException("Unable to click Filter Name to  ");
			}
			Thread.sleep(2000);

			if(!oppPage.clickClear()) {
				throw new RuntimeException("Unable to click Clear 02");
			}
			Thread.sleep(2000);

			/************************************
			 * checking if Search Filter working properly
			 ***********************************/
			try {
				if(!oppPage.clickFilterType("Search", driver)) {
					throw new RuntimeException("Unable to click 'Search' manu bar filter");
				}
				Thread.sleep(2000);
				if(!oppPage.enterValueInSearchFilter("peopleGrove")) {
					throw new RuntimeException("Unable to search 'peopleGrove' in searchfield");
				}
				oppPage.clickApply();
				Thread.sleep(2000);
				ArrayList<WebElement> arrlist =  new ArrayList<WebElement>(oppPage.jobCardContent);
				String str = arrlist.toString();
				if(!str.toLowerCase().contains("peoplegrove")) {
					throw new RuntimeException("Search filter not working properly");
				}
				else {
					System.out.println("Search filter working properly");
				}
			}catch(Exception e) {
				e.getMessage();
			}

			oppPage.getFilterType("Clear All", driver);
			Thread.sleep(1000);

			/*********************************
			 * Checking Industry Expertise filter
			 *************************************/

			try {
				if(!oppPage.clickFilterType("Industry Expertise", driver)) {
					throw new RuntimeException("Unable to click 'Industry Expertise'manu bar filter");
				}
				Thread.sleep(2000);
				if(!oppPage.selectFilterExperties("Internet & Software", driver)) {
					throw new RuntimeException("Unable to click 'Internet & Software' filter type");
				}
				Thread.sleep(2000);
				oppPage.clickApply();

			}catch(Exception e) {
				e.getMessage();
			}
			
			Thread.sleep(2000);


		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}




}
