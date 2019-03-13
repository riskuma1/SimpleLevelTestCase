package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPwdPOM {
	
private WebDriver driver; 
	
	public ForgotPwdPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='E-Mail Address']")
	private WebElement emailAddress;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continue_Button;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	public WebElement forgotPwdResetAlert;
	
	public void emailAdd(String emailAddress) {
		this.emailAddress.clear();
		this.emailAddress.sendKeys(emailAddress);
		
	}
	
	public void continue_Btn() {
		this.continue_Button.click();;
		
	}
}