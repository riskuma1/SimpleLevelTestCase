package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RegisterIDTest {
	

	private WebDriver driver;
	private String baseUrl;
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
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
		
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(4000);
		driver.quit();
	}
	@Test
	public void validRegistrationTest() throws InterruptedException {
		registerPOM.accountID();
		registerPOM.registerClick();
		registerPOM.sendFirstName("Neha");
		Assert.assertEquals("Neha",registerPOM.firstName.getAttribute("value"), "FirstName Mismatch");
		registerPOM.sendLastName("B");
		Assert.assertEquals("B",registerPOM.lastName.getAttribute("value"), "lastName Mismatch");
		registerPOM.sendEmail("neha7@gmail.com");
		Assert.assertEquals("neha7@gmail.com",registerPOM.emailAddress.getAttribute("value"), "emailID Mismatch");
		registerPOM.sendTelephone("9241835892");
		Assert.assertEquals("9241835892",registerPOM.telephoneNum.getAttribute("value"), "Telephone Number Mismatch");
		registerPOM.sendAddress1("Jayanagar");
		Assert.assertEquals("Jayanagar",registerPOM.Address.getAttribute("value"), "Address Mismatch");
		registerPOM.sendcity("Bangalore");
		Assert.assertEquals("Bangalore",registerPOM.cityName.getAttribute("value"), "cityName Mismatch");
		registerPOM.postCode("560082");
		Assert.assertEquals("560082",registerPOM.postalCode.getAttribute("value"), "postalCode Mismatch");
		registerPOM.country("India");
		Assert.assertEquals("India",registerPOM.SelectedCountryValue.getText(), "countryName Mismatch");
		registerPOM.state("Karnataka");
		Assert.assertEquals("Karnataka",registerPOM.SelectedRegionValue.getText(), "State Mismatch");
		registerPOM.password("Neha123");
		Assert.assertEquals("Neha123",registerPOM.passwordEntry.getAttribute("value"), "Password Mismatch");
		registerPOM.password_Confirm("Neha123");
		Assert.assertEquals("Neha123",registerPOM.passwordEntryConfirm.getAttribute("value"), "PasswordConfirm Mismatch");
		registerPOM.subscribe();
		Assert.assertTrue(registerPOM.subscribeButton.isSelected(), "Option No is not selected");
		registerPOM.termsCondnCheckBox();
		Assert.assertTrue(registerPOM.termsCondnCheck.isSelected(),"Term and Condn not checked");
		registerPOM.continueClick();
		Assert.assertEquals("YOUR ACCOUNT HAS BEEN CREATED!",registerPOM.registrationSuccess.getText(),"Account ID creation failed");
		
		
		
	}
}
