package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CYTC_003AdminAccessToEditRegisteredUserPOM {
	private WebDriver driver; 

	public CYTC_003AdminAccessToEditRegisteredUserPOM (WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "memberUsername")
	private WebElement memberUsername;
	
	@FindBy(xpath = "//*[@id=\"tdContents\"]/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td/fieldset/table/tbody/tr[1]/td[4]/input")
	private WebElement submitBtn2;
	
	@FindBy(xpath = "//*[@id=\"tdContents\"]/form/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/select")
	private WebElement newGrp;
	
	@FindBy(xpath = "//*[@id=\"tdContents\"]/form/table[1]/tbody/tr[2]/td/table/tbody/tr[4]/td/input")
	private WebElement submitBtn3;
	
	@FindBy(id = "comments")
	private WebElement comments;
	

	public void memberUsername(String memberUsername) {
		this.memberUsername.clear();
		this.memberUsername.sendKeys(memberUsername);
	}
	
	public void submitBtn2() {
		this.submitBtn2.click();
	}
	
	public void newGrp() {
		this.newGrp.click();
	}
	
	public void comments(String comments) {
		this.comments.sendKeys(comments);
	}
	
	public void submitBtn3() {
		this.submitBtn3.click();
	}
	
}
