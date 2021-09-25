package ActionsMouseAndKey;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsMouseAndKeyboard {
	@Test
	public void AcitonsMouse() {
		String baseUrl = "http://www.facebook.com/";
		
		System.setProperty("webdriver.chrome.driver" , "E:/Selenium/chromedriver_win32/chromedriver.exe" );
		WebDriver driver = new ChromeDriver();
		
		driver.get(baseUrl);
		WebElement txtUsername = driver.findElement(By.id("email"));

		
		
		
		Action seriesOfActions = new Actions(driver)
			.moveToElement(txtUsername)
			.click()
			.keyDown(txtUsername, Keys.SHIFT)
			.sendKeys(txtUsername, "hello")
			.keyUp(txtUsername, Keys.SHIFT)
			.doubleClick(txtUsername)
			.contextClick()
			.build();
			
		seriesOfActions.perform() ;

		}


	
	
}
