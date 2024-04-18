package ddt;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrelloDdt {
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		FileInputStream fis = new FileInputStream("./src/test/resource/trello_data.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Sheet1");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://trello.com/home");
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("username")).sendKeys(sheet.getRow(5).getCell(1).getStringCellValue());
		driver.findElement(By.xpath("//span[text()='Continue']")).click();
		driver.findElement(By.id("password")).sendKeys("Qwertyuiop@123");
		driver.findElement(By.xpath("//span[text()='Log in']")).click();
		driver.findElement(By.xpath("//span[text()='Create new board']")).click();
		driver.findElement(By.xpath("//input[@data-testid='create-board-title-input']")).sendKeys("Mugi");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Actions action = new Actions(driver);
		WebElement createOption = driver.findElement(By.xpath("//button[text()='Create']"));
		wait.until(ExpectedConditions.elementToBeClickable(createOption));
		createOption.click();
		WebElement firstboard = driver.findElement(By.xpath("//textarea[@name='Enter list title…']"));
		wait.until(ExpectedConditions.visibilityOf(firstboard));
		firstboard.sendKeys("Topics");
		firstboard.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//div[@class='zVAitUtsAALET4']/button[@aria-label='Workspace navigation']")).click();
		Thread.sleep(2000);
		WebElement addACardOpt = driver.findElement(By.xpath("//button[@data-testid='list-add-card-button']"));
		addACardOpt.click();
		action.pause(750).sendKeys(sheet.getRow(1).getCell(1).getStringCellValue()).sendKeys(Keys.ENTER).pause(1000).sendKeys(sheet.getRow(1).getCell(2)
		.getStringCellValue()).sendKeys(Keys.ENTER).pause(1000).sendKeys(sheet.getRow(2).getCell(1).getStringCellValue()).
		sendKeys(Keys.ENTER).pause(1000).sendKeys(sheet.getRow(2).getCell(2).getStringCellValue()).sendKeys(Keys.ENTER).pause(1000).sendKeys(sheet.getRow(3)
		.getCell(1).getStringCellValue()).sendKeys(Keys.ENTER).pause(1000).
		sendKeys(sheet.getRow(3).getCell(2).getStringCellValue()).sendKeys(Keys.ENTER).pause(1000)./*sendKeys(sheet.getRow(4).getCell(1).getStringCellValue()).sendKeys(Keys.ENTER).pause(1000).sendKeys(sheet.getRow(4).getCell(2).getStringCellValue()).sendKeys(Keys.ENTER)*/
		build().perform();	
		WebElement addAnotherList = driver.findElement(By.xpath("//button[@data-testid='list-composer-button']"));
		addAnotherList.click();
		driver.findElement(By.xpath("//textarea[@name='Enter list title…']")).sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
		driver.findElement(By.xpath("//button[text()='Add list']")).click();
		driver.findElement(By.xpath("//textarea[@name='Enter list title…']")).sendKeys(sheet.getRow(2).getCell(0).getStringCellValue());
		driver.findElement(By.xpath("//button[text()='Add list']")).click();
		driver.findElement(By.xpath("//textarea[@name='Enter list title…']")).sendKeys(sheet.getRow(3).getCell(0).getStringCellValue());
		driver.findElement(By.xpath("//button[text()='Add list']")).click();
		driver.findElement(By.xpath("//textarea[@name='Enter list title…']")).sendKeys(sheet.getRow(4).getCell(0).getStringCellValue());
		driver.findElement(By.xpath("//button[text()='Add list']")).click();
		//Card 
		WebElement joinsCard = driver.findElement(By.xpath("//a[text()='Joins']"));
		WebElement dqlCard = driver.findElement(By.xpath("//a[text()='Dql']"));
		WebElement v_vmodelCard = driver.findElement(By.xpath("//a[text()='V&V Model']"));
		WebElement smokeCard = driver.findElement(By.xpath("//a[text()='Smoke']"));
		WebElement exceptionCard = driver.findElement(By.xpath("//a[text()='Exception']"));
		WebElement OopsCard = driver.findElement(By.xpath("//a[text()='Oops']"));
//		WebElement webdriverCard = driver.findElement(By.xpath("//a[text()='WebDriver']"));
//		WebElement webelementCard = driver.findElement(By.xpath("//a[text()='WebElement']"));
		//Title
		WebElement sqlTitle = driver.findElement(By.xpath("//h2[text()='SQL']"));
		WebElement manualTitle = driver.findElement(By.xpath("//h2[text()='MANUAL']"));
		WebElement javaTitle = driver.findElement(By.xpath("//h2[text()='JAVA']"));
//		WebElement seleniumTitle = driver.findElement(By.xpath("//h2[text()='SELENIUM']"));
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(joinsCard); list.add(dqlCard); list.add(smokeCard); list.add(OopsCard);list.add(v_vmodelCard); 
		/* list.add(exceptionCard); list.add(webdriverCard); list.add(webelementCard); */
		for (Object c:list) {
			if(c.equals(joinsCard)) {
				action.dragAndDrop(joinsCard, sqlTitle).perform();
			} else if(c.equals(dqlCard)) {
				action.dragAndDrop(dqlCard, sqlTitle).perform();
			} else if(c.equals(v_vmodelCard)) {
				action.dragAndDrop(v_vmodelCard, manualTitle).perform();
			} else if(c.equals(smokeCard)) {
				action.dragAndDrop(smokeCard, manualTitle).perform();
			} else if(c.equals(exceptionCard)) {
				action.dragAndDrop(exceptionCard, javaTitle).perform();
			} else if(c.equals(OopsCard)) {
				action.dragAndDrop(OopsCard, javaTitle).perform();
/*			} else if(c.equals(webdriverCard)) {
			//	action.scrollToElement(seleniumTitle).perform();
				action.dragAndDrop(webdriverCard, seleniumTitle).build().perform();
			} else if(c.equals(webelementCard)) {
				action.scrollToElement(seleniumTitle).perform();
				action.dragAndDrop(webelementCard, seleniumTitle).perform();
*/			}
		}
		driver.findElement(By.xpath("//span[contains(@title,'Mugilan')]")).click();
		driver.findElement(By.xpath("//span[text()='Log out']")).click();
		driver.findElement(By.xpath("//span[text()='Log out']")).submit();
		driver.manage().window().minimize();
		driver.quit();
	}
}