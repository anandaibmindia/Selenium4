package log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Log4jSeleniumExample {
	
	Logger log;

	@BeforeClass
	public void Log4jinstall() {
		log = Logger.getLogger(Log4jSeleniumExample.class.getName());
		PropertyConfigurator.configure("Properties/log4j2.properties");

	}

	@Test
	public void log4jTest() {
		
		log.warn("Entering log4j Test");
		
		System.setProperty("webdriver.chrome.driver", "E:/Selenium/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.demo.guru99.com/V4/");
		driver.findElement(By.name("uid")).sendKeys("mngr33");
		driver.findElement(By.name("password")).sendKeys("hEjujAp");
		driver.findElement(By.name("btnLogin")).click();
		log.warn("exiting log4j Test");		
		log.trace("trace log4j Test");
		driver.quit();
	}

}
