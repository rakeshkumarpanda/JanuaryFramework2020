package com.seleniumeasy.DataCollection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class DataCollectionClass 
{
	String excelPath = "./TestDataSheet/TestData.xlsx";
	Fillo fillo;
	Connection connection;
	
	public DataCollectionClass() throws FilloException
	{
		fillo = new Fillo();
		connection = fillo.getConnection(excelPath);
	}
	
	@DataProvider(name="SubmitFormData")
	public Iterator<String[]> submitFormData() throws FilloException
	{
		String query = "select firstname, lastname, email, phone, state from sheet1 where flag='Y' and scenario='SubmitForm'";
		List<String[]> dataList = new ArrayList<String[]>();
		try {
			Recordset rs = connection.executeQuery(query);
			while(rs.next())
			{
				String[] str = new String[5];
				str[0]=rs.getField("firstname");
				str[1]=rs.getField("lastname");
				str[2]=rs.getField("email");
				str[3]=rs.getField("phone");
				str[4]=rs.getField("state");
				dataList.add(str);
			}
			
		}
		catch(NullPointerException e)
		{
			Reporter.log("Recordset has null value");
		}
		catch(Exception e)
		{
			Reporter.log("Recordset has null value");
		}
		return dataList.iterator();
		
	}

}
