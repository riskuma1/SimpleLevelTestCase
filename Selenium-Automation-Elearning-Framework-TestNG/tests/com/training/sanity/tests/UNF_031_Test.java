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
import com.training.pom.LoginUFSPOM;
import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_031_Test {
	private WebDriver driver;
	private String baseUrl;
	private LoginUFSPOM loginufsPOM;
	private RegisterPOM registerPOM;
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
	public void inValidLoginTest() throws InterruptedException {
		registerPOM.accountID();
		Thread.sleep(3000);
		loginufsPOM.login();
		loginufsPOM.loginEmailID("neha1@gmail.com");
		loginufsPOM.loginpwd("Neha123");  
		loginufsPOM.loginClick();
		Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.",loginufsPOM.invalidLoginAlert.getText(),"Login was succesfull with Invalid login/Pwd");
		
	}
}

