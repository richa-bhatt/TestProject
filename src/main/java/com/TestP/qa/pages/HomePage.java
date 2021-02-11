package com.TestP.qa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.TestP.qa.Base.TestBase;

public class HomePage extends TestBase{

	
	
	
	
	
	public boolean clickNavMenuBarBtn(String navMenuBtn, WebDriver driver) {
		WebElement navMenuBarButton = driver.findElement(By.xpath("//md-tab-item/a[normalize-space(text())='"+navMenuBtn+"']"));
		if(navMenuBarButton.isDisplayed()) {
			navMenuBarButton.click();
			return true;
		}
		return false;
	}
	
	
	
}
