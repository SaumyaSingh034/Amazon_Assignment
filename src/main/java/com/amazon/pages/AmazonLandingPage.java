package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.BaseClass;


public class AmazonLandingPage extends BaseClass{
	
	/**
	 * 1 - Create Object Repositories
	 */
	@FindBy(id = "twotabsearchtextbox")
	WebElement searchBar;
	
	@FindBy(id="nav-search-submit-button")
	WebElement searchEnter;
	
	@FindBy(id="nav-cart-text-container")
	WebElement cart;
	
	public AmazonLandingPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Methods
	
	public void enterItemName(String itemName)
	{
		searchBar.sendKeys(itemName);
	}
	
	public ItemPage searchItem()
	{
		searchEnter.click();
		return new ItemPage();
	}
}
