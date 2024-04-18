package com.qsp.trello.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloProfilePage {
	WebDriver driver;
	
	public TrelloProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "bio")
	private WebElement bioTextField;
	
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveButton;

	public WebElement getBioTextField() {
		return bioTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
}