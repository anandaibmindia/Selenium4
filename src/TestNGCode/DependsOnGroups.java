package TestNGCode;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnGroups {
	
	
	
	@Test (groups= {"basic"})
	public void login(){
	System.out.println("inside basic login");
	Assert.assertEquals("hello", "hello1");
	}

	@Test (dependsOnGroups= {"basic"})
	public void afterlogin(){
	System.out.println("inside after login");
	}

	@Test (groups= { "functional" })
	public void payment (){
	System.out.println("inside functional payment");
	}
	}
	