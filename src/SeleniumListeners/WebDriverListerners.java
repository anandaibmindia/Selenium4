package SeleniumListeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class WebDriverListerners extends AbstractWebDriverEventListener {
	private By lastFindBy;
	private WebElement lastElement;
	private String originalValue;

	/*
	 * URL NAVIGATION | NAVIGATE() & GET()
	 */
	// Prints the URL before Navigating to specific URL
	// “get(“http://www.esurance.com”);”
	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		commonReport("Before Navigating To");
	}

	// Prints the current URL after Navigating to specific URL
	// “get(“http://www.esurance.com”);”
	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		commonReport("After Navigating To: ");
	}

	// Prints the URL before Navigating back “navigate().back()”
	@Override
	public void beforeNavigateBack(WebDriver driver) {
		commonReport("“Before Navigating Back");
	}
	// Prints the current URL after Navigating back “navigate().back()”

	public void commonReport(String str) {
		System.out.println(str);

	}

}
