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
import com.training.pom.EditAccountDetailsPOM;
import com.training.pom.LoginUFSPOM;
import com.training.pom.MyAccountPOM;
import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class EditAccountDetailsTest  {
		private WebDriver driver;
		private String baseUrl;
		private LoginUFSPOM loginufsPOM;
		private RegisterPOM registerPOM;
		private EditAccountDetailsPOM editAccountDetailsPOM;
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
			editAccountDetailsPOM = new EditAccountDetailsPOM(driver);
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
		public void editAcctDetailsTest() throws InterruptedException {
			registerPOM.accountID();
			Thread.sleep(3000);
			loginufsPOM.login();
			loginufsPOM.loginEmailID("neha2@gmail.com");
			loginufsPOM.loginpwd("Neha123");  
			loginufsPOM.loginClick();
			editAccountDetailsPOM.editAcctClick();
			editAccountDetailsPOM.editFirstName("Neha");
			Assert.assertEquals("Neha",editAccountDetailsPOM.firstName.getAttribute("value"), "FirstName is not edited correctly");
			editAccountDetailsPOM.editLastName("B");
			Assert.assertEquals("B",editAccountDetailsPOM.lastName.getAttribute("value"), "lastName is not edited correctly");
			editAccountDetailsPOM.editEmail("neha2@gmail.com");
			Assert.assertEquals("neha2@gmail.com",editAccountDetailsPOM.emailID.getAttribute("value"), "emailID is not edited correctly");
			editAccountDetailsPOM.editTelephone("9876543210");
			Assert.assertEquals("9876543210",editAccountDetailsPOM.telephoneNum.getAttribute("value"), "Telephone is not edited correctly");
			editAccountDetailsPOM.continueBtn();
			Assert.assertEquals("Success: Your account has been successfully updated.",editAccountDetailsPOM.editAcctSuccessPopUp.getText(),"Account ID Update failed");
    
		}}