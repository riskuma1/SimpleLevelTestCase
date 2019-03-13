package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPOM {
	
	 
	
private WebDriver driver; 
	
	public RegisterPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//span[@class='caret']")
	private WebElement account; 
	
	@FindBy(xpath="//a[contains(text(),'Register')]")
	private WebElement registerButton;
	
	@FindBy(xpath="//input[@id='input-firstname']")
	public WebElement firstName; 
	
	
	@FindBy(xpath="//input[@id='input-lastname']")
	public WebElement lastName; 
	
	@FindBy(xpath="//input[@id='input-email']")
	public WebElement emailAddress; 
	
	@FindBy(xpath="//input[@id='input-telephone']")
	public WebElement telephoneNum; 
	 
	@FindBy(xpath="//input[@id='input-address-1']")
	public WebElement Address; 
	 
	@FindBy(xpath="//input[@id='input-city']")
	public WebElement cityName ; 

	@FindBy(xpath="//input[@id='input-postcode']")
	public WebElement postalCode  ; 
	
	@FindBy(xpath="//select[@id='input-country']")
	public WebElement countryName  ; 
	
	@FindBy(xpath="//select[@id='input-zone']")
	public WebElement regionName; 
	
	@FindBy(xpath="//input[@id='input-password']")
	public WebElement passwordEntry; 
	
	@FindBy(xpath="//input[@id='input-confirm']")
	public WebElement passwordEntryConfirm;
	
	@FindBy(xpath="//input[@value='0']")
	public WebElement subscribeButton;
	
	@FindBy(xpath="//div[@class='pull-right']//input[@value='1']")
	public WebElement termsCondnCheck;
	
	@FindBy(xpath="//input[@value='Continue']")
	public WebElement continueButton;
	
	@FindBy(xpath="//h1[contains(text(),'Your Account Has Been Created!')]")
	public WebElement registrationSuccess;
	
	public WebElement SelectedCountryValue;
	public WebElement SelectedRegionValue;
	
	
///Methods
	
	public void accountID() {
		this.account.click();		
	}
	
	public void registerClick() {
		this.registerButton.click();
	}
	
	
	public void sendFirstName(String firstName) {
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
		
	}
	
	public void sendLastName(String lastName) {
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
	}
	
	public void sendEmail(String emailAddress) {
		this.emailAddress.clear();
		this.emailAddress.sendKeys(emailAddress);
		
	}
	
	public void sendTelephone(String telephoneNum) {
		this.telephoneNum.clear();
		this.telephoneNum.sendKeys(telephoneNum);
    }
	
	public void sendAddress1(String Address) {
		this.Address.clear();
		this.Address.sendKeys(Address);
	}
	
	public void sendcity(String cityName) {
		this.cityName.clear();
		this.cityName.sendKeys(cityName);
	}
	
	
	public void postCode(String postalCode) {
		this.postalCode.clear();
		this.postalCode.sendKeys(postalCode);
	}
	
	public void country(String country_Nm) {
		Select s1 = new Select(countryName);
		s1.selectByVisibleText(country_Nm);	
		SelectedCountryValue= s1.getFirstSelectedOption();		
}
	
	public void state(String region_Nm) {
		Select s2 = new Select(regionName);
		s2.selectByVisibleText(region_Nm);	
		SelectedRegionValue = s2.getFirstSelectedOption();
}
		
	public void password(String passwordEntry) {
		this.passwordEntry.clear();
		this.passwordEntry.sendKeys(passwordEntry);
}
	
	public void password_Confirm(String passwordEntryConfirm) {
		this.passwordEntryConfirm.clear();
		this.passwordEntryConfirm.sendKeys(passwordEntryConfirm);
}

public void subscribe() {
		this.subscribeButton.click();
}
	
	public void termsCondnCheckBox() {
		this.termsCondnCheck.click();
	
	}
	
	public void continueClick() {
			this.continueButton.click();
		
	}
	
	
}


