package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.swing.JOptionPane;

import org.openqa.selenium.Alert;
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
import com.training.pom.CYTC_003AdminAccessToEditRegisteredUserPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CyclosCYTC_003 {
	
	private WebDriver driver;
	private String baseUrl;
	private CYTC_002AdminLoginTestPOM CYTC_002AdminLoginTestPOM;
	private CYTC_003AdminAccessToEditRegisteredUserPOM CYTC_003AdminAccessToEditRegisteredUserPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		CYTC_002AdminLoginTestPOM = new CYTC_002AdminLoginTestPOM(driver);
		CYTC_003AdminAccessToEditRegisteredUserPOM = new CYTC_003AdminAccessToEditRegisteredUserPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	@Test (priority= 1)
	public void adminLoginTest() throws InterruptedException {
		CYTC_002AdminLoginTestPOM.loginName("admin");
		CYTC_002AdminLoginTestPOM.password("12345");
		CYTC_002AdminLoginTestPOM.submitBtn();
		screenShot.captureScreenShot("First");		
	}
	
	@Test (priority= 2) 
	public void modifyTheUserAccount() throws InterruptedException{

	
		CYTC_003AdminAccessToEditRegisteredUserPOM.memberUsername("mahesh3");
		screenShot.captureScreenShot("Second");
		Thread.sleep(1000);
		CYTC_003AdminAccessToEditRegisteredUserPOM.submitBtn2();
		CYTC_003AdminAccessToEditRegisteredUserPOM.newGrp();
		//Group selection
		Select dropdown = new Select(driver.findElement(By.name("newGroupId")));
		dropdown.selectByVisibleText("Full members");
		CYTC_003AdminAccessToEditRegisteredUserPOM.comments("full access to the member");
		screenShot.captureScreenShot("Third");
		CYTC_003AdminAccessToEditRegisteredUserPOM.submitBtn3();
		
		Alert alert = driver.switchTo().alert();
		String Actual1 = alert.getText();
		alert.accept();
		
		String Expected ="The member's group was changed";
		Expected = Expected.replaceAll("\\s", "");

		System.out.println(Actual1);
		String Actual = Actual1.replaceAll("\\s", ""); 
		assertEquals(Actual, Expected);	
	}
}
