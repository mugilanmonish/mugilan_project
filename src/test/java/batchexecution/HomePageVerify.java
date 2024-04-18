package batchexecution;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageVerify {
	WebDriver driver;
	
	@BeforeClass
	public void preCondition() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass
	public void postCondition() {
		driver.manage().window().minimize();
		driver.quit();
	}
	
	@Test
	public void homePageVerify() throws InterruptedException {
		driver.get("https://trello.com/home");
		driver.findElement(By.xpath("//div[contains(@class,'Buttonsstyles')]/a[text()='Log in']")).click();
		driver.findElement(By.id("username")).sendKeys("mugilanmonish@gmail.com");
		driver.findElement(By.xpath("//span[text()='Continue']")).submit();
		driver.findElement(By.id("password")).sendKeys("Qwertyuiop@123");
		WebElement loginButton = driver.findElement(By.xpath("//span[text()='Log in']"));
		loginButton.submit();
		Thread.sleep(2000);
		System.out.println("Home Page Title ="+driver.getTitle());
		driver.findElement(By.xpath("//span[contains(@title,'Mugilan')]")).click();
        driver.findElement(By.xpath("//span[text()='Log out']")).click();
        driver.findElement(By.xpath("//span[text()='Log out']")).submit();
        // local branch
	}
	
}
