package com.htc.madisonsite.tests;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.htc.madisonsite.BaseTest;

public class ProductPurchaseTest extends BaseTest {
	@Test(dataProviderClass = com.htc.madisonsite.utilites.TestDataProvider.class, dataProvider = "Madison")
	@Parameters("SheetName")
	public void Valid_And_Invalid_Login(Map<String, String> mapData) throws IOException, InterruptedException {
		login.Login_To_Page(mapData.get("emailid"), mapData.get("password"));

	     homepage.Home_Page(data.getProperty("searchproduct"));

		productlist.selectproductBy();

		cartpage.selectproduct(data.getProperty("quantity"));

		shopping.setAddress(data.getProperty("country"), data.getProperty("region"), data.getProperty("city"),
				data.getProperty("pincode"));

		billing.setCheckoutdata(mapData.get("emailid"), data.getProperty("company"), data.getProperty("street"),
				data.getProperty("city"), data.getProperty("quantity"), data.getProperty("pincode"),
				data.getProperty("mobilenumber"));

		Assert.assertEquals(confirm.getConfirmMessage(), mapData.get("welcome"));
		System.out.println("Order has Placed Succesfully");
	}
}
