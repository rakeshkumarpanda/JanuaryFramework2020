package com.seleniumeasy.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPageElements 
{
	@FindBy(xpath = "//a[contains(text(),'Demo Website!')]")
	private WebElement demoWebsiteLink;
	
	public WebElement getDemoWebsiteLink()
	{
		return demoWebsiteLink;
	}

}
