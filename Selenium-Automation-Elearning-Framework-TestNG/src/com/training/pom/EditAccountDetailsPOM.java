package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditAccountDetailsPOM {
private WebDriver driver; 
	
	public EditAccountDetailsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[contains(text(),'Edit Account')]")
	public WebElement editAccount;
	
	@FindBy(xpath="//input[@placeholder='First Name']")
	public WebElement firstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	public WebElement lastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	public WebElement emailID;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	public WebElement telephoneNum;
	
	
	@FindBy(xpath="//input[@value='Continue']")
	public WebElement continueButton;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	public WebElement editAcctSuccessPopUp;
	
	
	
	public void editAcctClick() {
		this.editAccount.click();
		
		
	}	
	public void editFirstName(String firstName) {
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
		
	}
	
	public void editLastName(String lastName) {
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
	}
	
	public void editEmail(String emailID) {
		this.emailID.clear();
		this.emailID.sendKeys(emailID);
		
	}
	
	public void editTelephone(String telephoneNum) {
		this.telephoneNum.clear();
		this.telephoneNum.sendKeys(telephoneNum);
    }
	
	public void continueBtn() {
		this.continueButton.click();
		
    }
	
	
}

