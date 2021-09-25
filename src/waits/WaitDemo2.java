package waits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WaitDemo2 {
	
	
	
	
	@Test
	public void waitDemo() throws InterruptedException{
	
	System.setProperty("webdriver.chrome.driver" , "E:/Selenium/chromedriver_win32/chromedriver.exe" );
	WebDriver driver = new ChromeDriver();
	
	driver.get("mhttps://manage.bigrock.in/servlet/LoginServlet?role=customer&currenturl=https://manage.bigrock.in");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	WebElement element=driver.findElement(By.id("login-username"));
	WebElement element1=driver.findElement(By.id("login-password"));

	Thread.sleep(5000);
	System.out.println("Before wait---------------------------------------------------");
	
	WebDriverWait wait = new WebDriverWait(driver, 1);
	wait.until(ExpectedConditions.visibilityOf(element));
	System.out.println("After wait1111---------------------------------------------------");
	Thread.sleep(5000);
	WebDriverWait wait1 = new WebDriverWait(driver, 1);
	wait1.until(ExpectedConditions.invisibilityOfAllElements(element,element1));
	Thread.sleep(5000);
	//wait.until(driver.getWindowHandles().size()>1);
	System.out.println("After wait222222---------------------------------------------------");
	driver.quit();
	
	}
	
	@Test
	public void fluentWaitDemo() throws InterruptedException{
		
		
		
		
	}


}




