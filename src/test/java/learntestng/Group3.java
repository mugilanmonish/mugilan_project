package learntestng;

import org.testng.annotations.Test;

public class Group3 {
	@Test(groups="functional")
	public void product() {
		System.out.println("product");
	}
	
	@Test (groups = "integration")
	public void payment() {
		System.out.println("payment");
	}
	
	@Test (groups = {"smoke", "integration"})
	public void signUp() {
		System.out.println("signUp");
	}
}
