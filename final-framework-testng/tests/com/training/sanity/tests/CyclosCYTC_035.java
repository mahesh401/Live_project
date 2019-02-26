package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.swing.JOptionPane;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.CYTC_004UserLoginPOM;
import com.training.pom.CYTC_035PerformSystemPaymentPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CyclosCYTC_035 {

	private WebDriver driver;
	private String baseUrl;
	private CYTC_004UserLoginPOM CYTC_004UserLoginPOM;
	private CYTC_035PerformSystemPaymentPOM CYTC_035PerformSystemPaymentPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private String AmountBalance2;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);

		driver = DriverFactory.getDriver(DriverNames.CHROME);
		CYTC_004UserLoginPOM = new CYTC_004UserLoginPOM(driver);
		CYTC_035PerformSystemPaymentPOM = new CYTC_035PerformSystemPaymentPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	@Test (priority= 1)
	public void UserLoginTest() {
		CYTC_004UserLoginPOM.loginName("mahesh3");
		CYTC_004UserLoginPOM.password("maheshreddy");
		CYTC_004UserLoginPOM.submitBtn();
	}

	@Test (priority= 2) 
	public void PayAmountToLoanTest() {

		CYTC_035PerformSystemPaymentPOM.AccountLink();
		CYTC_035PerformSystemPaymentPOM.SysPaymentLink();
		CYTC_035PerformSystemPaymentPOM.AmountField("500");
		Select dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"type\"]")));
		dropdown.selectByVisibleText("Member to community");

		CYTC_035PerformSystemPaymentPOM.DescriptionField("Charity");
		CYTC_035PerformSystemPaymentPOM.SubmitBtn1();

		String Expected = "You are about to perform the following payment:";
		String Actual = driver.findElement(By.xpath("//*[@id=\"tdContents\"]/form/table[1]/tbody/tr[2]/td/table/tbody/tr[1]/td")).getText();
		assertTrue(Actual.contains(Expected));


		CYTC_035PerformSystemPaymentPOM.SubmitBtn2();

		String Expected1 = "The payment has been performed";
		String Actual1 = driver.findElement(By.xpath("//*[@id=\"tdContents\"]/table/tbody/tr[2]/td/table/tbody/tr[1]/td")).getText();
		assertTrue(Actual1.contains(Expected1));		
	}

	@Test(priority= 3)
	public void AccountInfoTest() {

		CYTC_035PerformSystemPaymentPOM.AccountInfoLink();

		String Expected2 ="From member to community account";
		String Actual2 = driver.findElement(By.xpath("//tr[contains(@class,'ClassColorSelected')]//td[@align='left'][contains(text(),'From member to community account')]")).getText();
		assertTrue(Actual2.contains(Expected2));

		String Expected3 = "Community account";
		String Actual3 = driver.findElement(By.xpath("//td[@class='innerBorder']//tbody//tr[2]//td[2]")).getText();
		assertTrue(Actual3.contains(Expected3));

	}

}
