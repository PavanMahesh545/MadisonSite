package com.htc.madisonsite.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class OrderConfirmation extends BasePage  {

	@FindBy(xpath="(//h1[text() = \\\"Your order has been received.\\\"])")
	private WebElement chechouttitle;
	
	public OrderConfirmation(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public String getConfirmMessage() {
		return chechouttitle.getText();
	}
}