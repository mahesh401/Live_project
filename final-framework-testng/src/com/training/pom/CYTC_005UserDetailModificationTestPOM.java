package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CYTC_005UserDetailModificationTestPOM {
	private WebDriver driver; 

	public CYTC_005UserDetailModificationTestPOM (WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"tdContents\"]/table[1]/tbody/tr[2]/td/table/tbody/tr/td[1]/a")
	private WebElement myProfile;
	
	@FindBy(id = "modifyButton")
	private WebElement modifyButton;
	
	@FindBy(xpath = "//*[@id=\"tdContents\"]/form/table/tbody/tr[2]/td/table/tbody/tr[7]/td[2]/span/input[2]")
	private WebElement addressField;
	
	@FindBy(id="saveButton")
	private WebElement saveButton;
	
	public void myProfile() {
		this.myProfile.click();
	}
	
	public void modifyButton() {
		this.modifyButton.click();
	}
	
	public void addressField(String addressField) {
		this.addressField.clear();
		this.addressField.sendKeys(addressField);
	}
	
	public void saveButton() {
		this.saveButton.click();
	}
	
}
