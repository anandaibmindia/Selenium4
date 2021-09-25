package waits;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WaitDemo {
	
	
	
	
	@Test
	public void waitDemo() throws InterruptedException{
	
	System.setProperty("webdriver.chrome.driver" , "E:/Selenium/chromedriver_win32/chromedriver.exe" );
	WebDriver driver = new ChromeDriver();
	
	driver.get("https://manage.bigrock.in/servlet/LoginServlet?role=customer&currenturl=https://manage.bigrock.in");
	
	
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.numberOfWindowsToBe(2));
	//driver.getWindowHandles();
	
	/*int counter=0;
	int windwsize=1;
	String mainWindow = driver.getWindowHandle();
	
	
	while(counter==0){
	windwsize=driver.getWindowHandles().size();
	
	if (windwsize>1){
		
		break;
	}else{
		
	Thread.sleep(4000);
	counter=1;
	windwsize=driver.getWindowHandles().size();
	
	}
	
	}
	*/
	
	
	driver.switchTo().window("");	
	
	
	
	
	
	
	
	
	//wait.until(driver.getWindowHandles().size()>1);
	System.out.println("After wait---------------------------------------------------");
	
	}
	






















public boolean waitForNewWindow(WebDriver driver, int timeout){

    boolean flag = false;

    int counter = 0;

    while(!flag){

        try {

            Set<String> winId = driver.getWindowHandles();

            if(winId.size() > 1){

                flag = true;

                return flag;

            }

            Thread.sleep(1000);

            counter++;

            if(counter > timeout){

                return flag;

            }

        } catch (Exception e) {

            System.out.println(e.getMessage());

            return false;

        }

    }

    return flag;

}

}




