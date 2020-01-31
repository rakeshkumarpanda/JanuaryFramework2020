package com.seleniumeasy.BrowserHandling;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BrowserHandling 
{
	public WebDriver driver;
	@Parameters("browser")
	@BeforeTest
	public void browserLaunch(String browser)
	{
		// Browser Launching
		if(browser.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ".\\BrowserDrivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", ".\\BrowserDrivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equals("Headless"))
		{
			System.setProperty("webdriver.chrome.driver", ".\\BrowserDrivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.setHeadless(true);
			driver = new ChromeDriver(options);
		}
		
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com/");
	}
	@AfterTest
	public void browserClose() throws InterruptedException
	{
		// Closing the Browser
		Thread.sleep(5000);
		driver.close();
	}

}
