package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username")
	private WebElement userName; 
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//a[@id='button-menu']")
	private WebElement menuBtn;
	
	//@FindBy(xpath="//a[@class='parent'][contains(text(),'Products')]")
	//private WebElement productsicon;
	
	@FindBy(xpath="//span[contains(text(),'Reports')]")
	private WebElement reporticon;
		
	//@FindBy(id="formLogin_submitAuth")
	//private WebElement loginBtn; 
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}

	public void clickmenuButton() {
		this.menuBtn.click();
	}
	
	public void clicReport() {
      this.reporticon.click();
        } 
      	
}


