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
import com.training.pom.CYTC_001UserRegistrationPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CyclosCYTC_001 {

	private WebDriver driver;
	private String baseUrl;
	private CYTC_001UserRegistrationPOM CYTC_001UserRegistrationPOM;
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
		CYTC_001UserRegistrationPOM = new CYTC_001UserRegistrationPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	/*@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}*/

	@Test (priority=0)
	public void userAccountCreation() {
		CYTC_001UserRegistrationPOM.submitBtn();
		CYTC_001UserRegistrationPOM.loginName("mahesh10");
		CYTC_001UserRegistrationPOM.fullName("Mahesh Venkataswamy");
		CYTC_001UserRegistrationPOM.emailID("mahesh410@gmail.com");
		CYTC_001UserRegistrationPOM.birthDate("24061986");
		CYTC_001UserRegistrationPOM.genderMale();
		CYTC_001UserRegistrationPOM.address("Indiranagar");
		CYTC_001UserRegistrationPOM.postalCode("560008");
		CYTC_001UserRegistrationPOM.city("Bangalore");

		//Area selection
		Select dropdown = new Select(driver.findElement(By.id("custom_field_select_6")));
		dropdown.selectByVisibleText("Example area");

		CYTC_001UserRegistrationPOM.phoneNum("08025269610");
		CYTC_001UserRegistrationPOM.mobPhoneNum("9980926710");
		CYTC_001UserRegistrationPOM.faxNum("0805732110");
		CYTC_001UserRegistrationPOM.url("www.google.com");
		CYTC_001UserRegistrationPOM.password("maheshreddy");
		CYTC_001UserRegistrationPOM.confirmPassword("maheshreddy");

		String captchaVal = JOptionPane.showInputDialog("Please enter the captcha value:");		
		CYTC_001UserRegistrationPOM.capthcaText(captchaVal);
		screenShot.captureScreenShot("First");
		CYTC_001UserRegistrationPOM.saveBtn(); 
		screenShot.captureScreenShot("Second");		

		String Expected1 ="Thanks for registering! Your account has been created and needs to be activated by the administration.";
		String Expected = Expected1.replaceAll("\\s", "");
		String myWindowHandle = driver.getWindowHandle();
		driver.switchTo().window(myWindowHandle);

		
		String Actual1 = driver.findElement(By.xpath("//*[@id=\"tdContents\"]/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[1]/td")).getText();
		System.out.println(Actual1);
		//String Actual = Actual1.trim();
		String Actual = Actual1.replaceAll("\\s", ""); 
		assertEquals(Actual, Expected);	
	}
}
