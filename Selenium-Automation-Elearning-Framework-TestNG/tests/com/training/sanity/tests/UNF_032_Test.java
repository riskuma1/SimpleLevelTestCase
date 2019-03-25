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

public class UNF_032_Test {
	private WebDriver driver;
	private String baseUrl;
	private MainPagePOM mainPagePOM;
	private CheckOutScreenPOM checkOutScreenPOM;
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
	public void validCheckOutTest() throws InterruptedException {
		mainPagePOM.premSchoolUnfirmButtonClick();
		mainPagePOM.blueTshirtClick();
		mainPagePOM.sizeSelection("32");
		mainPagePOM.addtoCart();;
	    mainPagePOM.cartTotal();
		Thread.sleep(3000);
		mainPagePOM.checkOut();
		Thread.sleep(3000);
		Assert.assertEquals("CHECKOUT",checkOutScreenPOM.checkOutAlert.getText(),"CheckOut is failed");
		
	}
}

