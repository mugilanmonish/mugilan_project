package batchexecution;

import org.testng.Reporter;
import org.testng.annotations.Test;

@Test
public class HelpPage {
	public void print() {
		System.out.println("Hi");
		System.out.println("Bye");
		Reporter.log("Hi---------------------------Bye");
	}
}
