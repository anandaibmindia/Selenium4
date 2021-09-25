package TestNGCode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RunningParallelMethods {

	ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();

	WebDriver driver = null;

	@BeforeMethod
	public void startBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:/Selenium/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();

		// driver= new FireFoxDriver();
		dr.set(driver);
	}

	@AfterMethod
	public void stopBrowser() {

		getDriver().quit();
		// dr.get().close();
		// dr.set(null);
		// driver.quit();
	}

	public WebDriver getDriver() {
		return dr.get();

	}

	@Test
	public void test1() throws InterruptedException {
		getDriver().get("http://www.facebook.com/");
		System.out.println("inside test 01");
		Thread.sleep(4000);

	}

	@Test
	public void test2() throws InterruptedException {
		getDriver().get("http://www.facebook.com/");
		System.out.println("inside test 02");

		Thread.sleep(4000);
	}

	@Test
	public void test3() throws InterruptedException {
		getDriver().get("http://www.facebook.com/");
		System.out.println("inside test 03");

		Thread.sleep(4000);
	}

}
