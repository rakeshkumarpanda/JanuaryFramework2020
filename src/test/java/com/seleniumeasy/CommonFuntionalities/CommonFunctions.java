package com.seleniumeasy.CommonFuntionalities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class CommonFunctions 
{
	public void clickElement(WebElement element, String elementName)
	{
		try {
			if(element.isDisplayed())
			{
				if(element.isEnabled())
				{
					element.click();
					Reporter.log(elementName+" is clicked");
				}
			}
		}
		catch(NoSuchElementException e)
		{
			Reporter.log(elementName+" is not displaying on UI");
		}
		catch(Exception e)
		{
			Reporter.log(elementName+" is not enable for click event");
		}	
	}
	public void enterText(WebElement element,String text, String elementName)
	{
		try {
			if(element.isDisplayed())
			{
				if(element.isEnabled())
				{
					element.sendKeys(text);
					Reporter.log(elementName+" is entered with "+text);
				}
			}
		}
		catch(NoSuchElementException e)
		{
			Reporter.log(elementName+" is not displaying on UI");
		}
		catch(Exception e)
		{
			Reporter.log(elementName+" is not enable for click event");
		}	
	}
	public void selectOption(WebElement element,String option, String elementName)
	{
		try {
			if(element.isDisplayed())
			{
				if(element.isEnabled())
				{
					Select select = new Select(element);
					select.selectByVisibleText(option);
					Reporter.log(elementName+" is selected with "+option);
				}
			}
		}
		catch(NoSuchElementException e)
		{
			Reporter.log(elementName+" is not displaying on UI");
		}
		catch(Exception e)
		{
			Reporter.log(elementName+" is not enable for click event");
		}	
	}
	public void scrollPage(WebDriver driver, WebElement element,String elementName)
	{
		try {
			if(element.isDisplayed())
			{
				if(element.isEnabled())
				{
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView()", element);
					Reporter.log("Page has been scrolled down until "+elementName+" visible on UI");
				}
			}
		}
		catch(NoSuchElementException e)
		{
			Reporter.log(elementName+" is not displaying on UI");
		}
		catch(Exception e)
		{
			Reporter.log(elementName+" is not enable for click event");
		}	
	}
	public void takeScreenshot(WebDriver driver) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("./Screenshot/screenshot"+getTimestamp()+".png"));
	}
	public String getTimestamp()
	{
		String timeStamp = new SimpleDateFormat("ddMMYYYYhhmmss").format(new Date());
		return timeStamp;
	}
	

}
