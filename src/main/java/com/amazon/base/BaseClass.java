package com.amazon.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.amazon.utilities.BasicUtility;


public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	public static String BROWSER_NAME = null;
	
	//Declaring constructor of class
	public BaseClass()
	{
	prop = new Properties();
	try {
		FileInputStream fis = new FileInputStream(BasicUtility.PROPERTIES_FILE);
		prop.load(fis);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	
	public void initiaizeBrowser()
	{
		BROWSER_NAME = prop.getProperty("browser");

		if (BROWSER_NAME.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\Selenium\\FrameworkPractice\\AmazonAssignment" + "\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			

		} else if (BROWSER_NAME.equalsIgnoreCase("ie")) {

			driver = new InternetExplorerDriver();
			System.setProperty("webdriver.ie.driver",
					"D:\\Selenium\\FrameworkPractice\\AmazonAssignment" + "\\drivers\\IEServer.exe");

		} else if (BROWSER_NAME.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();
			System.setProperty("webdriver.gecko.driver",
					"D:\\Selenium\\FrameworkPractice\\AmazonAssignment" + "\\drivers\\geckodriver.exe");

		} else if (BROWSER_NAME.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();
			System.setProperty("webdriver.edge.driver",
					"D:\\Selenium\\FrameworkPractice\\AmazonAssignment" + "\\drivers\\edgedriver.exe");

		} else {
			System.out.println("Please Check Your Browser. You have enter wrong browser......");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(BasicUtility.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(BasicUtility.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		

	}
}
