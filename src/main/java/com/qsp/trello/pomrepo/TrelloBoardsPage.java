package com.qsp.trello.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloBoardsPage {
	WebDriver driver;
	
	public TrelloBoardsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getAccountIcon() {
		return accountIcon;
	}

	public WebElement getLogoutOption() {
		return logoutOption;
	}

	public WebElement getSearchBar() {
		return searchBar;
	}

	public WebElement getTemplatesLink() {
		return templatesLink;
	}

	public WebElement getInformation() {
		return information;
	}

	public WebElement getWorkspaces() {
		return workspaces;
	}

	public WebElement getWorkspaces_TrelloWorkspace() {
		return workspaces_TrelloWorkspace;
	}

	public WebElement getRecent() {
		return recent;
	}

	public WebElement getCreateNewBoard() {
		return createNewBoard;
	}

	public WebElement getAddIcon() {
		return addIcon;
	}

	public WebElement getCreateBoard() {
		return createBoard;
	}

	public WebElement getStartWithtemplate() {
		return startWithtemplate;
	}

	public WebElement getCreateWorkspace() {
		return createWorkspace;
	}

	public WebElement getAccount_ProfileAndVisibility() {
		return account_ProfileAndVisibility;
	}

	public WebElement getAccount_Activity() {
		return account_Activity;
	}

	public WebElement getAccount_Cards() {
		return account_Cards;
	}

	public WebElement getAccount_Settings() {
		return account_Settings;
	}

	public WebElement getAccount_Help() {
		return account_Help;
	}

	public WebElement getAccount_Theme() {
		return account_Theme;
	}

	public WebElement getLightTheme() {
		return lightTheme;
	}

	public WebElement getDarkTheme() {
		return darkTheme;
	}

	public WebElement getInformation_Pricing() {
		return information_Pricing;
	}

	public WebElement getInformation_Apps() {
		return information_Apps;
	}

	public WebElement getInformation_Blog() {
		return information_Blog;
	}

	public WebElement getInformation_Privacy() {
		return information_Privacy;
	}

	public WebElement getInformation_Developers() {
		return information_Developers;
	}

	public WebElement getInformation_Legal() {
		return information_Legal;
	}

	public WebElement getInformation_Attributions() {
		return information_Attributions;
	}

	public WebElement getInformation_More() {
		return information_More;
	}

	public WebElement getBoardTitle() {
		return boardTitle;
	}

	public WebElement getCreateOption() {
		return createOption;
	}
	
	public WebElement getAccount_Shortcut() {
		return account_Shortcut;
	}
	
	@FindBy(xpath = "//span[contains(@title,'Mugilan')]")
	private WebElement accountIcon;
	
	@FindBy(xpath = "//span[text()='Log out']")
	private WebElement logoutOption;
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	private WebElement searchBar;
	
	@FindBy(xpath = "//a[@class='oTmCsFlPhDLGz2']")
	private WebElement templatesLink;
	
	@FindBy(xpath = "//span[@data-testid='HelpIcon']")
	private WebElement information;
	
	@FindBy(xpath = "//span[text()='Workspaces']")
	private WebElement workspaces;
	
	@FindBy(xpath = "//p[text()='Trello Workspace']")
	private WebElement workspaces_TrelloWorkspace;
	
	@FindBy(xpath = "//span[text()='Recent']")
	private WebElement recent;
	
	@FindBy(xpath = "//span[text()='Create new board']")
	private WebElement createNewBoard;
	
	@FindBy(xpath = "//span[@data-testid='AddIcon']")
	private WebElement addIcon;
	
	@FindBy(xpath = "//button[@data-testid='header-create-board-button']")
	private WebElement createBoard;
	
	@FindBy(xpath = "//button[@data-testid='header-create-board-from-template-button']")
	private WebElement startWithtemplate;
	
	@FindBy(xpath = "//button[@data-testid='header-create-team-button']")
	private WebElement createWorkspace;
	
	@FindBy(xpath = "//span[text()='Profile and visibility']")
	private WebElement account_ProfileAndVisibility;
	
	@FindBy(xpath = "//span[text()='Activity']")
	private WebElement account_Activity;
	
	@FindBy(xpath = "//span[text()='Cards']")
	private WebElement account_Cards;
	
	@FindBy(xpath = "//a[@data-testid='account-menu-settings']//span[text()='Settings']")
	private WebElement account_Settings;
	
	@FindBy(xpath = "//span[text()='Help']")
	private WebElement account_Help;
	
	@FindBy(xpath = "//span[text()='Theme']")
	private WebElement account_Theme;
	
	@FindBy(xpath = "//div[text()='Light']")
	private WebElement lightTheme;
	
	@FindBy(xpath = "//div[text()='Dark']")
	private WebElement darkTheme; 
	
	@FindBy(linkText = "Pricing")
	private WebElement information_Pricing;
	
	@FindBy(linkText = "Apps")
	private WebElement information_Apps;
	
	@FindBy(linkText = "Blog")
	private WebElement information_Blog;
	
	@FindBy(linkText = "Privacy")
	private WebElement information_Privacy;
	
	@FindBy(linkText = "Developers")
	private WebElement information_Developers;
	
	@FindBy(linkText = "Legal")
	private WebElement information_Legal;
	
	@FindBy(linkText = "Attributions")
	private WebElement information_Attributions;
	
	@FindBy(xpath = "//button[contains(text(),'More')]")
	private WebElement information_More;

	@FindBy(xpath = "//input[@data-testid='create-board-title-input']")
	private WebElement boardTitle;
	
	@FindBy(xpath = "//button[text()='Create']")
	private WebElement createOption;
	
	@FindBy(xpath = "//span[text()='Shortcuts']")
	private WebElement account_Shortcut;

}
