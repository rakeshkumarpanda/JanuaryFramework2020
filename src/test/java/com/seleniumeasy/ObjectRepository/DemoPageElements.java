package com.seleniumeasy.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoPageElements 
{
	@FindBy(xpath = "//a[contains(text(),'Input Forms') and @class='dropdown-toggle']")
	private WebElement inputFormTab;
	@FindBy(xpath = "//ul[@class='dropdown-menu']//a[contains(text(),'Input Form Submit')]")
	private WebElement inputFormSubmitLink;
	public WebElement getInputFormTab() {
		return inputFormTab;
	}
	public WebElement getInputFormSubmitLink() {
		return inputFormSubmitLink;
	}
	

}
