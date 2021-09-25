package TestNGCode;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnMethods {

	@Test
	public void test1() {
		System.out.println("inside test1");
		Assert.assertEquals("hello", "hello1");
	}

	@Test(dependsOnMethods = "test1")
	public void test2() {
		System.out.println("inside test2");
	}
}
