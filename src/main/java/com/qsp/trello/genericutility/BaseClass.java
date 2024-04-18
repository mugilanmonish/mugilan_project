package com.qsp.trello.genericutility;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.qsp.trello.pomrepo.TrelloBoardsPage;
import com.qsp.trello.pomrepo.TrelloHomePage;
import com.qsp.trello.pomrepo.TrelloLoginPage;
import com.qsp.trello.pomrepo.TrelloLogoutPage;
import com.qsp.trello.pomrepo.TrelloTemplatesPage;

public class BaseClass {
	public static WebDriver driver;
	public static WebDriverUtility webdriverUtils = new WebDriverUtility();
	public FileUtility fileutils = new FileUtility();
	public JsonUtility jsonUtility = new JsonUtility();
	
	@BeforeClass
	public void preCondition() throws IOException {
		String browser = fileutils.readtheDataFromPropertyFile("browser");
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		webdriverUtils.implicitWait(driver);
		driver.get(fileutils.readtheDataFromPropertyFile("url"));
	}
	
	@AfterClass
	public void postCondition() {
		driver.manage().window().minimize();
		driver.quit();
	}
	
	@BeforeMethod
	public void login() throws IOException, ParseException {
		TrelloHomePage homePage = new TrelloHomePage(driver);
		TrelloLoginPage loginPage = new TrelloLoginPage(driver);
		homePage.getLoginLink().click();
		loginPage.getUsernameTextField().sendKeys(jsonUtility.readTheDataFromJsonFile("username"));
		loginPage.getContinueButton().submit();
		loginPage.getPasswordTextField().sendKeys(jsonUtility.readTheDataFromJsonFile("password"));
		loginPage.getLoginButton().submit();
	}
	
	@AfterMethod
	public void logout() {
		TrelloBoardsPage trelloBoardsPage = new TrelloBoardsPage(driver);
		TrelloLogoutPage trelloLogoutPage = new TrelloLogoutPage(driver);
		trelloBoardsPage.getAccountIcon().click();
		trelloBoardsPage.getLogoutOption().click();
		trelloLogoutPage.getLogoutButton().submit();
	}
}