package com.amazon.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.BaseClass;

public class CartPage extends BaseClass{
	
	@FindBy(xpath="//span[@class='a-truncate-cut']")
	WebElement itemName;
	
	@FindBy(xpath="//span[@class='a-truncate-cut']")
	List<WebElement> itemNames;
	
	@FindBy(xpath="//div[@class='a-column a-span2 a-text-right sc-item-right-col a-span-last']/p")
	WebElement itemPrice;
	
	@FindBy(xpath="//span[@id='sc-subtotal-amount-activecart']/span")
	WebElement subtotal;
	
	WebElement itemSizeName;
	
	WebElement itemColour;
	WebElement itemPatternName;
	
	WebElement quantity;
	WebElement deleteBtn;
	WebElement saveForLater;
	WebElement seeMoreLikeThis;

	public CartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getItemNameOnCartPage()
	{
		String ITEM_NAME_ONCART = itemName.getText();
		//System.out.println("*************  "+ITEM_NAME_ONCART+"  ***********");
		return ITEM_NAME_ONCART;
		
		
	
	}
	
	public ArrayList<String> getItemNamefProducts()
	{
		ArrayList<String> items = new ArrayList<String>();
		for(int i=0;i<itemNames.size();i++)
		{
			String item = itemNames.get(i).getText();
			items.add(item);
		}
		return items;
	}
	
	public String getItemPriceOnCartPage()
	{
		String ITEM_PRICE_ONCART = itemPrice.getText();
		//System.out.println("*************  "+ITEM_PRICE_ONCART+"  ***********");
		return ITEM_PRICE_ONCART;
	}
	
	public String getSubtotalOnCartPage()
	{
		String ITEM_SUBTOTAL_ONCART = subtotal.getText();
		//System.out.println("*************  "+ITEM_SUBTOTAL_ONCART+"  ***********");
		return ITEM_SUBTOTAL_ONCART;
	}

	
}
