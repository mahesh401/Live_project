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
import com.training.pom.CYTC_004UserLoginPOM;
import com.training.pom.CYTC_005UserDetailModificationTestPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CyclosCYTC_005 {

	private WebDriver driver;
	private String baseUrl;
	private CYTC_004UserLoginPOM CYTC_004UserLoginPOM;
	private CYTC_005UserDetailModificationTestPOM CYTC_005UserDetailModificationTestPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);

		driver = DriverFactory.getDriver(DriverNames.CHROME);
		CYTC_004UserLoginPOM = new CYTC_004UserLoginPOM(driver);
		CYTC_005UserDetailModificationTestPOM = new CYTC_005UserDetailModificationTestPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	@Test (priority=1)
	public void userLoginTest() {
		CYTC_004UserLoginPOM.loginName("mahesh9");
		CYTC_004UserLoginPOM.password("maheshreddy");
		screenShot.captureScreenShot("First");
		CYTC_004UserLoginPOM.submitBtn();
		screenShot.captureScreenShot("Second");	
	}

	@Test (priority=2)
	public void userDetailsModificationTest() { 

		CYTC_005UserDetailModificationTestPOM.myProfile();
		CYTC_005UserDetailModificationTestPOM.modifyButton();
		CYTC_005UserDetailModificationTestPOM.addressField("Kodihalli");
		CYTC_005UserDetailModificationTestPOM.saveButton();

		Alert alert = driver.switchTo().alert();
		String Actual1 = alert.getText();
		alert.accept();

		String Expected ="Profile modified";
		Expected = Expected.replaceAll("\\s", "");

		System.out.println(Actual1);
		String Actual = Actual1.replaceAll("\\s", ""); 
		assertEquals(Actual, Expected);	
	}
}
