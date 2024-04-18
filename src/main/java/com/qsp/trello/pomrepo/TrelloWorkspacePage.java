package com.qsp.trello.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloWorkspacePage {
	WebDriver driver;
	
	public TrelloWorkspacePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getWorkspaceEditIcon() {
		return workspaceEditIcon;
	}

	public WebElement getNameTextField() {
		return nameTextField;
	}

	public WebElement getWebsiteTextField() {
		return websiteTextField;
	}

	public WebElement getDescriptionTextField() {
		return descriptionTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	public WebElement getThreeDotIcon() {
		return threeDotIcon;
	}

	public WebElement getCloseBoardOption() {
		return closeBoardOption;
	}

	public WebElement getCloseOption() {
		return closeOption;
	}

	public WebElement getPermanentlyDeleteBoard() {
		return permanentlyDeleteBoard;
	}

	@FindBy(xpath = "//span[@data-testid='EditIcon']")
	private WebElement workspaceEditIcon;
	
	@FindBy(id = "displayName")
	private WebElement nameTextField;
	
	@FindBy(id = "website")
	private WebElement websiteTextField;
	
	@FindBy(id = "desc")
	private WebElement descriptionTextField;
	
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveButton;
	
	@FindBy(xpath = "//a[@title='My First Board']/..//span[@data-testid='OverflowMenuHorizontalIcon']")
	private WebElement threeDotIcon;

	@FindBy(xpath = "//span[text()='Close board']")
	private WebElement closeBoardOption;
	
	@FindBy(xpath = "//button[text()='Close']")
	private WebElement closeOption;
	
	@FindBy(xpath = "/button[text()='Permanently delete board']")
	private WebElement permanentlyDeleteBoard;
	
}
