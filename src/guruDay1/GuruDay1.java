package guruDay1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GuruDay1 {
	
	
	@Test
	public void login() {
		System.out.println("Hello");
		System.setProperty("webdriver.chrome.driver", "E:/Selenium/chromedriver_win32/chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		driver.get("http://www.demo.guru99.com/V4/");
		driver.findElement(By.name("uid")).sendKeys("mngr336");
		driver.findElement(By.name("password")).sendKeys("hEjujAp");	
		driver.findElement(By.name("btnLogin")).click();
	}

}
