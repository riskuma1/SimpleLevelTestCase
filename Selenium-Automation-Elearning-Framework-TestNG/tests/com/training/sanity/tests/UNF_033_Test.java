package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.CheckOutScreenPOM;
import com.training.pom.LoginUFSPOM;
import com.training.pom.MainPagePOM;
import com.training.pom.MyAccountPOM;
import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_033_Test {
	private WebDriver driver;
	private String baseUrl;
	private LoginUFSPOM loginufsPOM;
	private RegisterPOM registerPOM;
	private MyAccountPOM myAccountPOM;
	private MainPagePOM mainPagePOM;
	private CheckOutScreenPOM checkOutScreenPOM ;
	private static Properties properties;
	private ScreenShot screenShot;


	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		registerPOM = new RegisterPOM(driver); 
		loginufsPOM = new LoginUFSPOM(driver);
		myAccountPOM = new MyAccountPOM(driver);	
		mainPagePOM = new MainPagePOM(driver);
		checkOutScreenPOM = new CheckOutScreenPOM(driver);
		baseUrl = properties.getProperty("baseURL");	
		screenShot = new ScreenShot(driver);  
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		//driver.quit();
	}
	@Test
	public void validLoginProductCheckOut() throws InterruptedException {
		registerPOM.accountID();
		Thread.sleep(3000);
		loginufsPOM.login();
		loginufsPOM.loginEmailID("neha1@gmail.com");
		loginufsPOM.loginpwd("Neha123");  
		loginufsPOM.loginClick();
		Assert.assertEquals("ACCOUNT",myAccountPOM.accoundHeading.getText(),"Login is not succesfull");
		myAccountPOM.uniformStoreLink();	
		mainPagePOM.premSchoolUnfirmButtonClick();
		mainPagePOM.blueTshirtClick();
		Thread.sleep(500);
		mainPagePOM.sizeSelection("32");
		//mainPagePOM.sizeSelect("32");
		mainPagePOM.addtoCart();;
	    mainPagePOM.cartTotal();
		Thread.sleep(3000);
		mainPagePOM.checkOut();
		checkOutScreenPOM.billingContinueClick();
		Thread.sleep(3000);
		checkOutScreenPOM.deliveryContinueClick();
		Thread.sleep(3000);
		boolean freeShipping = checkOutScreenPOM.freeShippingRadioBtn.isSelected();
		Thread.sleep(3000);
		Assert.assertEquals(true, freeShipping);
		Thread.sleep(3000);
		checkOutScreenPOM.enterCommments("Placing the Order");
		Thread.sleep(3000);
		checkOutScreenPOM.deliveryMethodContinueButtonClick();
		Thread.sleep(3000);
		checkOutScreenPOM.TermsandCondtnCheckboxClick();
		Thread.sleep(3000);
		checkOutScreenPOM.PaymentMethodContinueBtnClick();
		Thread.sleep(3000);
		checkOutScreenPOM.confirmOrderButtonClick();
		Thread.sleep(3000);
		Assert.assertEquals("YOUR ORDER HAS BEEN PLACED!",checkOutScreenPOM.orderConfirmation.getText(), "Order is not confirmed");
		
		
		
		 
		
		
		
	}
}

