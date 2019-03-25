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
import com.training.pom.UNF_035_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_035_Test {
	private WebDriver driver;
	private String baseUrl;
	private MainPagePOM mainPagePOM;
	private UNF_035_POM unf_035_POM;
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
		unf_035_POM = new UNF_035_POM(driver);
		checkOutScreenPOM = new CheckOutScreenPOM(driver);
		baseUrl = properties.getProperty("adminURL");	
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
		unf_035_POM.sendUserName("admin");	
		unf_035_POM.sendPassword("admin@123");
		unf_035_POM.submitButtonClick();
		Thread.sleep(3000);
		unf_035_POM.optionsButtonClick();
		unf_035_POM.productButtonClick();
		unf_035_POM.addButtonClick();
		unf_035_POM.sendProductName("Blazer Girls(7-8)");
		unf_035_POM.sendMegaTagTitle("Blazer for Girls");
		unf_035_POM.clickDataTab
		();
		unf_035_POM.sendModel("BLG-112");
		unf_035_POM.sendPrice("3000");
		unf_035_POM.sendQuantity("100");
		unf_035_POM.clickdDiscountTab();
		unf_035_POM.clickAddDiscount();
		unf_035_POM.sendQuantityNumber("5");
		unf_035_POM.sendPriceAmount("100");
		unf_035_POM.sendStartDate("26/04/2019");
		unf_035_POM.sendEndDate("27/04/2019");
		unf_035_POM.ClickRewardPointsTab();
		unf_035_POM.sendRewardPoints("10");
		unf_035_POM.ClicksaveButton();
		
		
		
		
		
		
		
		
		
		
	}
}

