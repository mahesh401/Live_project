package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions; 


public class CYTC_031AddAdvertisementAndVerifyPOM {
	private WebDriver driver; 

	public CYTC_031AddAdvertisementAndVerifyPOM (WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	// Adding the advertisement to a member
	@FindBy(id = "memberUsername")
	private WebElement memberLogin;

	@FindBy(xpath = "//tbody//tr[4]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[1]//td[2]//input[1]")
	private WebElement ManageAdvSubmitBtn;

	@FindBy(xpath = "//input[@id='newButton']")
	private WebElement AddNewAdvSubmitBtn;

	@FindBy(name ="ad(title)")
	private WebElement AdTitleField;

	@FindBy(name = "ad(category)")
	private WebElement AddCategoryField;

	@FindBy(name = "ad(price)")
	private WebElement AddPriceField;

	@FindBy (name = "ad(permanent)")
	private WebElement AddPermament;

	@FindBy (xpath = "//iframe[@title='Rich text editor, descriptionText']")
	private WebElement Description;

	@FindBy(xpath = "//*[@id=\"tdContents\"]/form/table[1]/tbody/tr[2]/td/table/tbody/tr[13]/td")
	private WebElement mainBody;

	@FindBy (xpath = "//input[@id='saveButton']")
	private WebElement SaveBtn;

	//Verifying the advertisement added for the member

	@FindBy (xpath = "//span[contains(text(),'Personal')]")
	private WebElement Personallink;

	@FindBy(xpath = "//span[contains(text(),'Advertisements')]")
	private WebElement AdvtLink;

	@FindBy(xpath = "//div[@class='productTitle']")
	private WebElement clickAdvt;


	//Adding the advt to the member
	public void memberLogin(String memberLogin) {
		this.memberLogin.sendKeys(memberLogin);
	}

	public void ManageAdvSubmitBtn() {
		this.ManageAdvSubmitBtn.click();
	}

	public void AddNewAdvSubmitBtn() {
		this.AddNewAdvSubmitBtn.click();
	}

	public void AdTitleField(String AdTitleField) {
		this.AdTitleField.sendKeys(AdTitleField);
	}

	public void AddCategoryField() {
		this.AddCategoryField.click();
	}

	public void AddPriceField(String AddPriceField) {
		this.AddPriceField.sendKeys(AddPriceField);
	}

	public void AddPermament() {
		this.AddPermament.click();
	}

	public void Description(String Description) {
		this.Description.sendKeys(Description);
	}

	public void mainBody() {
		this.mainBody.click();
	}

	public void SaveBtn() {
		this.SaveBtn.click();
	}

	// verifying the added advt for the member
	public void Personallink() {
		this.Personallink.click();
	}

	public void AdvtLink() {
		this.AdvtLink.click();
	}

	public void clickAdvt() {
		this.clickAdvt.click();
	}





}
