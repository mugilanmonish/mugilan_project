package com.qsp.trello.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloTemplatesPage {
	WebDriver driver;
	
	public TrelloTemplatesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getFindTemplateSearchBar() {
		return findTemplateSearchBar;
	}

	public WebElement getBusinessLink() {
		return businessLink;
	}

	public WebElement getDesignLink() {
		return designLink;
	}

	public WebElement getEducationLink() {
		return educationLink;
	}
	
	@FindBy(xpath = "//div[text()='Find template']")
	private WebElement findTemplateSearchBar;
	
	@FindBy(xpath = "//li/a/span[text()='Business']")
	private WebElement businessLink;

	@FindBy(xpath = "//li/a/span[text()='Design']")
	private WebElement designLink;
	
	@FindBy(xpath = "//li/a/span[text()='Education']")
	private WebElement educationLink;
	
}