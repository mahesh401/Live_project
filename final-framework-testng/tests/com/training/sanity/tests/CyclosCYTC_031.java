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
import com.training.pom.CYTC_004UserLoginPOM;
import com.training.pom.CYTC_031AddAdvertisementAndVerifyPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CyclosCYTC_031 {
	
	private WebDriver driver;
	private String baseUrl;
	private CYTC_002AdminLoginTestPOM CYTC_002AdminLoginTestPOM;
	private CYTC_004UserLoginPOM CYTC_004UserLoginPOM;
	private CYTC_031AddAdvertisementAndVerifyPOM CYTC_031AddAdvertisementAndVerifyPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		CYTC_002AdminLoginTestPOM = new CYTC_002AdminLoginTestPOM(driver);
		CYTC_004UserLoginPOM = new CYTC_004UserLoginPOM(driver);
		CYTC_031AddAdvertisementAndVerifyPOM = new CYTC_031AddAdvertisementAndVerifyPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	@Test (priority= 0)
	public void adminLoginTest() throws InterruptedException {
		CYTC_002AdminLoginTestPOM.loginName("admin");
		CYTC_002AdminLoginTestPOM.password("123456");
		CYTC_002AdminLoginTestPOM.submitBtn();
		screenShot.captureScreenShot("First");		
	}
	
	@Test (priority= 1) 
	public void addAdvertisementForMember() {

		CYTC_031AddAdvertisementAndVerifyPOM.memberLogin("mahesh3");
		CYTC_031AddAdvertisementAndVerifyPOM.ManageAdvSubmitBtn();
		CYTC_031AddAdvertisementAndVerifyPOM.AddNewAdvSubmitBtn();
		CYTC_031AddAdvertisementAndVerifyPOM.AdTitleField("ZEE Colors TV advert");
		CYTC_031AddAdvertisementAndVerifyPOM.AddCategoryField();
		
		//Select the category dropdown field
		Select dropdown = new Select(driver.findElement(By.name("ad(category)")));
		dropdown.selectByVisibleText("Example ad category");
		
		CYTC_031AddAdvertisementAndVerifyPOM.AddPriceField("7");
		CYTC_031AddAdvertisementAndVerifyPOM.AddPermament();
		CYTC_031AddAdvertisementAndVerifyPOM.Description("Test");
		CYTC_031AddAdvertisementAndVerifyPOM.mainBody();
		CYTC_031AddAdvertisementAndVerifyPOM.SaveBtn();
		
		Alert alert = driver.switchTo().alert();
		String Actual = alert.getText();
		alert.accept();
		
		String Expected ="Advertisement inserted";
		Expected = Expected.replaceAll("\\s", "");
		String Actual1 = Actual.replaceAll("\\s", ""); 
		assertEquals(Actual1, Expected);	
	}
	
	@Test (priority = 2)
	public void AdminLogoutTest() {
		CYTC_002AdminLoginTestPOM.LogOut();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	
	@Test (priority= 3)
	public void VerifyingAdvertisementAdded() {
		CYTC_004UserLoginPOM.loginName("mahesh3");
		CYTC_004UserLoginPOM.password("maheshreddy");
		CYTC_004UserLoginPOM.submitBtn();
		CYTC_031AddAdvertisementAndVerifyPOM.Personallink();
		CYTC_031AddAdvertisementAndVerifyPOM.AdvtLink();
		CYTC_031AddAdvertisementAndVerifyPOM.clickAdvt();
				
		String Expected1 ="My advertisements";
		String Expected = Expected1.replaceAll("\\s", "");
		String Actual1 = driver.findElement(By.xpath("//td[@class='tdHeaderTable']")).getText();
		String Actual = Actual1.replaceAll("\\s", ""); 
		assertEquals(Actual, Expected);	
	}
}
