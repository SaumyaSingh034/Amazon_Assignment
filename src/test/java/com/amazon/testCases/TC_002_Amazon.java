package com.amazon.testCases;

import java.util.ArrayList;

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

public class TC_002_Amazon extends BaseClass {
	AmazonLandingPage landingPage;
	ItemPage ITEMPAGE;
	CartPage cp;
	String PRODUCT_NAME;
	String pp;
	String PRODUCT_PRICE;
	String PRODUCT_NAME_CART_PAGE;
	String PRODUCT_PRICE_CART_PAGE;
	String SUBTOTAL_CART_PAGE;
	String SHEETNAME = "products";
	ArrayList<String> PRODUCTS_NAME_CART_PAGE;
	Logger log = Logger.getLogger(TC_002_Amazon.class);
	
	public TC_002_Amazon()
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
	public void tc_002_add_more_items_and_validate(String ProductName, String SecondProductName)
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
		
		//********************************************
		
		//2nd item
		
		landingPage.enterItemName(SecondProductName);
		ITEMPAGE = landingPage.searchItem();
		ITEMPAGE.clickOnSecondItem();
		PRODUCT_NAME = ITEMPAGE.getProductName();
		System.out.println(PRODUCT_NAME);
		pp = ITEMPAGE.getProductPrice();
		PRODUCT_PRICE = pp.substring(1);
		System.out.println("PRODUCT_PRICE"+PRODUCT_PRICE);
		
		cp = ITEMPAGE.clickonCart();
		//************************************************
		PRODUCTS_NAME_CART_PAGE = cp.getItemNamefProducts();
		System.out.println(PRODUCTS_NAME_CART_PAGE);
		//PRODUCT_PRICE_CART_PAGE = cp.getItemPriceOnCartPage().trim();
		//System.out.println("PRODUCT_PRICE_CART_PAGE"+PRODUCT_PRICE_CART_PAGE);
		//SUBTOTAL_CART_PAGE = cp.getSubtotalOnCartPage();
//		Assert.assertEquals(PRODUCT_NAME, PRODUCT_NAME_CART_PAGE);
//		Assert.assertEquals(PRODUCT_PRICE, PRODUCT_PRICE_CART_PAGE);
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
