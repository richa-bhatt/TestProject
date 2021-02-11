package com.TestP.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


import com.TestP.qa.Base.TestBase;

public class OpportunityPage extends TestBase{

	@FindBy(xpath ="//div[@class='job-card__content']//div[contains(@class,'content__details')]/span[contains(@class,'job-card__subtitle')][1]")
	public List<WebElement> companyList;
	
	@FindBy(xpath ="//div[@class='job-card__content']//div[contains(@class,'content__details')]/span[contains(@class,'job-card__title')]/div[1]")
	public List<WebElement> profileList;
	
	@FindBy(xpath ="//ul/li[4]")
	public List<WebElement> listofTypesOfJob;
	
	//ul/li[1]
	@FindBy(xpath ="//ul/li[1]")
	public List<WebElement> listofRemoteJobs;
	
	@FindBy(xpath="//button/span[text()='Location']")
	private WebElement filterType;
	
	
	@FindBy(xpath="//div[contains(@class,'menu__search')]//input[contains(@placeholder,'Search')]")
	private WebElement searchFilterInputField;
	
	@FindBy(xpath="//div[@class='ant-dropdown ant-dropdown-placement-bottomLeft']//button/span[text()='Apply' ]//parent::button")
	private WebElement applyBtn;
	
	@FindBy(xpath="//button[contains(@class,'clear')]")
	private WebElement clearBtn;
	
	@FindBy(xpath="//label[contains(@class,'location-remote')]/span[text()='Virtual / Remote']")
	private WebElement virtualRemoteCheckbox;
	
	
	@FindBy(xpath="//div[@class='job-card__content']")
	public List<WebElement> jobCardContent;
	
	public WebElement getFilterType(String filterName, WebDriver driver) {
		try {
			String props="//button/span[text()='__Filter_NAME__']//parent::button";
		props=props.replaceAll("__Filter_NAME__", filterName);
	WebElement ele = driver.findElement(By.xpath(props));
	return ele;
		}catch(Exception e) {
			return null;
		}
		
	}
	
	public boolean clickFilterType(String jobFilter, WebDriver driver) {
		if(getFilterType(jobFilter, driver).isDisplayed()) {
			getFilterType(jobFilter, driver).click();
			return true;
		}
		return false;
	}
	
	public boolean clickApply() {
		if(applyBtn.isDisplayed()) {
		applyBtn.click();
		return true;
		}
		return false;
	}
	
	public boolean clickClear() {
		if(clearBtn.isDisplayed()) {
		clearBtn.click();
		return true;
		}else {
			throw new RuntimeException("Clear button not found");
		}
	}
	
	public boolean selectCheckboxRemoteLocation() {
		if(virtualRemoteCheckbox.isDisplayed()) {
			virtualRemoteCheckbox.click();
			return true;
		}return false;
	}
	
	public boolean enterValueInSearchFilter(String value) {
		if(searchFilterInputField.isDisplayed()) {
		searchFilterInputField.sendKeys(value);
		return true;
		}
		return false;
	}
	
	
	
	public WebElement selectFilter(String filterType, WebDriver driver) {
		try {
			String props="//label[contains(@class,'menu-checkbox')]/span[text()='__Filter_Type__']";
		props=props.replaceAll("__Filter_Type__", filterType);
	WebElement ele = driver.findElement(By.xpath(props));
	return ele;
		}catch(Exception e) {
			return null;
		}
		
	}
	
	public WebElement selectExpertiesFilter(String expertisefilterType, WebDriver driver) {
		try {
			String props="//label[contains(@class,'menu-checkbox')]//span[text()='__Experties_Filter_Type__']";
		props=props.replaceAll("__Experties_Filter_Type__", expertisefilterType);
	WebElement ele = driver.findElement(By.xpath(props));
	return ele;
		}catch(Exception e) {
			return null;
		}
		
	}
		public boolean selectFilterType(String filterType, WebDriver driver) {
			if(selectFilter(filterType, driver).isDisplayed()) {
				selectFilter(filterType, driver).click();
				return true;
			}return false;
	}
		
		public boolean selectFilterExperties(String filterExpertiseType, WebDriver driver) {
			if(selectExpertiesFilter(filterExpertiseType, driver).isDisplayed()) {
			selectExpertiesFilter(filterExpertiseType, driver).click();
			return true;
			}return false;
	}
	
		
		public void clickExpertiesType(String filterName) {
			
			Actions action = new Actions(driver);
			action.click(selectFilter(filterName, driver));
		}
	
}
