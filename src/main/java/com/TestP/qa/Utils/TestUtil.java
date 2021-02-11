package com.TestP.qa.Utils;

import org.openqa.selenium.WebDriver;

import com.TestP.qa.Base.TestBase;

public class TestUtil extends TestBase{

	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 30;
	
	public void switchToFrame(String frame) {
		driver.switchTo().frame(frame);
	}
	
	public void switchToWindowHandles(WebDriver driver, String strWindowTitle) {
		try {
			driver.switchTo().window(strWindowTitle);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
