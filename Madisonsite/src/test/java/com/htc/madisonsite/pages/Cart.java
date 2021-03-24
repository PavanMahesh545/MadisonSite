package com.htc.madisonsite.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cart extends BasePage {
	@FindBy(xpath = "(//span[@class='swatch-label'])[1]")
	private WebElement colourBy;
	@FindBy(xpath = "//*[@id=\"swatch97\"]/span[1]")
	private WebElement sizeBy;
	@FindBy(xpath = "//input[@id='qty']")
	private WebElement quantityBy;
	@FindBy(xpath = "(//button[@class='button btn-cart'])[2]")
	private WebElement addtocartBy;

	public Cart(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	public void setcolourBy() {
		colourBy.click();
	}

	public void setsizeBy() {
		sizeBy.click();
	}

	public void selectproduct(String value) {
		try {
			 colourBy.click();
			 sizeBy.click();
			
			  WebElement we=quantityBy; we.click(); we.clear(); we.sendKeys(value);
			 
			quantityBy.click();
			quantityBy.clear();
			quantityBy.sendKeys(value);
			addtocartBy.click();
		} catch (NoSuchElementException | StaleElementReferenceException exception) {
			System.out.println(exception.getStackTrace());
		}
	}

	public void addtocartBy() {
		addtocartBy.click();
	}
}
