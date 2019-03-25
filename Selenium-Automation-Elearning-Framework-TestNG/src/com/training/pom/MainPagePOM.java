package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MainPagePOM {
	
private WebDriver driver;
	
	public MainPagePOM(WebDriver driver) 
	{
	this.driver= driver;
	PageFactory.initElements(driver, this);
	}
	
	public String size;

	@FindBy(xpath="//a[@href='http://uniform.upskills.in/']//img[@class='img-responsive']")
	public WebElement premSchoolUnfirmButton;
	
	@FindBy(xpath="//a[@href='http://uniform.upskills.in/index.php?route=product/product&product_id=179']//img[@title='SPORTS T-SHIRTS']")
	public WebElement blueTshirt;
	
	@FindBy(xpath="//div[@class='form-group required']//child::select[1]")
	public WebElement sizeSelectiondropdown;
	
	@FindBy(xpath="//select[@name='option[368]']")
	public WebElement sizedropDown;
	
	@FindBy(xpath="//div[@class='form-group quntity']//child::button[1]")
	public WebElement addToCardButton;
	
	//@FindBy(xpath="//span[@id='cart-total']")
	@FindBy(xpath="//div[@class='btn-group btn-block']//button[@type='button']")
	public WebElement cartTotalbutton;
	
	
	@FindBy(xpath="//strong[contains(text(),'Checkout')]")
	public WebElement checkOutButton;
	
	@FindBy(xpath="//strong[contains(text(),'View Cart')]")
	public WebElement viewCartButton;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	public WebElement viewCartContinueButton;
	

	
	public void premSchoolUnfirmButtonClick()
	{
	this.premSchoolUnfirmButton.click();
	}
	
	public void blueTshirtClick()
	{
	this.blueTshirt.click();
	
	
}
	
	public void sizeSelection(String size)
	{
	Select s3 = new Select(sizeSelectiondropdown);
	//s3.selectByVisibleText(size);
	s3.selectByIndex(4);
	
}
	
	public void sizeSelect(String size)
	{
	Select s4 = new Select(sizedropDown);
	s4.selectByVisibleText(size);
	
}
	
	public void addtoCart()
	{
	this.addToCardButton.click();
	
}
	public void cartTotal()
	{
	this.cartTotalbutton.click();
		//Actions act2 = new Actions(driver);
		//act2.moveToElement(cartTotalbutton).click().build().perform();
    }
	
	public void checkOut()
	{
		
	Actions action = new Actions(driver);
	action.moveToElement(checkOutButton).click().build().perform();
	
    }
	
	public void viewCart()
	{
		
	Actions action1 = new Actions(driver);
	action1.moveToElement(viewCartButton).click().build().perform();
	
    }
	
	public void ViewCartContinueButtonClick()
	{
	this.viewCartContinueButton.click();
	
}
	
	

}

