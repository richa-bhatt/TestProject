package com.TestP.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.TestP.qa.Base.TestBase;

public class LoginPage extends TestBase {

	//Page Factory

	@FindBy(xpath = "//button[text()='Sign in']")
	WebElement signInBtnHomePage;


	@FindBy(xpath = "//md-input-container/input[@name='email']")
	WebElement username;

	@FindBy(xpath = "//md-input-container/input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//form/button[@type='submit']")
	WebElement signInBtn;



	//Getter and setters

	public boolean clickSignInHomePage() {
		if(signInBtnHomePage.isDisplayed()) {
			signInBtnHomePage.click();
			return true;
		}
		return false;
	}

	public String validateloginTitle() {
		return driver.getTitle();
	}

	public boolean login(String user, String pass) {
		if(username.isDisplayed()) {
			username.sendKeys(user);
			if(password.isDisplayed()) {
				password.sendKeys(pass);
				if(signInBtn.isDisplayed()) {
					signInBtn.click();
					return true;
				}
				return false;
			}
			return false;
		}
		return false;
	}

	public boolean clickSignInMethodBtn(String signInMethodStr, WebDriver driver) { 
		
		WebElement signInMethod =driver.findElement(By.xpath("//md-dialog//div[@class='login-options']/descendant::button//"
				+ "span[normalize-space(text())='"+signInMethodStr+"']/parent::button"));
		signInMethod.click();
		return true;
	}

}
