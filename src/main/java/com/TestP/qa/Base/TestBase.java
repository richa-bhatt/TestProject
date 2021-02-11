package com.TestP.qa.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.TestP.qa.Utils.TestUtil;

public class TestBase {

	public static	WebDriver driver;
	public static Properties prop;

	//to read config properties
	public TestBase(){

		try {
			prop = new Properties();
			String configFilePath = new File(".").getCanonicalPath()+"\\src\\main\\java\\com\\TestP\\qa\\config\\config.properties";
			FileInputStream ip = new FileInputStream(configFilePath);
			prop.load(ip);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	// To initialize browser
	public static void initializationMethod() {
		String browserName = prop.getProperty("browser");

		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/Users/richab1/Downloads/chromedriver_win32//chromedriver.exe");
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}

}


















