package com.htc.madisonsite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.htc.madisonsite.constants.Constants;
import com.htc.madisonsite.pages.BasePage;
import com.htc.madisonsite.pages.Billing;
import com.htc.madisonsite.pages.Cart;
import com.htc.madisonsite.pages.Home;
import com.htc.madisonsite.pages.Login;
import com.htc.madisonsite.pages.OrderConfirmation;
import com.htc.madisonsite.pages.ProductsList;
import com.htc.madisonsite.pages.ShoppingCart;
import com.htc.madisonsite.utilites.Screenshot;

public class BaseTest {
	protected WebDriver driver=null;
	protected Login login = null;
	protected Home homepage = null;
	protected ProductsList productlist = null;
	protected Cart cartpage = null;
	protected ShoppingCart shopping = null;
	protected Billing billing = null;
	protected OrderConfirmation confirm = null;
	protected BasePage bp = null;
   
	protected Screenshot screenshot = null;

	public Properties data = null;

	public BaseTest() {
		data = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("C:\\Users\\myi35000\\git\\MadisonSite\\Madisonsite\\src\\test\\resources\\data.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			data.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@BeforeSuite()
	@Parameters("browser")
	public void start(String browser) {

		this.driver = BrowserFactory.setWebDriver(browser);
		this.driver.get(Constants.URL);
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(Constants.SECONDS, TimeUnit.SECONDS);
		//PageFactory.initElements(driver, this);
	}
	@BeforeClass
	public void browserSetup() {
		login = new Login(driver);
		homepage = new Home(driver);
		productlist = new ProductsList(driver);
		cartpage = new Cart(driver);
		shopping = new ShoppingCart(driver);
		billing = new Billing(driver);
		confirm = new OrderConfirmation(driver);
		bp = new BasePage(driver);
		
	}
     
      public WebDriver getDriver() {
		return this.driver;
	}
    @AfterMethod
	public void doLogout(ITestResult result) throws IOException, InterruptedException {
		 if (ITestResult.SUCCESS == result.getStatus()) {
				bp.Logout();
		 }
				
				}
				
			}
		

