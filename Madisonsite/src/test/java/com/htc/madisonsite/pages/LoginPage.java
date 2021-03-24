package com.htc.madisonsite.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.htc.madisonsite.utilites.Utility;

public class LoginPage extends BasePage {

	@FindBy(xpath = "(//span[@class='label'])[3]")
	private WebElement accountBy;
	@FindBy(xpath = "//div[@class='links']//ul//li[@class=' last']//a")
	private WebElement loginBy;
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailidBy;
	@FindBy(xpath = "//input[@id='pass']")
	private WebElement passwordBy;
	@FindBy(xpath = "//button[@id='send2']")
	private WebElement loginbuttonBy;
	@FindBy(xpath = "//a[@title='Log Out']")
	private WebElement logoutbuttonBy;
	@FindBy(xpath = "//div[@class='welcome-msg']//p[@class='hello']//strong")
	private WebElement assertcheckBy;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void Login_To_Page(String email, String password) {
		try {
			Utility.waitToBeVisibile(accountBy, driver);
			accountBy.click();
			loginBy.click();
			emailidBy.sendKeys(email);
			passwordBy.sendKeys(password);
			loginbuttonBy.click();
		} catch (NoSuchElementException | StaleElementReferenceException exception) {
			System.out.println(exception.getStackTrace());
		}

	}

	public WebDriver returndriver() {
		return driver;
	}

	public String Assert_Login() {
		return assertcheckBy.getText();
	}
}
