package com.amazon.testCases;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.base.BaseClass;
import com.amazon.pages.AmazonLandingPage;
import com.amazon.pages.CartPage;
import com.amazon.pages.ItemPage;
import com.amazon.utilities.ExcelUtilities;


import junit.framework.Assert;




public class TC_001_Amazon extends BaseClass {
	
	AmazonLandingPage landingPage;
	ItemPage ITEMPAGE;
	CartPage cp;
	String PRODUCT_NAME;
	String pp;
	String PRODUCT_PRICE;
	String PRODUCT_NAME_CART_PAGE;
	String PRODUCT_PRICE_CART_PAGE;
	String SUBTOTAL_CART_PAGE;
	String SHEETNAME = "product";
	Logger log = Logger.getLogger(TC_001_Amazon.class);
	
	
	public TC_001_Amazon()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		log.info("****************************** Starting test cases execution  *****************************************");
		log.info("launching chrome broswer");
		initiaizeBrowser();
		landingPage = new AmazonLandingPage();
	}
	
	@Test(dataProvider = "getProductName")
	public void tc_01_add_One_Item_In_Cart_and_Validate_the_item(String ProductName )
	
	{
		
		landingPage.enterItemName(ProductName);
		ITEMPAGE = landingPage.searchItem();
		ITEMPAGE.clickOnItem();
		PRODUCT_NAME = ITEMPAGE.getProductName();
		System.out.println(PRODUCT_NAME);
		pp = ITEMPAGE.getProductPrice();
		PRODUCT_PRICE = pp.substring(1);
		System.out.println("PRODUCT_PRICE"+PRODUCT_PRICE);
		
		
		cp = ITEMPAGE.clickonCart();
		PRODUCT_NAME_CART_PAGE = cp.getItemNameOnCartPage();
		PRODUCT_PRICE_CART_PAGE = cp.getItemPriceOnCartPage().trim();
		System.out.println("PRODUCT_PRICE_CART_PAGE"+PRODUCT_PRICE_CART_PAGE);
		SUBTOTAL_CART_PAGE = cp.getSubtotalOnCartPage();
		Assert.assertEquals(PRODUCT_NAME, PRODUCT_NAME_CART_PAGE);
		Assert.assertEquals(PRODUCT_PRICE, PRODUCT_PRICE_CART_PAGE);
		System.out.println("Subtotal Amount of Products are = "+SUBTOTAL_CART_PAGE);
		
		
	
	}
	
	@DataProvider
	public Object[][] getProductName()
	{
		Object data[][] = ExcelUtilities.getTestData(SHEETNAME);
		return data;
		
	}
	

	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();

		log.info("****************************** Browser is closed *****************************************");
	}

}
