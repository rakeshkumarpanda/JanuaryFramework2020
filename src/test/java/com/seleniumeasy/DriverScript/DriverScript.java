package com.seleniumeasy.DriverScript;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.seleniumeasy.BrowserHandling.BrowserHandling;
import com.seleniumeasy.BusinessLibrary.BusinessFunctionalities;

public class DriverScript extends BrowserHandling
{
	BusinessFunctionalities businessFunctionality;
	@BeforeClass
	public void initObjects()
	{
		businessFunctionality = new BusinessFunctionalities(driver);
	}
	@Test(dataProvider = "SubmitFormData", dataProviderClass = com.seleniumeasy.DataCollection.DataCollectionClass.class)
	public void sampleFormTest(String firstName, String lastName, String email, String phone, String state) throws InterruptedException
	{
		businessFunctionality.submitForm(firstName, lastName, email, phone, state);
		System.out.println("Git Pull");
	}
	
}
