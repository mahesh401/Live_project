package com.training.regression.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import com.training.bean.CYTC_063UserRegistrationBean;
//import com.training.dao.CYTC_063UserRegistrationDAO;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.CYTC_001UserRegistrationPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_063UserRegistrationDBTest {
	private WebDriver driver;
	private String baseUrl;
	private CYTC_001UserRegistrationPOM CYTC_001UserRegistrationPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private GenericMethods genericMethods; 


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
		genericMethods = new GenericMethods(driver); 
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.quit();
	}

	//Test objective: To verify whether registered user details get displayed in database
	@Test(dataProvider = "db-inputs", dataProviderClass = LoginDataProviders.class)
	public void loginDBTest(String loginname, String fullname, String email, String birthday,String address, String postcode,
			String city, String phone, String mobile, String fax, String url, String password, String confirmpassword) {

		CYTC_001UserRegistrationPOM.submitBtn();
		String loginname1 = CYTC_001UserRegistrationPOM.loginName("mahesh503");
		String fullName1 = CYTC_001UserRegistrationPOM.fullName("mahesh venky");
		String emailID1 = CYTC_001UserRegistrationPOM.emailID("mahesh503@test.com");
		String birthDate1 = CYTC_001UserRegistrationPOM.birthDate("20/02/2010");
		CYTC_001UserRegistrationPOM.genderMale();
		String address1 = CYTC_001UserRegistrationPOM.address("bangalore");
		String postalCode1 = CYTC_001UserRegistrationPOM.postalCode("560022");
		String city1 = CYTC_001UserRegistrationPOM.city("bangalore");

		//Area selection
		Select dropdown = new Select(driver.findElement(By.id("custom_field_select_6")));
		dropdown.selectByVisibleText("Example area");

		String phonenum1 = CYTC_001UserRegistrationPOM.phoneNum("9980451243");
		String mobPhoneNum1 = CYTC_001UserRegistrationPOM.mobPhoneNum("9980451244");
		String faxnum1 = CYTC_001UserRegistrationPOM.faxNum("9980451245");
		String url1 = CYTC_001UserRegistrationPOM.url("www.google.com");
		String password1 = CYTC_001UserRegistrationPOM.password("mahesh401");
		String confirmPassword1 = CYTC_001UserRegistrationPOM.confirmPassword("mahesh401");

		String captchaVal = JOptionPane.showInputDialog("Please enter the captcha value:");		
		CYTC_001UserRegistrationPOM.capthcaText(captchaVal);
		CYTC_001UserRegistrationPOM.saveBtn(); 

		assertEquals(loginname1,loginname);
		assertEquals(fullName1,fullname);
		assertEquals(emailID1,email);
		assertEquals(birthDate1,birthday);
		assertEquals(address1,address);
		assertEquals(postalCode1,postcode);
		assertEquals(city1,city);
		assertEquals(phonenum1,phone);
		assertEquals(mobPhoneNum1,mobile);
		assertEquals(faxnum1,fax);
		assertEquals(url1,url);
		assertEquals(password1,password);
		assertEquals(confirmPassword1,confirmpassword);
	}

}