package Check;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Scrolling {
	
	@Test
	public void ScrollByAndScrollTo() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.wikipedia.org/");
		Actions action = new Actions(driver);
		action.sendKeys(driver.switchTo().activeElement()).sendKeys("India").sendKeys(Keys.ENTER).build().perform();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,7000)");
		Thread.sleep(2000);
		jse.executeScript("window.scrollTo(0,-7000)");
	}
}
