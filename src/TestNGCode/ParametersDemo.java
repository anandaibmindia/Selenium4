package TestNGCode;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersDemo {

	@Parameters({ "email", "password" })
	@Test
	public void login(String name, String password) {
		System.out.println(" login details :" + name + " and " + password);
	}
}
