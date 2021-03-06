package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CYTC_002AdminLoginTestPOM {
	private WebDriver driver; 

	public CYTC_002AdminLoginTestPOM (WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "cyclosUsername")
	private WebElement loginName;
	
	@FindBy(id = "cyclosPassword")
	private WebElement password; 
	
	@FindBy(xpath = "//*[@id=\"cyclosLogin\"]/table/tbody/tr[3]/td/input")
	private WebElement submitbtn;
	
	//For Admin logout
	@FindBy (xpath = "//span[contains(text(),'Logout')]")
	private WebElement LogOut;
	
	
	
	public void loginName(String loginName) {
		this.loginName.clear();
		this.loginName.sendKeys(loginName);
	}
	
	public void password(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}
	
	public void submitBtn() {
		this.submitbtn.click();
	}
	
	public void LogOut() {
		this.LogOut.click();
	}
	
}
