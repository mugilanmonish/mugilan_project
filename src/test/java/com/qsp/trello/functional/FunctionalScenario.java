package com.qsp.trello.functional;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.qsp.trello.genericutility.BaseClass;
import com.qsp.trello.genericutility.WebDriverUtility;
import com.qsp.trello.pomrepo.TrelloBoardsPage;

public class FunctionalScenario extends BaseClass {
	public static   WebDriverUtility webDriverUtils = new WebDriverUtility();
	
	@Test (priority = 1)
	public void checkWhretherTheUserIsAbleToNavigateHelpPage() throws IOException, ParseException {
		TrelloBoardsPage trelloBoardsPage = new TrelloBoardsPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String parentWindow = driver.getWindowHandle();
		trelloBoardsPage.getAccountIcon().click();
		trelloBoardsPage.getAccount_Help().click();
		Set<String> allWids = driver.getWindowHandles();
		for (String wids : allWids) {
			 String widTitle = driver.switchTo().window(wids).getTitle();
			 if (widTitle.equals(jsonUtility.readTheDataFromJsonFile("helppagetitle"))) {
				 wait.until(ExpectedConditions.titleIs(jsonUtility.readTheDataFromJsonFile("helppagetitle")));
				 assertEquals(jsonUtility.readTheDataFromJsonFile("helppagetitle"), driver.getTitle());
				 driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		trelloBoardsPage.getAccountIcon().click();
	}
	
	@Test(priority = 2)
	public void checkWhetherTheUserIsAbleToNavigateShortutsPage() throws IOException, ParseException {
		TrelloBoardsPage trelloBoardsPage = new TrelloBoardsPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		trelloBoardsPage.getAccountIcon().click();
		trelloBoardsPage.getAccount_Shortcut().click();
		wait.until(ExpectedConditions.titleIs(jsonUtility.readTheDataFromJsonFile("shortcutspagetitle")));
		assertEquals(jsonUtility.readTheDataFromJsonFile("shortcutspagetitle"), driver.getTitle());
	}
	
	@Test(priority = 3)
	public void checkWhetherTheUserIsAbleToNavigateProfilePage() throws IOException, ParseException {
		TrelloBoardsPage trelloBoardsPage = new TrelloBoardsPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		trelloBoardsPage.getAccountIcon().click();
		trelloBoardsPage.getAccount_ProfileAndVisibility().click();
		wait.until(ExpectedConditions.titleIs(jsonUtility.readTheDataFromJsonFile("profilepagetitle")));
		assertEquals(jsonUtility.readTheDataFromJsonFile("profilepagetitle"), driver.getTitle());
	}
	
	@Test(priority = 4)
	public void checkWhetherTheUserIsAbleToNavigateCardsPage() throws IOException, ParseException {
		TrelloBoardsPage trelloBoardsPage = new TrelloBoardsPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		trelloBoardsPage.getAccountIcon().click();
		trelloBoardsPage.getAccount_Cards().click();
		wait.until(ExpectedConditions.titleIs(jsonUtility.readTheDataFromJsonFile("cardspagetitle")));
		assertEquals(jsonUtility.readTheDataFromJsonFile("cardspagetitle"), driver.getTitle());
	}
	
	@Test(priority = 5)
	public void checkWhetherTheUserIsAbleToNavigateActivityPage() throws IOException, ParseException {
		TrelloBoardsPage trelloBoardsPage = new TrelloBoardsPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		trelloBoardsPage.getAccountIcon().click();
		trelloBoardsPage.getAccount_Activity().click();
		wait.until(ExpectedConditions.titleIs(jsonUtility.readTheDataFromJsonFile("activitypagetitle")));
		assertEquals(jsonUtility.readTheDataFromJsonFile("activitypagetitle"), driver.getTitle());
	}
	
	@Test(priority = 6)
	public void checkWhetherTheUserIsAbleToNavigateSettingsPage() throws IOException, ParseException {
		TrelloBoardsPage trelloBoardsPage = new TrelloBoardsPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		trelloBoardsPage.getAccountIcon().click();
		trelloBoardsPage.getAccount_Settings().click();
		wait.until(ExpectedConditions.titleIs(jsonUtility.readTheDataFromJsonFile("settingspagetitle")));
		assertEquals(jsonUtility.readTheDataFromJsonFile("settingspagetitle"), driver.getTitle());
	}
	
	@Test(priority = 7)
	public void checkWhetherTheUserIsAbleToNavigatePricingPage() throws IOException, ParseException {
		TrelloBoardsPage trelloBoardsPage = new TrelloBoardsPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		trelloBoardsPage.getInformation().click();
		trelloBoardsPage.getInformation_Pricing().click();
		String parentWindow = driver.getWindowHandle();
		Set<String> allWids = driver.getWindowHandles();
		for (String wids : allWids) {
			 String widTitle = driver.switchTo().window(wids).getTitle();
			 if (widTitle.equals(jsonUtility.readTheDataFromJsonFile("pricingpagetitle"))) {
				 wait.until(ExpectedConditions.titleIs(jsonUtility.readTheDataFromJsonFile("pricingpagetitle")));
				 assertEquals(jsonUtility.readTheDataFromJsonFile("pricingpagetitle"), driver.getTitle());
				 driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
	}
	
	@Test(priority = 8)
	public void checkWhetherTheUserIsAbleToNavigateAppsPage() throws IOException, ParseException {
		TrelloBoardsPage trelloBoardsPage = new TrelloBoardsPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		trelloBoardsPage.getInformation().click();
		trelloBoardsPage.getInformation_Apps().click();
		String parentWindow = driver.getWindowHandle();
		Set<String> allWids = driver.getWindowHandles();
		for (String wids : allWids) {
			 String widTitle = driver.switchTo().window(wids).getTitle();
			 if (widTitle.equals(jsonUtility.readTheDataFromJsonFile("appspagetitle"))) {
				 wait.until(ExpectedConditions.titleIs(jsonUtility.readTheDataFromJsonFile("appspagetitle")));
				 assertEquals(jsonUtility.readTheDataFromJsonFile("appspagetitle"), driver.getTitle());
				 driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
	}
	
	@Test(priority = 9)
	public void checkWhetherTheUserIsAbleToNavigateBlogPage() throws IOException, ParseException {
		TrelloBoardsPage trelloBoardsPage = new TrelloBoardsPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		trelloBoardsPage.getInformation().click();
		trelloBoardsPage.getInformation_Blog().click();
		String parentWindow = driver.getWindowHandle();
		Set<String> allWids = driver.getWindowHandles();
		for (String wids : allWids) {
			 String widTitle = driver.switchTo().window(wids).getTitle();
			 if (widTitle.equals(jsonUtility.readTheDataFromJsonFile("blogpagetitle"))) {
				 wait.until(ExpectedConditions.titleIs(jsonUtility.readTheDataFromJsonFile("blogpagetitle")));
				 assertEquals(jsonUtility.readTheDataFromJsonFile("blogpagetitle"), driver.getTitle());
				 driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
	}
}