package com.seleniumeasy.BusinessLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.seleniumeasy.CommonFuntionalities.CommonFunctions;
import com.seleniumeasy.ObjectRepository.DemoPageElements;
import com.seleniumeasy.ObjectRepository.LandingPageElements;
import com.seleniumeasy.ObjectRepository.SubmitFormPageElements;

public class BusinessFunctionalities extends CommonFunctions
{
	WebDriver driver;
	LandingPageElements landingPageElements;
	DemoPageElements demoPageElements;
	SubmitFormPageElements submitFormPageElements;
	public BusinessFunctionalities(WebDriver driver)
	{
		this.driver=driver;
		landingPageElements = PageFactory.initElements(this.driver, LandingPageElements.class);
		demoPageElements = PageFactory.initElements(this.driver, DemoPageElements.class);
		submitFormPageElements = PageFactory.initElements(this.driver, SubmitFormPageElements.class);
	}
	
	
	
	public void submitForm(String firstName, String lastName, String email, String phone, String state) throws InterruptedException
	{
		// Landing Page
		clickElement(landingPageElements.getDemoWebsiteLink(), "Demo Website Link");
		Thread.sleep(5000);
		// Demo Page
		clickElement(demoPageElements.getInputFormTab(), "Input Form tab");
		clickElement(demoPageElements.getInputFormSubmitLink(), "Input Form Submit Link");
		// Submit Form Page
		Thread.sleep(2000);
		enterText(submitFormPageElements.getFirstNameField(), firstName, "First Name Field");
		enterText(submitFormPageElements.getLastNameField(), lastName, "Last Name Field");
		enterText(submitFormPageElements.getEmailField(), email, "Email Field");
		enterText(submitFormPageElements.getPhoneField(), phone, "Phone Number Field");
		selectOption(submitFormPageElements.getStateDropdown(), state, "State Dropdown");
		scrollPage(driver, submitFormPageElements.getYesRadioButton(), "Yes Radio Button");
		clickElement(submitFormPageElements.getSeleniumEasyImage(), "Selenium Easy Iamge");
	}
}
