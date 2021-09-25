package SeleniumListeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.testng.annotations.Test;

public class ListenersDemo extends AbstractWebDriverEventListener{
	
	
	WebDriver driver;
	String url;
	
	@Test
	public void demoListeners() {
		
		System.setProperty("webdriver.chrome.driver", "E:/Selenium/chromedriver_win32/chromedriver.exe");
		
		driver= new ChromeDriver();
		driver.get("http://www.demo.guru99.com/V4/");
		url="http://www.demo.guru99.com/V4/";
		//afterNavigateTo(url,driver);
		
		driver.navigate().to("http://www.google.com");
		
		
	}

	
	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("After Navigating To: "+url);
	}
}
