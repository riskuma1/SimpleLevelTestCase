package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginUFSPOM;
import com.training.pom.MyAccountPOM;
import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class OrderHistoryTest  {
		private WebDriver driver;
		private String baseUrl;
		private LoginUFSPOM loginufsPOM;
		private RegisterPOM registerPOM;
		private MyAccountPOM myAccountPOM;
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
			baseUrl = properties.getProperty("baseURL");	
			screenShot = new ScreenShot(driver); 
		    
			// open the browser 
			driver.get(baseUrl);
		}
		
		@AfterMethod
		public void tearDown() throws Exception {
			Thread.sleep(5000);
			driver.quit();
		}
		
		@Test
		public void orderHistoryCheck() throws InterruptedException {
			registerPOM.accountID();
			Thread.sleep(3000);
			loginufsPOM.login();
			loginufsPOM.loginEmailID("neha2@gmail.com");
			loginufsPOM.loginpwd("Neha123");  
			loginufsPOM.loginClick();
			myAccountPOM.order_History();
			Assert.assertTrue(myAccountPOM.orderID.isDisplayed(), "OrderID column is not displayed");
			Assert.assertTrue(myAccountPOM.customerName.isDisplayed(), "customerName column is not displayed");
			Assert.assertTrue(myAccountPOM.NumOfProd.isDisplayed(), "NumOfProd column is not displayed");
		    Assert.assertTrue(myAccountPOM.total.isDisplayed(), "total column is not displayed");
		    Assert.assertTrue(myAccountPOM.dateAdded.isDisplayed(), "dateAdded column is not displayed");
			myAccountPOM.viewDetails();
    
		}}