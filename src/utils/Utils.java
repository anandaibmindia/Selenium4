package utils;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains some utilities to manage the tests
 * 
 * @version 1.01
 */

public class Utils {
    /**
     * 
     * @param driver
     * @param element 
     */
    public static void waitUntilIsVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    
    /**
     * 
     * @param driver
     * @param element 
     */
    public static void waitUntilIsVisible(WebDriver driver, By element) {
        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
    
    
    
    /*
    public static boolean waitUntilIsVisible(WebDriver driver, WebElement element) {
        Wait wait = new WebDriverWait(driver, 8).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }
    */
    
    
    /**
     * 
     * @param driver
     * @param element 
     */
    public static void waitUntilIsPresent(WebDriver driver, By element) {
        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }
    
    
   
    /**
     * 
     * @param driver
     * @param element 
     */
    public static void waitUntilIsDisappears(WebDriver driver, By element) {
        WebDriverWait wait = new WebDriverWait(driver, 8, 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }
    
    
    
    /**
     * 
     * @param driver
     * @param element 
     */
    public static void waitUntilIsDisappears(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 8, 50);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
    
    
    
    /**
     * 
     * @param driver
     * @param element 
     */
    public static void waitUntilIsAppearsAndDisappears(WebDriver driver, By element){
        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        WebDriverWait wait2 = new WebDriverWait(driver, 2, 100);
        wait2.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }
    
    
    
    /**
     * 
     * @param driver
     * @param element 
     */
    public static void waitUntilIsAppearsAndDisappears(WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.visibilityOf(element));
        WebDriverWait wait2 = new WebDriverWait(driver, 2, 100);
        wait2.until(ExpectedConditions.invisibilityOf(element));
    }
    
    
    
    /**
     * 
     * @param driver
     * @param element 
     */
    public static void waitUntilIsClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 8, 50);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    
    
    /**
     * 
     * @param driver
     * @param element
     * @param attribute 
     */
    public static void waitUntilAttributeToBeNotEmpty(WebDriver driver, WebElement element, String attribute)
    {
        WebDriverWait wait = new WebDriverWait(driver, 4, 50);
        wait.until(ExpectedConditions.attributeToBeNotEmpty(element, attribute));
    }
    
    
    
    /**
     * 
     * @param wait
     * @param element
     * @param childrenSelector
     * @param currentSize 
     */
    private static void waitUntilSizeChange(WebDriverWait wait, WebElement element, String childrenSelector, int currentSize){
        wait.until((ExpectedCondition<Boolean>) (WebDriver d) -> {
            int size = element.findElements(By.xpath(childrenSelector)).size();
            return currentSize != size;
        });
    }
    
    
    /**
     * 
     * @param driver
     * @param element
     * @param value 
     */
    private static void waitUntilHasValue(WebDriver driver, WebElement element, String value){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until((ExpectedCondition<Boolean>) (WebDriver f) -> !"".equals(element.getAttribute(value)));
    }
    
    /**
     * 
     * @param driver 
     * @param element 
     */
    public static void waitUntilElementStaleness(WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 4, 50);
        wait.until(ExpectedConditions.stalenessOf(element));
    }
    
}//end class