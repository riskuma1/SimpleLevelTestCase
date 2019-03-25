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

public class UNF_034_Test {
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
		mainPagePOM.premSchoolUnfirmButtonClick();
		mainPagePOM.blueTshirtClick();
		mainPagePOM.sizeSelection("32");
		mainPagePOM.addtoCart();
		Thread.sleep(3000);
	    mainPagePOM.cartTotal();
	    Thread.sleep(3000);
		mainPagePOM.viewCart();
		Thread.sleep(3000);
		mainPagePOM.ViewCartContinueButtonClick();
		Thread.sleep(3000);
		checkOutScreenPOM.registerAcctContinueButtonClick();
		Thread.sleep(3000);
		checkOutScreenPOM.sendRegisterFirstName("Rishi");
		checkOutScreenPOM.sendRegisterLastName("K");
		checkOutScreenPOM.sendRegisterEmail("rishi286@gmail.com");
		checkOutScreenPOM.sendRegisterPhone("7890765433");
		checkOutScreenPOM.sendRegisterAddress1("Jayanagar");
		checkOutScreenPOM.sendRegisterCity("Bangalore");
		checkOutScreenPOM.sendRegisterPostal("560082");
		checkOutScreenPOM.sendRegisterRegion("Karnataka");
		checkOutScreenPOM.sendRegisterPwd("Rishi123");
		checkOutScreenPOM.sendRegisterConfirmPwd("Rishi123");
		Thread.sleep(3000);
		checkOutScreenPOM.registerTermsandCondnCheckboxClick();
		checkOutScreenPOM.registerAcctandBillDetailsContnButtonClick();
		Thread.sleep(3000);
		checkOutScreenPOM.registerDeliveryDetailsContnButtonClick();
		Thread.sleep(3000);
		checkOutScreenPOM.sendRegisterDeliveryMethodTextBox("Order");
		Thread.sleep(3000);
		checkOutScreenPOM.registerDeliveryMethodContnButtonClick();
		Thread.sleep(3000);
		checkOutScreenPOM.registerPaymentMethodCheckBoxClick();
		Thread.sleep(3000);
		checkOutScreenPOM.registerPaymentMethodContnButtonClick();
		Thread.sleep(3000);
		checkOutScreenPOM.registerConfirmOrderContnButtonClick();
		
		//Assert.assertEquals("YOUR ORDER HAS BEEN PLACED!",checkOutScreenPOM.orderConfirmation.getText(), "Order is not confirmed");
		

	}
}

