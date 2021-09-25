package guru99LoginWriteToExcelPoi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Day1POMLogin {
	
	
	WebDriver driver;
	
	public Day1POMLogin(WebDriver dr) {
		this.driver=dr;
	}

	
	By  Username_field= By.name("uid");
	By  Password_field= By.name("password");
	By  Login_button= By.name("btnLogin");
	By  Reset_button= By.name("uid");
	
	
	
	public void typeUsername(String uname) {
		
		driver.findElement(Username_field).sendKeys(uname);
		
		
	}
	
	
	public void typePassowrd(String pword) {
		
		driver.findElement(Password_field).sendKeys(pword);
		
		
	}
	public void clickLogin() {
	
	driver.findElement(Login_button).click();
	
	
	}
	public void clickReset() {
	
	driver.findElement(Username_field).clear();
	driver.findElement(Password_field).clear();
	
	
	}
	
	
}
