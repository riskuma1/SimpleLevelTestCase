package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class LoginUFSPOM {
	
	private WebDriver driver;
	
	public LoginUFSPOM(WebDriver driver) 
	{
	this.driver= driver;
	PageFactory.initElements(driver, this);
	}
	
		@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right myaccount-menu']//a[contains(text(),'Login')]")
		private WebElement loginButton; 
		
		@FindBy(xpath="//input[@placeholder='E-Mail Address']")
		private WebElement loginEmailAddress; 
		
		@FindBy(xpath="//input[@id='input-password']")
		private WebElement loginPassword; 
		
		@FindBy(xpath="//input[@value='Login']")
		private WebElement loginClickButton; 
		
		@FindBy(xpath="//div[@class='form-group']//a[contains(text(),'Forgotten Password')]")
		private WebElement forgotPassword;
		
		
		 	
		
	///Methods
		
		public void login() {
			this.loginButton.click();		
		}
		
		
		public void loginEmailID(String loginEmailAddress) {
			this.loginEmailAddress.clear();
			this.loginEmailAddress.sendKeys(loginEmailAddress);
		}
		
		public void loginpwd(String loginPassword) {
			this.loginPassword.clear();
			this.loginPassword.sendKeys(loginPassword);
		}
		
		public void loginClick() {
				this.loginClickButton.click();
			
		}
		
		public void forgotPwd() {
			this.forgotPassword.click();
		
	}
	}


