package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions; 


public class CYTC_033AddLoanDetailsPOM {
	private WebDriver driver; 

	public CYTC_033AddLoanDetailsPOM (WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	// Adding a loan to a member
	@FindBy(id = "memberUsername")
	private WebElement memberLogin;

	@FindBy(xpath = "//*[@id=\"tdContents\"]/table[1]/tbody/tr[2]/td/table/tbody/tr[8]/td/fieldset/table/tbody/tr[1]/td[4]/input")
	private WebElement GrantLoanBtn;

	@FindBy(xpath = "//input[@name='loan(amount)']")
	private WebElement LoanAmount;

	@FindBy(xpath = "//textarea[@id='description']")
	private WebElement descriptionField;

	@FindBy (xpath = "//*[@id=\"tdContents\"]/form/table[1]/tbody/tr[2]/td/table/tbody/tr[17]/td/input")
	private WebElement SubmitBtn1;

	@FindBy (xpath = "//*[@id=\"tdContents\"]/form/table[1]/tbody/tr[2]/td/table/tbody/tr[7]/td/input")
	private WebElement SubmitBtn2;

	// verifying the added loan details for the member
	@FindBy (xpath = "//*[@id=\"tdContents\"]/table[1]/tbody/tr[2]/td/table/tbody/tr[8]/td/fieldset/table/tbody/tr[1]/td[2]/input")
	private WebElement ViewLoansBtn;

	// Adding a loan to a member
	public void memberLogin(String memberLogin) {
		this.memberLogin.sendKeys(memberLogin);
	}

	public void GrantLoanBtn() {
		this.GrantLoanBtn.click();
	}

	public void LoanAmount(String LoanAmount) {
		this.LoanAmount.sendKeys(LoanAmount);
	}

	public void descriptionField(String descriptionField) {
		this.descriptionField.sendKeys(descriptionField);
	}

	public void SubmitBtn1() {
		this.SubmitBtn1.click();
	}

	public void SubmitBtn2() {
		this.SubmitBtn2.click();
	}

	public void ViewLoansBtn() {
		this.ViewLoansBtn.click();
	}	
}
