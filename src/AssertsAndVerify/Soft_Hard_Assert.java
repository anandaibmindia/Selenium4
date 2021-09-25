package AssertsAndVerify;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Verify;
 
public class Soft_Hard_Assert {
 
     String class_Name = "Soft_Hard_Assert";
 
     Assertion hardAssert = new Assertion();
 
     SoftAssert softAssert = new SoftAssert();
 
     @Test
     public void hardAssertMethod() {
 
           hardAssert.assertTrue(true == true);
           
           System.out.println("Before Hard Assert fails");
 
           hardAssert.assertEquals("Soft_Hard_Assert", "Soft_Hard_Assert1");
           
           System.out.println("After Hard Assert fails");
 
           hardAssert.assertEquals(class_Name, "Soft_Hard_Assert");
 
           System.out.println("hardAssertMethod Successfully passed!");
      }
 
      @Test
      public void softAssertionMethod() {
 
           softAssert.assertTrue(true == true);
           
           System.out.println("Before Soft Assert fails");
 
           softAssert.assertEquals("Soft_Hard_Assert", "Soft_Hard_Assert1");
           
           System.out.println("After Soft Assert fails");
 
           softAssert.assertEquals(class_Name, "Soft_Hard_Assert");
 
           System.out.println("softAssertionMethod Successfully passed!");
 
           softAssert.assertAll();
           
           System.out.println("After soft Assert assertAll!");
           
      }
      
      
      @Test
      public void verifyMethod() {
 
           Verify.verify(true == true);
           
           System.out.println("Before Verify fails");
           
           Verify.verify(false);
           
           System.out.println("After Verify fails 1");
 
           Verify.verify("Soft_Hard_Assert".equalsIgnoreCase("Soft_Hard_Assert1"));
           
           System.out.println("After Verify fails 2");
 
           
           
      }
      
      
}
 