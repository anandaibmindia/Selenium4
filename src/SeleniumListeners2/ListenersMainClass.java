package SeleniumListeners2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class ListenersMainClass {

	public static final String USERNAME = "prakharkulshresh2";
	public static final String AUTOMATE_KEY = "dphXto2bxDtgA3DsVRVy";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	@Test
	public void listenerTest() throws Exception {

//DesiredCapabilities caps = new DesiredCapabilities();

		System.setProperty("webdriver.chrome.driver", "E:/Selenium/chromedriver_win32/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		Thread.sleep(5000);
//JavascriptExecutor jse = ((JavascriptExecutor)driver);

		EventFiringWebDriver eventHandler = new EventFiringWebDriver(driver);
		EventCapture ecapture = new EventCapture();

		eventHandler.register(ecapture);
		
		Thread.sleep(5000);
		eventHandler.navigate().to("http://www.google.com");
		
		Thread.sleep(5000);
		WebElement element = eventHandler.findElement(By.name("q"));
		element.sendKeys("BrowserStack");
		element.submit();
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
		eventHandler.unregister(ecapture);
		driver.quit();
	}
}