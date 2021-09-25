package TestNGCode;
import org.testng.annotations.Test;

public class TestNGGrouping {
	
	
	
	
	


	@Test (groups= {"basic", "functional" })
	public void login(){
	System.out.println("inside login");
	}

	@Test (groups= { "functional" })
	public void payment (){
	System.out.println("inside payment");
	}
}




