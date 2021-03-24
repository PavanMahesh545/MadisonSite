package com.htc.madisonsite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.htc.madisonsite.constants.Constants;
import com.htc.madisonsite.pages.BasePage;
import com.htc.madisonsite.pages.BillingPage;
import com.htc.madisonsite.pages.CartPage;
import com.htc.madisonsite.pages.HomePage;
import com.htc.madisonsite.pages.LoginPage;
import com.htc.madisonsite.pages.OrderConfirmationPage;
import com.htc.madisonsite.pages.ProductsListPage;
import com.htc.madisonsite.pages.ShoppingCartPage;
import com.htc.madisonsite.utilites.Screenshot;

public class BaseTest {
	protected WebDriver driver=null;
	protected LoginPage login = null;
	protected HomePage homepage = null;
	protected ProductsListPage productlist = null;
	protected CartPage cartpage = null;
	protected ShoppingCartPage shopping = null;
	protected BillingPage billing = null;
	protected OrderConfirmationPage confirm = null;
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
		login = new LoginPage(driver);
		homepage = new HomePage(driver);
		productlist = new ProductsListPage(driver);
		cartpage = new CartPage(driver);
		shopping = new ShoppingCartPage(driver);
		billing = new BillingPage(driver);
		confirm = new OrderConfirmationPage(driver);
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
				else {
					if(ITestResult.FAILURE == result.getStatus()) {
						
					}
				}
				
			}
		}

