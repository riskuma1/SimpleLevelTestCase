package com.training.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckOutScreenPOM {
	

	private WebDriver driver; 
	
	public CheckOutScreenPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath=("//h1[contains(text(),'Checkout')]"))
	public WebElement checkOutAlert;
	
	//@FindBy(xpath=("//input[@value='Continue']"))
	@FindBy(xpath=("//div[@class='pull-right']"))
	public WebElement billingContinueButton;
	
	
	@FindBy(xpath=("//input[@id='button-shipping-address']"))
	public WebElement deliveryContinueButton;
	
	
	@FindBy(xpath=("//input[@value='free.free']"))
	public WebElement freeShippingRadioBtn;
	
	@FindBy(xpath=("//textarea[@name='comment']"))
	public WebElement enterCommentsTextBox;
	
	@FindBy(xpath=("//input[@id='button-shipping-method']"))
	public WebElement deliveryMethodContinueButton;
	
	@FindBy(xpath=("//input[@value='1']"))
	public WebElement termsandCondtnCheckbox;
	
	@FindBy(xpath=("//input[@id='button-payment-method']"))
	public WebElement paymentMethodContinueBtn;
	
	@FindBy(xpath=("//input[@id='button-confirm']"))
	public WebElement confirmOrderButton;
	
	@FindBy(xpath=("//h1[contains(text(),'Your order has been placed!')]"))
	public WebElement orderConfirmation;
	
	
	@FindBy(xpath="//input[@value='Continue']")
	public WebElement registerAcctContinueButton;
	
	@FindBy(xpath="//input[@id='input-payment-firstname']")
	public WebElement registerFirstName;
	
	@FindBy(xpath="//input[@id='input-payment-lastname']")
	public WebElement registerLastName;
	
	@FindBy(xpath="//input[@id='input-payment-email']")
	public WebElement registerEmail;
	
	@FindBy(xpath="//input[@id='input-payment-telephone']")
	public WebElement registerPhone;
			
	@FindBy(xpath="//input[@id='input-payment-password']")
	public WebElement registerPwd;
	
	@FindBy(xpath="//input[@id='input-payment-confirm']")
	public WebElement registerConfirmPwd;
		
	@FindBy(xpath="//input[@id='input-payment-address-1']")
	public WebElement registerAddress1;
	
	@FindBy(xpath="//input[@id='input-payment-city']")
	public WebElement registerCity;
	
	@FindBy(xpath="//input[@id='input-payment-postcode']")
	public WebElement registerPostal;
	
	@FindBy(xpath="//select[@id='input-payment-country']")
	public WebElement registerCountry;
	
	@FindBy(xpath="//select[@id='input-payment-zone']")
	public WebElement registerRegion;
	
	@FindBy(xpath="//input[@value='Continue']")
	public WebElement registerNewAcctDetailsContnButton;
	
	@FindBy(xpath="//div[@class='pull-right']//input[@value='1']")
	public WebElement registerTermsandCondnCheckbox;
	
	
	@FindBy(xpath="//input[@id='button-register']")
	public WebElement registerAcctandBillDetailsContnButton;
	

	@FindBy(xpath="//div[@class='panel-collapse collapse in']//input[@value='Continue']")
	public WebElement registerDeliveryDetailsContnButton;
	
	//yaha se
	@FindBy(xpath="//textarea[@name='comment']")
	public WebElement registerDeliveryMethodTextBox;
	
	@FindBy(xpath="//input[@id='button-shipping-method']")
	public WebElement registerDeliveryMethodContnButton;
	
	@FindBy(xpath="//input[@value='1']")
	public WebElement registerPaymentMethodCheckBox;
	
	@FindBy(xpath="//input[@id='button-payment-method']")
	public WebElement registerPaymentMethodContnButton;
	
	@FindBy(xpath="//input[@id='button-confirm']")
	public WebElement registerConfirmOrderContnButton;
	
	
	
	public void billingContinueClick()
	{
		Actions act1= new Actions(driver);
		act1.moveToElement(billingContinueButton).click().build().perform();
		
	}
	
	public void deliveryContinueClick()
	{
		this.deliveryContinueButton.click();
	}
	
	public void enterCommments(String enterCommentsTextBox) {
		this.enterCommentsTextBox.sendKeys(enterCommentsTextBox);
	}
	
	public void deliveryMethodContinueButtonClick() {
		this.deliveryMethodContinueButton.click();
	}
	
	public void TermsandCondtnCheckboxClick() {
		this.termsandCondtnCheckbox.click();
	}
	
	public void PaymentMethodContinueBtnClick() {
		this.paymentMethodContinueBtn.click();
	}
	
	public void confirmOrderButtonClick() {
		this.confirmOrderButton.click();
	}
	
	public void registerAcctContinueButtonClick()
	{
	this.registerAcctContinueButton.click();
	
}
	public void sendRegisterFirstName(String registerFirstName) {
		this.registerFirstName.clear();
		this.registerFirstName.sendKeys(registerFirstName);
		
	}
	
	public void sendRegisterLastName(String registerLastName) {
		this.registerLastName.clear();
		this.registerLastName.sendKeys(registerLastName);
	}
	
	public void sendRegisterEmail(String registerEmail) {
		this.registerEmail.clear();
		this.registerEmail.sendKeys(registerEmail);
		
	}
	
	public void sendRegisterPhone(String registerPhone) {
		this.registerPhone.clear();
		this.registerPhone.sendKeys(registerPhone);
    }
	
	public void sendRegisterAddress1(String registerAddress1) {
		this.registerAddress1.clear();
		this.registerAddress1.sendKeys(registerAddress1);
	}
	
	public void sendRegisterCity(String registerCity) {
		this.registerCity.clear();
		this.registerCity.sendKeys(registerCity);
	}
	
	
	public void sendRegisterPostal(String registerPostal) {
		this.registerPostal.clear();
		this.registerPostal.sendKeys(registerPostal);
	}
	
	public void sendRegisterCountry(String country_Name) {
		Select s1 = new Select(registerCountry);
		s1.selectByVisibleText(country_Name);	
				
}
	
	public void sendRegisterRegion(String region_Name) {
		Select s2 = new Select(registerRegion);
		s2.selectByVisibleText(region_Name);	
		
}
		
	public void sendRegisterPwd(String registerPwd) {
		this.registerPwd.clear();
		this.registerPwd.sendKeys(registerPwd);
}
	
	public void sendRegisterConfirmPwd(String registerConfirmPwd) {
		this.registerConfirmPwd.clear();
		this.registerConfirmPwd.sendKeys(registerConfirmPwd);
}
	
	public void registerTermsandCondnCheckboxClick() {
		this.registerTermsandCondnCheckbox.click();
		//Actions act = new Actions(driver);
		//act.moveToElement(registerTermsandCondnCheckbox).click().build().perform();
	}
	
	public void registerAcctandBillDetailsContnButtonClick() {
	this.registerAcctandBillDetailsContnButton.click();
	}
	
	public void registerDeliveryDetailsContnButtonClick() {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,-250)");
	      this.registerDeliveryDetailsContnButton.click();
		//Actions act2 = new Actions(driver);
		//act2.moveToElement(registerDeliveryDetailsContnButton).click().build().perform();
	
	
	}
	
	public void sendRegisterDeliveryMethodTextBox(String registerDeliveryMethodTextBox) {
		this.registerDeliveryMethodTextBox.sendKeys(registerDeliveryMethodTextBox);
}
	
	public void registerDeliveryMethodContnButtonClick() 
	{
	    this.registerDeliveryMethodContnButton.click();
	}
	
	public void registerPaymentMethodCheckBoxClick() 
	{
	this.registerPaymentMethodCheckBox.click();
	
	}
	
	public void registerPaymentMethodContnButtonClick() 
	{
	this.registerPaymentMethodContnButton.click();
	
	}
	
	public void registerConfirmOrderContnButtonClick()
	{
	this.registerConfirmOrderContnButton.click();
}
}
