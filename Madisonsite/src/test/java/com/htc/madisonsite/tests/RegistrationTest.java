package com.htc.madisonsite.tests;

import org.testng.annotations.Test;

import com.htc.madisonsite.BaseTest;
import com.htc.madisonsite.pages.RegistrationPage;

import org.testng.Assert;
import java.io.IOException;
import java.util.Map;


public class RegistrationTest extends BaseTest {
	

	@Test(dataProviderClass = com.htc.madisonsite.utilites.TestDataProvider.class, dataProvider = "Madison")
	public void Valid_And_Invalid_Registration(Map<String, String> mapData) throws IOException, InterruptedException {

		RegistrationPage registration = new RegistrationPage(this.driver);

		registration.Registration_To_Page(mapData.get("firstname"), mapData.get("middlename"), mapData.get("lastname"),
				mapData.get("emailid"), mapData.get("password"), mapData.get("confirmpassword"));
		registration.assertcheckBy();
		Assert.assertEquals(registration.assertcheckBy(), "Thank you for registering with Madison Island.");
		

	}
}
