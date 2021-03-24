package com.htc.madisonsite.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BasePage {
	WebDriver driver = null;
	@FindBy(xpath = "(//span[@class='label'])[3]")
	private WebElement accountBy;
	@FindBy(xpath = "//button[@id='send2']")
	private WebElement loginbuttonBy;
	@FindBy(xpath = "//a[@title='Log Out']")
	private WebElement logoutbuttonBy;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void Logout() {
		accountBy.click();
		logoutbuttonBy.click();
	}

}
