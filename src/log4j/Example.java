package log4j;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;  
  
public class Example{  
  
   /* Get the class name to be printed on */  
   static Logger log = Logger.getLogger(Example.class.getName());  
     
   public static void main(String[] args)throws IOException,SQLException{
	//   BasicConfigurator.configure();
	   
	   PropertyConfigurator.configure("Properties/log4j2.properties");

	   
//      log.debug("Hello this is a debug message");  
//      log.info("Hello this is an info message");  
//      
      log.trace("Trace Message!");
      log.debug("Debug Message!");
      log.info("Info Message!");
      log.warn("Warn Message!");
      log.error("Error Message!");
      log.fatal("Fatal Message!");
   }  
}  