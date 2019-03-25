package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPOM {
	
private WebDriver driver; 
	
	public MyAccountPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//div[@class='box-heading']")
	public WebElement accoundHeading;
	
	@FindBy(xpath="//a[@class='list-group-item'][contains(text(),'Order History')]")
	private WebElement orderHistorylink;
	
	@FindBy(xpath="//i[@class='fa fa-eye']")
	private WebElement viewButton;
	
	@FindBy(xpath="//td[contains(text(),'Order ID')]")
	public WebElement orderID;
	
	@FindBy(xpath="//td[contains(text(),'Customer')]")
	public WebElement customerName;
	
	@FindBy(xpath="//td[contains(text(),'No. of Products')]")
	public WebElement NumOfProd;
	
	@FindBy(xpath="//td[contains(text(),'Total')]")
	public WebElement total;
	
	@FindBy(xpath="//td[contains(text(),'Date Added')]")
	public WebElement dateAdded;
	
	@FindBy(xpath="[//h2[contains(text(),'Order Information')]")
	public WebElement orderInfo;
	
	@FindBy(xpath="//div[@class='header_middel']//child::a[1]")
	public WebElement uniformStore;
	
	public void order_History() {
		this.orderHistorylink.click();
		
		
	}	
	public void viewDetails() {
		this.viewButton.click();
		
	}
	
	public void uniformStoreLink(){
		this.uniformStore.click();
		
	}
}