package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions; 


public class CYTC_032AddPaymentSystemPOM {
	private WebDriver driver; 

	public CYTC_032AddPaymentSystemPOM (WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	// Adding the Payment System to a member
	@FindBy(id = "memberUsername")
	private WebElement memberLogin;

	@FindBy(xpath = "//*[@id=\"tdContents\"]/table[1]/tbody/tr[2]/td/table/tbody/tr[5]/td/fieldset/table/tbody/tr[2]/td[2]/input")
	private WebElement PaySystemSubmitBtn;

	@FindBy(id = "amount")
	private WebElement amount;

	@FindBy(name = "type")
	private WebElement type;

	@FindBy(name = "description")
	private WebElement descriptionField;

	@FindBy (xpath = "//input[@id='submitButton']")
	private WebElement SubmitBtn1;

	@FindBy (xpath = "//input[@value='Submit']")
	private WebElement SubmitBtn2;

	//Verifying the payment system added for the member

	@FindBy (xpath = "//span[@class='menuText'][contains(text(),'Account')]")
	private WebElement AccountLink;

	@FindBy(xpath = "//span[contains(text(),'Account Information')]")
	private WebElement AccInfoLink;

	@FindBy(xpath = "//*[@id=\"tdContents\"]/table[1]/tbody/tr[3]/td/table/tbody/tr[2]/td[2]")
	private WebElement DebitCreditInfo;


	//Adding the Payment System to the member
	public void memberLogin(String memberLogin) {
		this.memberLogin.sendKeys(memberLogin);
	}

	public void PaySystemSubmitBtn() {
		this.PaySystemSubmitBtn.click();
	}

	public void amount(String amount) {
		this.amount.sendKeys(amount);
	}

	public void type() {
		this.type.click();
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

	// verifying the added payment system for the member
	public void AccountLink() {
		this.AccountLink.click();
	}

	public void AccInfoLink() {
		this.AccInfoLink.click();
	}		

}
