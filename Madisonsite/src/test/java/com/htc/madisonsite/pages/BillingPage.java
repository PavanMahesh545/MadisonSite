package com.htc.madisonsite.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.htc.madisonsite.utilites.Utility;

import org.openqa.selenium.support.FindBy;


public class BillingPage extends BasePage {
	@FindBy(xpath = "//input[@id='newsletter']")
	private WebElement newsletterBy;
	@FindBy(xpath = "(//button[@class='button'])[5]")
	private WebElement subscribeBy;
	@FindBy(xpath = "//input[@id='billing:company']")
	private WebElement companyBy;
	@FindBy(xpath = "//input[@id='billing:street1']")
	private WebElement streetBy;
	@FindBy(xpath = "//input[@id='billing:city']")
	private WebElement cityBy;
	@FindBy(xpath = "//select[@id='billing:region_id']")
	private WebElement regionBy;
	@FindBy(xpath = "//input[@id='billing:postcode']")
	private WebElement pincodeBy;
	@FindBy(xpath = "//input[@id='billing:telephone']")
	private WebElement mobilenumberBy;
	@FindBy(xpath = "(//button[@class='button'])[1]")
	private WebElement billingcontinueBy;
	@FindBy(xpath = "//input[@id='s_method_freeshipping_freeshipping']")
	private WebElement shippingmethodBy;
	@FindBy(xpath = "(//button[@class='button'])[2]")
	private WebElement shippingcontinueBy;
	@FindBy(xpath = "//button[@onclick='payment.save()']")
	private WebElement paymentcontinueBy;
	@FindBy(xpath = "//button[@class='button btn-checkout']")
	private WebElement chechoutBy;

	
	
	public BillingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	 

	public void setCheckoutdata(String email, String company, String street, String city, String region, String pincode,
			String mobilenumber) {
		try {
			newsletterBy.sendKeys(email);
			subscribeBy.click();
			companyBy.sendKeys(company);
			streetBy.sendKeys(street);
			cityBy.sendKeys(city);
			Utility.dropdown(regionBy, region);
			pincodeBy.sendKeys(pincode);
			mobilenumberBy.sendKeys(mobilenumber);
			billingcontinueBy.click();
			shippingmethodBy.click();
			shippingcontinueBy.click();
			paymentcontinueBy.click();
			chechoutBy.click();
		} catch (NoSuchElementException | StaleElementReferenceException exception) {
			System.out.println(exception.getStackTrace());
		}

	}

}
