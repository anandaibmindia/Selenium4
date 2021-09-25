package windowHanlding;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandlingMultipleWwindows {
	
	
	
	
	@Test
	public void HandlingWindows() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver" , "E:/Selenium/chromedriver_win32/chromedriver.exe" );
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://manage.bigrock.in/servlet/LoginServlet?role=customer&currenturl=https://manage.bigrock.in");
		Thread.sleep(5000);
		WebElement element=driver.findElement(By.id("login-username"));
		WebElement element1=driver.findElement(By.id("login-password"));
		Thread.sleep(5000);
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		//Set set=driver.getWindowHandles();
		//WebDriver dirver2=driver.switchTo().newWinodw(WindowType.TAB);
		
		
		String url="http://google.com";
		JavascriptExecutor javaScript=(JavascriptExecutor)driver;		
	//	javaScript.executeScript("window.open(arguments[0])", url);
		javaScript.executeScript("window.open()", url);
		
		Set set=driver.getWindowHandles();
		Iterator i=set.iterator();
		
		while(i.hasNext()) {
			WebDriver driver2=driver.switchTo().window(i.next().toString());
			System.out.println("TItle:::::::"+driver2.getTitle());
		}
		
		

	}

}
