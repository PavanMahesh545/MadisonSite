package com.htc.madisonsite.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProductsListPage extends BasePage {
	
	@FindBy(xpath = "(//a[@title='Suede Loafer, Navy'])[2]")
	private WebElement productBy;

	public ProductsListPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void selectproductBy() {
		try {
			productBy.click();
		} catch (NoSuchElementException | StaleElementReferenceException exception) {
			System.out.println(exception.getStackTrace());
		}
	}
}
