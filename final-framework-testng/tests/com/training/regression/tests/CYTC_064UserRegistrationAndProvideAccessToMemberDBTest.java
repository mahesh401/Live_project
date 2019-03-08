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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.CYTC_001UserRegistrationPOM;
import com.training.pom.CYTC_002AdminLoginTestPOM;
import com.training.pom.CYTC_003AdminAccessToEditRegisteredUserPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_064UserRegistrationAndProvideAccessToMemberDBTest {
	private static WebDriver driver;
	private static String baseUrl;
	private static CYTC_001UserRegistrationPOM CYTC_001UserRegistrationPOM;
	private static CYTC_002AdminLoginTestPOM CYTC_002AdminLoginTestPOM;
	private static CYTC_003AdminAccessToEditRegisteredUserPOM CYTC_003AdminAccessToEditRegisteredUserPOM;
	private static Properties properties;
	private static ScreenShot screenShot;
	private static GenericMethods genericMethods; 


	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		CYTC_001UserRegistrationPOM = new CYTC_001UserRegistrationPOM(driver);
		CYTC_002AdminLoginTestPOM = new CYTC_002AdminLoginTestPOM(driver);
		CYTC_003AdminAccessToEditRegisteredUserPOM = new CYTC_003AdminAccessToEditRegisteredUserPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		genericMethods = new GenericMethods(driver); 
		// open the browser
		driver.get(baseUrl);
	}

	//Test objective: To verify whether application allows to get registered, admin to provide access as full member & user able to login as member using Data Base input.
	@Test(priority=1, dataProvider = "db-inputs", dataProviderClass = LoginDataProviders.class)
	public void createNewMember(String loginname, String fullname, String email, String birthday,String address, String postcode,
			String city, String phone, String mobile, String fax, String url, String password, String confirmpassword, String comments) {

		CYTC_001UserRegistrationPOM.submitBtn();
		String loginname1 = CYTC_001UserRegistrationPOM.loginName("mahesh504");
		String fullName1 = CYTC_001UserRegistrationPOM.fullName("mahesh venky");
		String emailID1 = CYTC_001UserRegistrationPOM.emailID("mahesh504@test.com");
		String birthDate1 = CYTC_001UserRegistrationPOM.birthDate("20/02/2010");
		CYTC_001UserRegistrationPOM.genderMale();
		String address1 = CYTC_001UserRegistrationPOM.address("bangalore");
		String postalCode1 = CYTC_001UserRegistrationPOM.postalCode("560022");
		String city1 = CYTC_001UserRegistrationPOM.city("bangalore");

		Select dropdown = new Select(driver.findElement(By.id("custom_field_select_6")));
		dropdown.selectByVisibleText("Example area");

		String phonenum1 = CYTC_001UserRegistrationPOM.phoneNum("9980451246");
		String mobPhoneNum1 = CYTC_001UserRegistrationPOM.mobPhoneNum("9980451247");
		String faxnum1 = CYTC_001UserRegistrationPOM.faxNum("9980451248");
		String url1 = CYTC_001UserRegistrationPOM.url("www.google.com");
		String password1 = CYTC_001UserRegistrationPOM.password("mahesh401");
		String confirmPassword1 = CYTC_001UserRegistrationPOM.confirmPassword("mahesh401");

		String captchaVal = JOptionPane.showInputDialog("Please enter the captcha value:");		
		CYTC_001UserRegistrationPOM.capthcaText(captchaVal);
		CYTC_001UserRegistrationPOM.saveBtn(); 
		
		//Click OK on the pop-up window
		String myWindowHandle = driver.getWindowHandle();
		driver.switchTo().window(myWindowHandle);
		CYTC_001UserRegistrationPOM.OKBtn();		
		
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
	
	//Admin login to provide access to newly created member
	@Test(priority=2)
	public void adminLoginTest() {
			CYTC_002AdminLoginTestPOM.loginName("admin");
			CYTC_002AdminLoginTestPOM.password("123456");
			CYTC_002AdminLoginTestPOM.submitBtn();
	}
	
	@Test(priority=3, dataProvider = "db-inputs", dataProviderClass = LoginDataProviders.class)
	public void provideAccessToMember(String loginname, String fullname, String email, String birthday,String address, String postcode,
			String city, String phone, String mobile, String fax, String url, String password, String confirmpassword, String comments){
		
		
		CYTC_003AdminAccessToEditRegisteredUserPOM.memberUsername("mahesh504");
		CYTC_003AdminAccessToEditRegisteredUserPOM.submitBtn2();
		CYTC_003AdminAccessToEditRegisteredUserPOM.newGrp();
		//Group selection
		Select dropdown = new Select(driver.findElement(By.name("newGroupId")));
		dropdown.selectByVisibleText("Full members");
		String comments1 = CYTC_003AdminAccessToEditRegisteredUserPOM.comments("full access to the member");
		CYTC_003AdminAccessToEditRegisteredUserPOM.submitBtn3();
		
		assertEquals(comments1, comments);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();		
	}
}