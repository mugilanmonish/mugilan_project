package ddt;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDrivenThroughJson {
	public static void main(String[] args) throws IOException, ParseException {
		JSONParser parser = new JSONParser();	//instance creation to parse json string
		FileReader reader = new FileReader("./src/test/resource/testdata.json"); //access input file
		JSONObject jsonObject = (JSONObject) parser.parse(reader); //reading the parsed file and casting object to JSONObject
		String username = (String) jsonObject.get("username"); // geting the value as JSONOject and casting to string
		String password = (String) jsonObject.get("password"); // geting the value as JSONOject and casting to string
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);		
	}
}
