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
import com.training.pom.CYTC_032AddPaymentSystemPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CyclosCYTC_032 {
	
	private WebDriver driver;
	private String baseUrl;
	private CYTC_002AdminLoginTestPOM CYTC_002AdminLoginTestPOM;
	private CYTC_004UserLoginPOM CYTC_004UserLoginPOM;
	private CYTC_032AddPaymentSystemPOM CYTC_032AddPaymentSystemPOM;
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
		CYTC_032AddPaymentSystemPOM = new CYTC_032AddPaymentSystemPOM(driver); 
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

		CYTC_032AddPaymentSystemPOM.memberLogin("mahesh3");
		CYTC_032AddPaymentSystemPOM.PaySystemSubmitBtn();
		CYTC_032AddPaymentSystemPOM.amount("500");
	
		CYTC_032AddPaymentSystemPOM.type();
		Select dropdown = new Select(driver.findElement(By.name("type")));
		dropdown.selectByVisibleText("Debit to member");
		
		CYTC_032AddPaymentSystemPOM.descriptionField("Test");
		CYTC_032AddPaymentSystemPOM.SubmitBtn1();
		CYTC_032AddPaymentSystemPOM.SubmitBtn2();
		
		String Actual = driver.findElement(By.xpath ("//td[@class='tdHeaderTable']")).getText();
		String Expected ="Successful payment";
		Expected = Expected.replaceAll("\\s", "");

		System.out.println(Actual);
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
		
		CYTC_032AddPaymentSystemPOM.AccountLink();
		CYTC_032AddPaymentSystemPOM.AccInfoLink();
						
		String Expected1 ="Debit account";
		String Expected = Expected1.replaceAll("\\s", "");
	
		String Actual1 = driver.findElement(By.xpath("//*[@id=\"tdContents\"]/table[1]/tbody/tr[3]/td/table/tbody/tr[2]/td[2]")).getText();
		System.out.println(Actual1);
		String Actual = Actual1.replaceAll("\\s", ""); 
		assertEquals(Actual, Expected);	
	}
}
