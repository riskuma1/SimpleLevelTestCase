package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.LoginUFSPOM;
import com.training.pom.MyAccountPOM;
import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginDBTest {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private LoginUFSPOM loginufsPOM;
	private RegisterPOM registerPOM;
	private MyAccountPOM myAccountPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private GenericMethods genericMethods; 
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		registerPOM = new RegisterPOM(driver); 
		loginufsPOM = new LoginUFSPOM(driver);
		myAccountPOM = new MyAccountPOM(driver);	
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		genericMethods = new GenericMethods(driver); 
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}


	@Test(dataProvider = "db-inputs", dataProviderClass = LoginDataProviders.class)
	public void loginDBTest(String userName, String password) throws InterruptedException {
		// for demonstration 
//		genericMethods.getElement("login", "id"); 
				
		/**loginPOM.sendUserName(userName);
		loginPOM.sendPassword(password);
		loginPOM.clickLoginBtn();
		**/
		registerPOM.accountID();
		Thread.sleep(3000);
		loginufsPOM.login();
		loginufsPOM.loginEmailID(userName);
		loginufsPOM.loginpwd(password);  
		loginufsPOM.loginClick();
		myAccountPOM.uniformStoreLink();
		
		//screenShot.captureScreenShot(userName);

	}

}