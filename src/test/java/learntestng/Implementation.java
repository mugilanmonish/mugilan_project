package learntestng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Implementation {
	WebDriver driver;
	
	@BeforeMethod
	public void preCondition() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void postCondition() {
		driver.manage().window().minimize();
		driver.quit();
	}
	
	@Test (priority = 1)
	public void loginToVtiger() {
		driver.get("https://demo.vtiger.com/vtigercrm/");
		WebElement usernameTf = driver.findElement(By.id("username"));
		usernameTf.clear();
		usernameTf.sendKeys("admin");
		WebElement passwordTf = driver.findElement(By.id("password"));
		passwordTf.clear();
		passwordTf.sendKeys("admin");
		driver.findElement(By.xpath("//button[text()='Sign in']")).submit();
	}
	
	@Test (priority = 2)
	public void loginToFacebook() {
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("123456");
		driver.findElement(By.name("login")).submit();
	}
}
