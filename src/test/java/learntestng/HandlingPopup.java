package learntestng;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class HandlingPopup {
	WebDriver driver;

	@BeforeClass
	public void preCondition() {
		ChromeOptions opts = new ChromeOptions();
		opts.addArguments("--disable-notifications");
		driver = new ChromeDriver(opts);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterClass
	public void postCondition() {
		driver.manage().window().minimize();
		driver.quit();
	}

	@Test(dependsOnMethods = "Popup_Confirmation")
	public void Popup_Alert() {
		driver.get("file:///D:/SDET%20FullStack/Automation%20Testing/DropDown%20File/Popup_alert.html");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}

	@Test
	public void Popup_Confirmation() {
		driver.get("file:///D:/SDET%20FullStack/Automation%20Testing/DropDown%20File/Popup_Confirmation.html");
		String mainWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		driver.switchTo().alert().accept();
		driver.switchTo().window(mainWindow);
		String okConfirmation = driver.findElement(By.id("demo")).getText();
		System.out.println("After clicking ok : "+ okConfirmation);
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		driver.switchTo().alert().dismiss();
		//		driver.switchTo().window(mainWindow);
		String cancelConfirmation = driver.findElement(By.id("demo")).getText();
		System.out.println("After clicking cancel : "+ cancelConfirmation);
	}

	@Test
	public void Popup_Prompt() throws InterruptedException {
		driver.get("file:///D:/SDET%20FullStack/Automation%20Testing/DropDown%20File/Popup_prompt.html");
		driver.findElement(By.xpath("//button[text()=' Click Me button ']")).click();
	//		System.out.println("Prompt popup text : "+driver.switchTo().alert().getText());
		Thread.sleep(2000);
		driver.switchTo().alert().sendKeys("Hello");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();	
	}

	@Test
	public void Child_Popup() throws InterruptedException {
		driver.get("https://demoapps.qspiders.com/ui/browser?sublist=0");
		String mainWindow = driver.getWindowHandle();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Open in new window']")).click();
		Set<String> allWinds = driver.getWindowHandles();
		System.out.println(allWinds);
		for (String wid : allWinds) {
			String actualUrl = driver.switchTo().window(wid).getCurrentUrl();
			if (actualUrl.equals("https://demoapps.qspiders.com/ui/browser/SignUpPage")) {
				driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
				driver.close();
				driver.switchTo().window(mainWindow);
				System.out.println(driver.getTitle());
			}
		}
	}
	@Test
	public void Hidden_Popup() {
		driver.get("https://www.flipkart.com/");
		driver.navigate().refresh();
		Actions actions = new Actions(driver);
		actions.click();
		driver.navigate().refresh();
		WebElement mobileNoTextField = driver.findElement(By.xpath("//form/div/input[@type='text']"));
		mobileNoTextField.sendKeys("7708084971");
	}

	@Test
	public void Notification_Popup() {
		driver.get("https://www.justdial.com/");
	}

	@Test
	public void fileUpload() {
		driver.get("https://demo.guru99.com/test/upload/");
		WebElement chooseFile = driver.findElement(By.id("uploadfile_0"));
		chooseFile.sendKeys("C:\\Users\\Mugilan\\Desktop\\file_upload.txt");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("submitbutton")).click();
	}

	@Test
	public void fileDownload() throws AWTException {
		driver.get("https://www.selenium.dev/downloads/");
		driver.findElement(By.xpath("//a[text()='4.18.1']")).sendKeys(Keys.ENTER);
		driver.get("chrome://downloads/");
		WebElement shadowHost01 = driver.findElement(By.tagName("downloads-manager"));
		SearchContext shadowRoot01 = shadowHost01.getShadowRoot();
		WebElement shadowHost2 = shadowRoot01.findElement(By.id("frb0"));
		SearchContext shadowRoot02 = shadowHost2.getShadowRoot();
		shadowRoot02.findElement(By.cssSelector("cr-button[focus-type='save']")).click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	@Test
	public void HandllingShadow() {
		driver.get("https://demoapps.qspiders.com/ui/shadow");
		WebElement shadowHost01 = driver.findElement(By.xpath("//div[@class='my-3']"));
		SearchContext shadowRoot01 = shadowHost01.getShadowRoot();
		WebElement usernameTf = shadowRoot01.findElement(By.cssSelector("input[placeholder='Enter your username']"));
		usernameTf.sendKeys("abc@gmail.com");
		WebElement shadowHost02 = driver.findElement(By.xpath("(//div[@class='my-3'])[2]"));
		SearchContext shadowRoot02 = shadowHost02.getShadowRoot();
		WebElement passwordTf = shadowRoot02.findElement(By.cssSelector("input[placeholder='Enter your password']"));
		passwordTf.sendKeys("abc");
		driver.findElement(By.xpath("//button[text()='Login']")).submit();
	}	
      
}