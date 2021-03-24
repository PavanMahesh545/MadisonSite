package com.htc.madisonsite.pages;


import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.htc.madisonsite.utilites.Utility;


public class RegistrationPage extends BasePage {
	
	@FindBy(xpath = "(//span[@class='label'])[3]")
	private WebElement accountBy;
	@FindBy(xpath = "//div[@id='header-account']//div//ul//li//a[@title='Register']")
	private WebElement registerBy;
	@FindBy(xpath = "//input[@id='firstname']")
	private WebElement firstnameBy;
	@FindBy(xpath = "//input[@id='middlename']")
	private WebElement middlenameBy;
	@FindBy(xpath = "//input[@id='lastname']")
	private WebElement lastnameBy;
	@FindBy(xpath = "//input[@id='email_address']")
	private WebElement emailidBy;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordBy;
	@FindBy(xpath = "//input[@id='confirmation']")
	private WebElement confirmpasswordBy;
	@FindBy(xpath = "//button[@class='button']")
	private WebElement registerbuttonBy;
	@FindBy(xpath = "//span[contains(text(),'Thank you for registering with Madison Island.')]")
	private WebElement assertcheckBy;

	public RegistrationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void Registration_To_Page(String firstname, String middlename, String lastname, String emailid,
			String password, String confirmpassword) {
		try {
			Utility.waitToBeVisibile(accountBy, driver);
			accountBy.click();
			registerBy.click();
			firstnameBy.sendKeys(firstname);
			middlenameBy.sendKeys(middlename);
			lastnameBy.sendKeys(lastname);
			emailidBy.sendKeys(emailid);
			passwordBy.sendKeys(password);
			confirmpasswordBy.sendKeys(confirmpassword);
			registerbuttonBy.click();
		} catch (NoSuchElementException |StaleElementReferenceException exception) {
			System.out.println(exception.getStackTrace());
		}

	}

	public String assertcheckBy() {
		return assertcheckBy.getText();
	}

}
