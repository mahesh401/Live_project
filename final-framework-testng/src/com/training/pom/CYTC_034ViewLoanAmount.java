package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions; 


public class CYTC_034ViewLoanAmount {
	private WebDriver driver; 

	public CYTC_034ViewLoanAmount (WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	// Member viewing the loan balance
	@FindBy(xpath = "//*[@id=\"menu2\"]/span[2]")
	private WebElement AccountLink;

	@FindBy(xpath = "//*[@id=\"submenu2.3\"]/span[2]")
	private WebElement LoanLink;

	@FindBy(xpath = "//*[@id=\"tdContents\"]/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td[4]/img")
	private WebElement LoanViewIcon;

	@FindBy(xpath = "//input[@id='amountText']")
	private WebElement AmountField;

	@FindBy (xpath = "//*[@id=\"repayForm\"]/table/tbody/tr[3]/td/input")
	private WebElement RepayBtn;

	@FindBy (xpath = "//*[@id=\"menu6\"]/span[2]")
	private WebElement LogoutBtn;

	//Admin logged in to check the loan status
	@FindBy (xpath = "//*[@id=\"memberUsername\"]")
	private WebElement MemberLogin;


	@FindBy (xpath = "//tbody//tr[8]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[1]//td[2]//input[1]")
	private WebElement ViewLoans;

	/////////////////////////////////////

	public void AccountLink() {
		this.AccountLink.click();
	}

	public void LoanLink() {
		this.LoanLink.click();
	}

	public void LoanViewIcon() {
		this.LoanViewIcon.click();
	}

	public void AmountField(String AmountField) {
		this.AmountField.clear();
		this.AmountField.sendKeys(AmountField);
	}

	public void RepayBtn() {
		this.RepayBtn.click();
	}

	public void LogoutBtn() {
		this.LogoutBtn.click();
	}

	public void MemberLogin(String MemberLogin) {
		this.MemberLogin.clear();
		this.MemberLogin.sendKeys(MemberLogin);
	}

	public void ViewLoans() {
		this.ViewLoans.click();
	}


}
