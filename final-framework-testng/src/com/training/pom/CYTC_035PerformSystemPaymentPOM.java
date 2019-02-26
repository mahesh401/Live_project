package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions; 


public class CYTC_035PerformSystemPaymentPOM {
	private WebDriver driver; 

	public CYTC_035PerformSystemPaymentPOM (WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	// Member performing System Payment & Checking the account details
	@FindBy(xpath = "//*[@id=\"menu2\"]/span[2]")
	private WebElement AccountLink;
	
	@FindBy(xpath = "//*[@id=\"submenu2.5\"]/span[2]")
	private WebElement SysPaymentLink;
	
	@FindBy(xpath = "//*[@id=\"amount\"]")
	private WebElement AmountField;
	
	@FindBy (xpath = "//*[@id=\"description\"]")
	private WebElement DescriptionField;
	
	@FindBy (xpath = "//*[@id=\"submitButton\"]")
	private WebElement SubmitBtn1;
	
	@FindBy (xpath = "//input[@value='Submit']")
	private WebElement SubmitBtn2;
	
	@FindBy (xpath = "//*[@id=\"submenu2.0\"]/span[2]")
	private WebElement AccountInfoLink;
	
	/////////////////////////////////////
	
	public void AccountLink() {
		this.AccountLink.click();
	}
	
	public void SysPaymentLink() {
		this.SysPaymentLink.click();
	}
	
	public void AmountField(String AmountField) {
		this.AmountField.clear();
		this.AmountField.sendKeys(AmountField);
	}
	
	public void DescriptionField(String DescriptionField) {
		this.DescriptionField.sendKeys();
	}
	
	public void SubmitBtn1() {
		this.SubmitBtn1.click();
	}
	
	public void SubmitBtn2() {
		this.SubmitBtn2.click();
	}
	
	public void AccountInfoLink() {
		this.AccountInfoLink.click();
	}

}
