package com.training.regression.tests;

import static org.testng.Assert.assertTrue;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JOptionPane;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.training.pom.CYTC_001UserRegistrationPOM;

public class CYTC_061UserRegistrationValidationExcelTest {
	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private CYTC_001UserRegistrationPOM CYTC_001UserRegistrationPOM;

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

	//Test objective: To verify whether application displays error message upon entering invalid credentials in the required fields using Excel data input.
	@Test(dataProvider = "excel-inputs1", dataProviderClass = LoginDataProviders.class)
	public void UserRegistrationValidationTest(String loginName, String fullName, String emailID, String birthDate,String address,String postalCode,String city,String phoneNum,String mobPhoneNum,String password,String confirmPassword) {
	
		CYTC_001UserRegistrationPOM.submitBtn();
		CYTC_001UserRegistrationPOM.loginName(loginName);
		CYTC_001UserRegistrationPOM.fullName(fullName);
		CYTC_001UserRegistrationPOM.emailID(emailID);
		CYTC_001UserRegistrationPOM.birthDate(birthDate);
		CYTC_001UserRegistrationPOM.genderMale();
		CYTC_001UserRegistrationPOM.address(address);
		CYTC_001UserRegistrationPOM.postalCode(postalCode);
		CYTC_001UserRegistrationPOM.city(city);

		//Area selection
		Select dropdown = new Select(driver.findElement(By.id("custom_field_select_6")));
		dropdown.selectByVisibleText("Example area");

		CYTC_001UserRegistrationPOM.phoneNum(phoneNum);
		CYTC_001UserRegistrationPOM.mobPhoneNum(mobPhoneNum);
		CYTC_001UserRegistrationPOM.password(password);
		CYTC_001UserRegistrationPOM.confirmPassword(confirmPassword);

		String captchaVal = JOptionPane.showInputDialog("Please enter the captcha value:");		
		CYTC_001UserRegistrationPOM.capthcaText(captchaVal);
		screenShot.captureScreenShot("First");
		CYTC_001UserRegistrationPOM.saveBtn(); 
		screenShot.captureScreenShot("Second");		

		String Expected = "Mobile phone is not unique";
		String Expected1= Expected.replaceAll("\\s", "");
		
		Alert alert = driver.switchTo().alert();
		String Actual = alert.getText();
		String Actual1 = Actual.replaceAll("\\s", ""); 
		assertTrue(Actual1.contains(Expected1));	
	}

}