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
import com.training.pom.ForgotPwdPOM;
import com.training.pom.LoginUFSPOM;
import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ForgotPwdResetTest {
	private WebDriver driver;
	private String baseUrl;
	private LoginUFSPOM loginufsPOM;
	private RegisterPOM registerPOM;
	private ForgotPwdPOM forgotPwdPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private String implicitWaitTime;

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
		forgotPwdPOM = new ForgotPwdPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		implicitWaitTime = properties.getProperty("implicitWait");
		screenShot = new ScreenShot(driver); 
	    System.out.println(implicitWaitTime);
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}
	
	@Test
	public void forgotPwdReset() throws InterruptedException {
		registerPOM.accountID();
		Thread.sleep(3000);
		loginufsPOM.login();
		loginufsPOM.loginEmailID("neha1@gmail.com");
		loginufsPOM.loginpwd("Neha1234");  
		loginufsPOM.loginClick();
		loginufsPOM.forgotPwd();
		forgotPwdPOM.emailAdd("neha1@gmail.com");
		forgotPwdPOM.continue_Btn();
		Assert.assertEquals("An email with a confirmation link has been sent your email address.",forgotPwdPOM.forgotPwdResetAlert.getText(),"Password link is not sent to emailID");
		
		
		
		
		
}
}