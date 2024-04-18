package com.qsp.trello.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloCreateWorkspace {
	WebDriver driver;
	
	public TrelloCreateWorkspace(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getWorkspaceName() {
		return workspaceName;
	}

	public WebElement getWorkspaceTypeDropdown() {
		return workspaceTypeDropdown;
	}

	public WebElement getWorkspaceDesignationTextField() {
		return workspaceDesignationTextField;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}

	@FindBy(xpath = "//input[@placeholder=\"Taco's Co.\"]")
	private WebElement workspaceName;
	
	@FindBy(xpath = "//div[text()='Choose…']")
	private WebElement workspaceTypeDropdown;
	
	@FindBy(xpath = "//textarea[contains(@placeholder,'Our')]")
	private WebElement workspaceDesignationTextField;
	
	@FindBy(xpath = "//button[text()='Continue']")
	private WebElement continueButton;
	
}
