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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.CYTC_002AdminLoginTestPOM;
import com.training.pom.CYTC_033AddLoanDetailsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CyclosCYTC_033 {

	private WebDriver driver;
	private String baseUrl;
	private CYTC_002AdminLoginTestPOM CYTC_002AdminLoginTestPOM;
	private CYTC_033AddLoanDetailsPOM CYTC_033AddLoanDetailsPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);

		driver = DriverFactory.getDriver(DriverNames.CHROME);
		CYTC_002AdminLoginTestPOM = new CYTC_002AdminLoginTestPOM(driver);
		CYTC_033AddLoanDetailsPOM = new CYTC_033AddLoanDetailsPOM(driver); 
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
	public void addLoanForMember() {

		CYTC_033AddLoanDetailsPOM.memberLogin("mahesh3");
		CYTC_033AddLoanDetailsPOM.GrantLoanBtn();
		CYTC_033AddLoanDetailsPOM.LoanAmount("200000");
		CYTC_033AddLoanDetailsPOM.descriptionField("Home Loan");
		CYTC_033AddLoanDetailsPOM.SubmitBtn1();
		CYTC_033AddLoanDetailsPOM.SubmitBtn2();

		Alert alert = driver.switchTo().alert();
		String Actual = alert.getText();
		alert.accept();

		String Expected ="The loan was successfully granted";
		Expected = Expected.replaceAll("\\s", "");

		System.out.println(Actual);
		String Actual1 = Actual.replaceAll("\\s", ""); 
		assertEquals(Actual1, Expected);	
	}

	@Test (priority = 2)
	public void VerifyTheAddedLoans() {
		CYTC_033AddLoanDetailsPOM.ViewLoansBtn();

		String ActualDescription = driver.findElement(By.xpath ("//td[contains(text(),'Home Loan')]")).getText();
		String Expected ="Home Loan";
		Expected = Expected.replaceAll("\\s", "");

		System.out.println();
		String Actual1 = ActualDescription.replaceAll("\\s", ""); 
		assertEquals(Actual1, Expected);	
	}
}
