package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CYTC_001UserRegistrationPOM {
	private WebDriver driver; 

	public CYTC_001UserRegistrationPOM (WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[@id=\"loginRegistrationDiv\"]/input")
	private WebElement submitBtn;
	
	@FindBy(name="member(user).username")
	private WebElement loginName; 
	
	@FindBy(name="member(name)")
	private WebElement fullName; 
	
	@FindBy(name="member(email)")
	private WebElement emailID; 
	
	@FindBy(name="member(customValues).value")
	private WebElement birthDate; 	
	
	@FindBy(id="_radio_2_1")
	private WebElement genderMale; 
	
	@FindBy(xpath="//tbody//tr[6]//td[2]//input[3]")
	private WebElement address; 
	
	@FindBy(xpath="//tbody//tr[7]//td[2]//input[3]")
	private WebElement postalCode; 
	
	@FindBy(xpath="//tbody//tr[8]//td[2]//input[3]")
	private WebElement city; 
	
	@FindBy(xpath="//*[@id=\"custom_field_select_6\"]")
	private WebElement area; 
	
	@FindBy(xpath="//tbody//tr[10]//td[2]//input[3]")
	private WebElement phoneNum; 
	
	@FindBy(xpath="//tbody//tr[11]//td[2]//input[3]")
	private WebElement mobPhoneNum; 
	
	@FindBy(xpath="//tbody//tr[12]//td[2]//input[3]")
	private WebElement faxNum; 	
	
	@FindBy(xpath="//tbody//tr[13]//td[2]//input[3]")
	private WebElement url; 	
	
	@FindBy(xpath="//input[@name='member(user).password']")
	private WebElement password; 	
	
	@FindBy(xpath="//input[@name='confirmPassword']")
	private WebElement confirmPassword; 	
	
	@FindBy(xpath="//*[@id=\"captchaImage\"]")
	private WebElement capthcaField; 	
	
	@FindBy(xpath="//input[@name='captcha']")
	private WebElement capthcaText; 	
	
	@FindBy(xpath="//*[@id=\"saveButton\"]")
	private WebElement saveBtn;

	
	public void submitBtn() {
		this.submitBtn.click();
	}
	
	public void loginName(String loginName) {
		this.loginName.clear();
		this.loginName.sendKeys(loginName);
	}
	
	public void fullName(String fullName) {
		this.fullName.clear();
		this.fullName.sendKeys(fullName);
	}
	
	public void emailID(String emailID) {
		this.emailID.clear();
		this.emailID.sendKeys(emailID);
	}
	
	public void birthDate(String birthDate) {
		this.birthDate.sendKeys(birthDate);
	}
	
	public void genderMale() {
		this.genderMale.click();
	}
	
	public void address(String address) {
		this.address.clear();
		this.address.sendKeys(address);
	}
	
	public void postalCode(String postalCode) {
		this.postalCode.clear();
		this.postalCode.sendKeys(postalCode);
	}
	
	public void city(String city) {
		this.city.clear();
		this.city.sendKeys(city);
	}
	
	public void area() {
		this.area.click();		
	}
	
	public void areaSelect() {
		this.areaSelect();
	}
	
	public void phoneNum(String phoneNum) {
		this.phoneNum.clear();
		this.phoneNum.sendKeys(phoneNum);
	}
	
	public void mobPhoneNum(String mobPhoneNum) {
		this.mobPhoneNum.clear();
		this.mobPhoneNum.sendKeys(mobPhoneNum);
	}
	
	public void faxNum(String faxNum) {
		this.faxNum.clear();
		this.faxNum.sendKeys(faxNum);
	}
	
	public void url(String url) {
		this.url.clear();
		this.url.sendKeys(url);
	}
	
	public void password(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}
	
	public void confirmPassword(String confirmPassword) {
		this.confirmPassword.clear();
		this.confirmPassword.sendKeys(confirmPassword);
	}
	
	public void capthcaText(String capthcaText) {
		this.capthcaText.clear();
		this.capthcaText.sendKeys(capthcaText);
	}
	
	public void saveBtn() {
		this.saveBtn.click();
	}

}
