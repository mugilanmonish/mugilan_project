package learntestng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class ReadTheDataFromXmlFile {
	WebDriver driver;
	@Test
	@Parameters({ "browser", "url", "username", "password"}) 
	public void loginToVtiger( String browser, String url, String username, String password) {
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if(browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);
		WebElement usernameTf = driver.findElement(By.id("username"));
		usernameTf.clear();
		usernameTf.sendKeys(username);
		WebElement passwordTf = driver.findElement(By.id("password"));
		passwordTf.clear();
		passwordTf.sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Sign in']")).submit();
		driver.manage().window().minimize();
		driver.quit();
	}
}
