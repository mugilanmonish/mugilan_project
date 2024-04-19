package Check;

import java.io.IOException;
import java.time.Duration;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.qsp.trello.genericutility.BaseClass;
import com.qsp.trello.genericutility.JsonUtility;
import com.qsp.trello.genericutility.WebDriverUtility;
import com.qsp.trello.pomrepo.TrelloTemplatesPage;

public class Demo extends BaseClass{
	public static   WebDriverUtility webDriverUtils = new WebDriverUtility();
	
	@Test 
	public void createBoard() throws IOException, ParseException, InterruptedException {
		WebElement createNewBoardoption = driver.findElement(By.xpath("//span[text()='Create new board']"));
		createNewBoardoption.click();
		WebElement boardTitle = driver.findElement(By.xpath("//input[contains(@data-testid,'create')]"));
		boardTitle.sendKeys(jsonUtility.readTheDataFromJsonFile("boardtitle"));
		WebElement createOption = driver.findElement(By.xpath("//button[text()='Create']"));
		Thread.sleep(1500);
		createOption.click();
		//dddddddddddddddddd
	}
	
	@Test
	public void helpPage() throws InterruptedException {
		String mainWindowId = driver.getWindowHandle();
		driver.findElement(By.xpath("//span[contains(@title,'Mugilan')]")).click();
		driver.findElement(By.xpath("//span[text()='Help']")).click();
		Thread.sleep(1500);
		System.out.println("Page Title "+ driver.getTitle());
		driver.switchTo().window(mainWindowId);
		driver.findElement(By.xpath("//span[contains(@title,'Mugilan')]")).click();
	}
}