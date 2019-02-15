package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.CYTC_002AdminLoginTestPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CyclosCYTC_002 {

	private WebDriver driver;
	private String baseUrl;
	private CYTC_002AdminLoginTestPOM CYTC_002AdminLoginTestPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		CYTC_002AdminLoginTestPOM = new CYTC_002AdminLoginTestPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	@Test //(priority=0)
	public void adminLoginTest() {
		CYTC_002AdminLoginTestPOM.loginName("admin");
		CYTC_002AdminLoginTestPOM.password("12345");
		screenShot.captureScreenShot("First");
		CYTC_002AdminLoginTestPOM.submitBtn();
		screenShot.captureScreenShot("Second");		

		String Expected1 ="Logged user: admin - Administrator";
		String Expected = Expected1.replaceAll("\\s", "");
	
		String Actual1 = driver.findElement(By.xpath("//*[@id=\"loginDataBar\"]/span[1]")).getText();
		System.out.println(Actual1);
		String Actual = Actual1.replaceAll("\\s", ""); 
		assertEquals(Actual, Expected);	
	}
}
