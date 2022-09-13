package Ananda;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TripAdvisorReview extends AnandaBaseClass{

    @Test
    public void writeReview() throws InterruptedException {
        driver.get("https://www.tripadvisor.in");
        driver.manage().window().maximize();




        System.out.println("1234");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        System.out.println("1234");
        // This  will scroll down the page by  1000 pixel vertical
        //js.executeScript("window.scrollBy(0,500)");
        //js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        js.executeScript("window.scrollBy(0,1500)");


        Thread.sleep(1000);
       // driver.findElement(By.xpath("//input[@class='fhEMT _G B- z _J Cj R0 fQSqO']")).sendKeys("Club Mahindra");
         //driver.findElement(By.name("q")).sendKeys("Club Mahindra");
         driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Club Mahindra",Keys.ENTER);
        Thread.sleep(1000);
         //result-title


        System.out.println("1234");
        driver.findElement(By.xpath("//div[@class='result-title']")).click();
        Thread.sleep(2000);
        System.out.println("1234");
        String[] windows1=driver.getWindowHandles().toArray(new String[1]);
        driver.switchTo().window(windows1[1]);
        Thread.sleep(2000);
        driver.findElement(By.partialLinkText("Write a review")).click();

        Actions acitons= new Actions(driver);

        WebElement element=driver.findElement(By.xpath("//span[@id='bubble_rating']"));
        acitons.moveToElement(element);
       // acitons.build().perform();

        System.out.println("7777777777");

        acitons.moveToElement(element,60,0).click().build().perform();
       // WebElement element1=driver.findElement(By.xpath("//span[@class='ui_bubble_rating fl bubble_50']"));






        WebElement l = driver.findElement(By.className("answersBubbles ui_bubble_rating fl qid12 bubble_50"));
        JavascriptExecutor j = (JavascriptExecutor) driver;
        //j.executeScript("arguments[0].click();", l);

        j.executeScript("document.findElementByClassName(\"answersBubbles ui_bubble_rating fl qid12 bubble_50\").click();");

/*
        driver.findElement(By.name("ReviewTitle")).sendKeys("Revie of title by Ananda");

        Actions acitons5= new Actions(driver);
        WebElement element5=driver.findElement(By.xpath("//span[@id='qid14_bubbles']"));
        acitons5.moveToElement(element5);
        acitons5.moveToElement(element5,60,0).click().build().perform();


        driver.findElement(By.name("ReviewText")).sendKeys("Revie of description by Ananda");

        //qid12_bubbles
        //qid14_bubbles



        Actions acitons1= new Actions(driver);
        WebElement element1=driver.findElement(By.xpath("//span[@id='qid12_bubbles']"));
        acitons1.moveToElement(element1);
        //acitons.moveToElement(element1,60,0).click().build().perform();
        acitons1.moveToElement(element1,60,0).click().build().perform();

       Thread.sleep(2000);

        //qid190_bubbles
        Actions acitons4= new Actions(driver);
        WebElement element4=driver.findElement(By.xpath("//span[@id='qid190_bubbles']"));
        acitons4.moveToElement(element4);
        acitons4.moveToElement(element4,60,0).click().build().perform();

        Thread.sleep(2000);
        //qid190_bubbles


        //acitons.build().perform();



*/




    }
}
