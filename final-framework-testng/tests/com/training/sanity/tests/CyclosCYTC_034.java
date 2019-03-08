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
import com.training.pom.CYTC_002AdminLoginTestPOM;
import com.training.pom.CYTC_004UserLoginPOM;
import com.training.pom.CYTC_034ViewLoanAmount;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CyclosCYTC_034 {

	private WebDriver driver;
	private String baseUrl;
	private CYTC_002AdminLoginTestPOM CYTC_002AdminLoginTestPOM;
	private CYTC_004UserLoginPOM CYTC_004UserLoginPOM;
	private CYTC_034ViewLoanAmount CYTC_034ViewLoanAmount;
	private static Properties properties;
	private ScreenShot screenShot;
	private String AmountBalance2;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);

		driver = DriverFactory.getDriver(DriverNames.CHROME);
		CYTC_002AdminLoginTestPOM = new CYTC_002AdminLoginTestPOM(driver);
		CYTC_004UserLoginPOM = new CYTC_004UserLoginPOM(driver);
		CYTC_034ViewLoanAmount = new CYTC_034ViewLoanAmount(driver); 
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
	public void ViewLoanBalanceTest() {

		CYTC_034ViewLoanAmount.AccountLink();
		CYTC_034ViewLoanAmount.LoanLink();
		CYTC_034ViewLoanAmount.LoanViewIcon();
		String AmountBalance1 = driver.findElement(By.id("amountText")).getAttribute("value");
		System.out.println("Loan Balance before repayment:" +AmountBalance1);

	}

	@Test (priority= 3)
	public void RepaymentTest() {
		CYTC_034ViewLoanAmount.AmountField("500");
		CYTC_034ViewLoanAmount.RepayBtn();

		//Click on OK button on the alert window
		Alert alert1 = driver.switchTo().alert();
		String Actual1 = alert1.getText();
		alert1.accept();

		String Expected1 ="Are you sure to repay 5,00 units? Please, click OK to proceed";
		Expected1 = Expected1.replaceAll("\\s", "");
		String Actuala = Actual1.replaceAll("\\s", ""); 
		assertEquals(Actuala, Expected1);


		//Click on OK button on the alert window and confirm
		Alert alert2 = driver.switchTo().alert();
		String Actual2 = alert2.getText();
		alert2.accept();

		String Expected2 ="The repayment was succesfully processed";
		Expected2 = Expected2.replaceAll("\\s", "");
		String Actualb = Actual2.replaceAll("\\s", ""); 
		assertEquals(Actualb, Expected2);

		//Displaying the account balance after repayment

		AmountBalance2 = driver.findElement(By.name("amount")).getAttribute("value");
		System.out.println("Loan Balance after repayment:" +AmountBalance2);		
	}

	@Test (priority= 4)
	public void UserLogoutTest() {
		CYTC_034ViewLoanAmount.LogoutBtn();
		Alert alert3 = driver.switchTo().alert();
		String Actual3 = alert3.getText();
		alert3.accept();

		String Expected3 ="Please confirm to logout";
		Expected3 = Expected3.replaceAll("\\s", "");
		String Actualc = Actual3.replaceAll("\\s", ""); 
		assertEquals(Actualc, Expected3);
	}

	@Test (priority= 5)
	public void AdminLogin() {
		CYTC_002AdminLoginTestPOM.loginName("admin");
		CYTC_002AdminLoginTestPOM.password("123456");
		CYTC_002AdminLoginTestPOM.submitBtn();

		CYTC_034ViewLoanAmount.MemberLogin("mahesh3");
		CYTC_034ViewLoanAmount.ViewLoans();

		String ExpectedBalance = AmountBalance2;
		ExpectedBalance = ExpectedBalance.replaceAll("\\s", "");

		String AmountBalance = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[2]/td[3]")).getText();
		String ActualBalance = AmountBalance.replaceAll("\\s", ""); 
		System.out.println("Amount Balance is:" +AmountBalance);
		assertTrue(ActualBalance.contains(ExpectedBalance));

	}
}
