package learntestng;

import org.testng.annotations.Test;

public class AnnotationAndArguments {
	@Test(priority = 1)
	public void login() {
		System.out.println("login");
	}
	@Test(priority = 6)
	public void logout() {
		System.out.println("logout");
	}
	@Test(priority = 2, dependsOnMethods = "login")
	public void home() {
		System.out.println("home");
	}
	@Test(priority = 4, dependsOnMethods = {"login","home","product"})
	public void addToCart() {
		System.out.println("addToCart");
	}
	@Test(priority = 3, dependsOnMethods = {"login","home"}, enabled = false)
	public void product() {
		System.out.println("product");
	}
	@Test(priority = 5, invocationCount = 4)
	public void payment() {
		System.out.println("payment");
	}
}
