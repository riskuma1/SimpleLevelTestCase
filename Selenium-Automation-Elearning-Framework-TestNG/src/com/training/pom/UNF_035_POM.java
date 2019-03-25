package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UNF_035_POM {
	
private WebDriver driver; 
	
	public UNF_035_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@placeholder='Username']")
	public WebElement userName;
	
	@FindBy(xpath="//input[@id='input-password']")
	public WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement submitButton;
	
	@FindBy(xpath="//i[@class='fa fa-tags fa-fw']")
	public WebElement optionsButton;
	
	@FindBy(xpath="//a[@href='http://uniform.upskills.in/admin/index.php?route=catalog/product&token=9vZM8VzKPgY6Yf9jSh1a9veO2w0c47mi']")
	public WebElement productButton;
	
	
	
	@FindBy(xpath="//div[@class='pull-right']//a[@class='btn btn-primary']")
	public WebElement addButton;
	
	@FindBy(xpath="//input[@id='input-name1']")
	public WebElement productName;
	
	@FindBy(xpath="//input[@id='input-meta-title1']")
	public WebElement megaTagTitle;
	
	@FindBy(xpath="//a[contains(text(),'Data')]")
	public WebElement dataTab;
	
	@FindBy(xpath="//input[@id='input-model']")
	public WebElement model;
	
	@FindBy(xpath="//input[@id='input-price']")
	public WebElement price;
	
	@FindBy(xpath="//input[@id='input-quantity']")
	public WebElement quantity;
	
	@FindBy(xpath="//a[contains(text(),'Discount')]")
	public WebElement discountTab;
	
	@FindBy(xpath="//table[@id='discount']//i[@class='fa fa-plus-circle']")
	public WebElement addDiscount;
	
	@FindBy(xpath="//td[@class='text-right']//input[@placeholder='Quantity']")
	public WebElement quantityNumber;
	
	@FindBy(xpath="//td[@class='text-right']//input[@placeholder='Price']")
	public WebElement priceAmount;
	
	@FindBy(xpath="//input[@placeholder='Date Start']")
	public WebElement startDate;
	
	@FindBy(xpath="//input[@placeholder='Date End']")
	public WebElement endDate;
	
	@FindBy(xpath="//a[@href='#tab-reward']")
	public WebElement rewardPointsTab;
	
	@FindBy(xpath="//input[@id='input-points']")
	public WebElement rewardPoints;
	
	@FindBy(xpath="//i[@class='fa fa-save']")
	public WebElement saveButton;
	
	public void sendUserName(String userName)
	{
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password)
	{
		this.password.sendKeys(password);
	}
	
	public void submitButtonClick()
	{
		this.submitButton.click();
		
	}
	
	public void optionsButtonClick()
	{
		Actions act1= new Actions(driver);
		act1.moveToElement(optionsButton).click().build().perform();;
		
	}
	
	public void productButtonClick()
	{
		Actions act1= new Actions(driver);
		act1.moveToElement(productName).click().build().perform();
		
	}
	
	public void addButtonClick()
	{
		this.addButton.click();
    }
	
	public void sendProductName(String productName)
	{
		this.productName.sendKeys(productName);
	}
	
	public void sendMegaTagTitle(String megaTagTitle)
	{
		this.megaTagTitle.sendKeys(megaTagTitle);
	}
	
	public void clickDataTab() {
		
		Actions act1= new Actions(driver);
		act1.moveToElement(dataTab).click().build().perform();
	}
	
    public void sendModel(String model) 
    
    {
		this.model.sendKeys(model);
	}
    
   public void sendPrice(String price) 
    
    {
		this.price.sendKeys(price);
	}
   
   public void sendQuantity(String quantity) 
   
   {
		this.quantity.sendKeys(quantity);
	}
   
public void clickdDiscountTab() 
   
   {
	Actions act2= new Actions(driver);
	act2.moveToElement(discountTab).click().build().perform();
		
	}

public void clickAddDiscount() 

{
	this.addDiscount.click();
		
	}

public void sendQuantityNumber(String quantityNumber) 

{
	this.quantityNumber.sendKeys(quantityNumber);;
		
	}

public void sendPriceAmount(String priceAmount) 

{
	this.priceAmount.sendKeys(priceAmount);
		
	}

public void sendStartDate(String startDate) 

{
	this.startDate.sendKeys(startDate);
		
	}


public void sendEndDate(String endDate) 

{
	this.endDate.sendKeys(endDate);
		
	}

public void ClickRewardPointsTab() 
{
Actions act3= new Actions(driver);
act3.moveToElement(endDate).click().build().perform();

}

public void sendRewardPoints(String rewardPoints)

{
	this.rewardPoints.sendKeys(rewardPoints);
}

public void ClicksaveButton()
{
	this.saveButton.click();
}
}


