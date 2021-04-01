package com.htc.madisonsite.tests;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.htc.madisonsite.BaseTest;

public class LoginTest extends BaseTest {
	@Test(dataProviderClass = com.htc.madisonsite.utilites.TestDataProvider.class, dataProvider = "Madison")
	@Parameters("SheetName")
	public void Valid_And_Invalid_Login(Map<String, String> mapData) throws IOException, InterruptedException {
		login.Login_To_Page(mapData.get("emailid"), mapData.get("password"));
//		System.out.println(mapData.get("assert")); 
//		System.out.println(homepage.getWelcomeMessage()); 
		
		Assert.assertEquals(homepage.getWelcomeMessage(), mapData.get("assert"));
}
	}