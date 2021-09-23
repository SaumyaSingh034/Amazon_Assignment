package com.amazon.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.BaseClass;

public class ItemPage extends BaseClass{
	@FindBy(xpath="(//a[@class='a-link-normal a-text-normal'])[1]")
	WebElement itemLink;
	
	@FindBy(id="productTitle")
	WebElement productTitle;
	
	@FindBy(id="priceblock_ourprice")
	WebElement productPRICE;
	
	@FindBy(id="add-to-cart-button")
	WebElement addToCartBtn;
	
	@FindBy(id="nav-cart-text-container")
	WebElement cartBtn;
	
	
	
	public ItemPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnItem()
	{
		itemLink.click();
		Set<String> windows_IDS = driver.getWindowHandles();
		Iterator<String> window_ITERATOR = windows_IDS.iterator();
		String PARENT_WINDOW = window_ITERATOR.next();
		String CHILD_WINDOW = window_ITERATOR.next();
		driver.switchTo().window(CHILD_WINDOW);
	}
	
	public void clickOnSecondItem()
	{
		itemLink.click();
		Set<String> windows_IDS = driver.getWindowHandles();
		Iterator<String> window_ITERATOR = windows_IDS.iterator();
		String PARENT_WINDOW = window_ITERATOR.next();
		String CHILD_WINDOW = window_ITERATOR.next();
		String THIRD_WINDOW = window_ITERATOR.next();
		driver.switchTo().window(THIRD_WINDOW);
	}
	public String getProductName()
	{
		//After clicking changing to different window
	
		
		//Storing item name for validation 
		String ITEM_NAME = productTitle.getText();
		return ITEM_NAME;
	}
	public String getProductPrice()
	{
		String ITEM_PRICE = productPRICE.getText();
		return ITEM_PRICE;
	}
	
	public CartPage clickonCart()
	{
		
		addToCartBtn.click();
		
		//click on cart button
		cartBtn.click();
		return new CartPage();
	}
		
		
	}
	


