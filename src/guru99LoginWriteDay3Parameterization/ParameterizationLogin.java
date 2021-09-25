package guru99LoginWriteDay3Parameterization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import guru99LoginWriteToExcelPoi.UIMap;

public class ParameterizationLogin {

	public WebDriver driver;
	public UIMap uimap;
	public UIMap datafile;
	public String workingDir;

	FileInputStream file1 = null;
	XSSFWorkbook workbook1 = null;
	XSSFSheet sheet1 = null;

	// public static String driverPath = "C:/workspace/tools/selenium/";

	@Test(dataProvider = "data1", description = "Login scnenario parameterization")
	public void login(String uname, String pword, String row)
			throws InterruptedException, UnhandledAlertException, Exception {

		Row row1 = null;

		try {
			
			System.setProperty("webdriver.gecko.driver", "E:/Selenium/geckodriver.exe");

			System.out.println("inside before class 333333333");
			// Launching Chrome browser.
			driver = new FirefoxDriver();


			System.out.println("inside before class  44444444444");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			System.out.println("HEllo1");
			driver.get(datafile.getData("url"));
			System.out.println("HEllo1");
			driver.manage().window().maximize();
			System.out.println("HEllo1");

			WebElement username = driver.findElement(uimap.getLocator("Username_field"));
			username.sendKeys(uname);

			// Get the password element
			WebElement password = driver.findElement(uimap.getLocator("Password_field"));
			password.sendKeys(pword);

			WebElement login = driver.findElement(uimap.getLocator("Login_button"));
			login.click();

			
			row1 = sheet1.getRow(Integer.parseInt(row));

			// row1.createCell(2).setCellValue("FAIL");

			/*
			 * if(driver.getCurrentUrl().contains("Managerhomepage.php")) {
			 * row1.createCell(2).setCellValue("PASS");
			 * 
			 * }
			 */
			Thread.sleep(10000);

			Assert.assertTrue(driver.getCurrentUrl().contains("Managerhomepage.php"));
			
			//Verify.verify(driver.getTitle().contains("Manager HomePage"));
			row1.createCell(2).setCellValue("PASS");

			System.out.println("HEllo1");
		} catch (Exception e) {
			System.out.println("HEllo2");
			System.out.println("HEllo22");
			
			//Thread.sleep(10000);
			
			//driver.switchTo().alert(
			
//			// Switching to Alert        
//			WebDriverWait wait = new WebDriverWait(driver, 20);
//		    wait.until(ExpectedConditions.alertIsPresent());
//		    
		    
			
			
			    	//driver.get("http://www.demo.guru99.com/V4/index.php");
			     // alert=  driver.isalert();
			
			String set=driver.getWindowHandle();
			      System.out.println("Window handles:::::"+set);
			//driver.switchTo().window(set);
//			String title=driver.switchTo().defaultContent().getPageSource();
			WebDriver driver2=driver.switchTo().defaultContent();
			//driver2.
			//WebDriverWait wait = new WebDriverWait(driver, 20);
		    //wait.until(ExpectedConditions.alertIsPresent());
//		    
//			JavascriptExecutor executor=(JavascriptExecutor) driver2;
//			executor.executeScript("location.reload();");
//			Thread.sleep(5000);
//			executor.executeScript("document.getElementById('OK').click();");
			
			//Thread.sleep(15000);
			//executor.executeScript("", null);
			//WebElement element=driver.switchTo().activeElement();
			//element.click();
			//String title=driver.switchTo().frame(0).getPageSource();
			
//			WebElement element = driver2.findElement(By.id("OK"));
//			JavascriptExecutor executor = (JavascriptExecutor)driver2;
//			executor.executeScript("arguments[0].click();", element);

//			System.out.println("title::::::::::::::::"+title);
			
			
		 //   alert.accept();
		    
			System.out.println("Beofer assert 111111111111");
			Assert.assertTrue(driver2.getPageSource().contains("User or Password is not valid"));
			System.out.println("Beofer assert 111111111111");
			row1.createCell(2).setCellValue("FAIL");
			Assert.assertTrue(false);
			
		} finally {
			FileOutputStream fileOut = new FileOutputStream("E:/Selenium/Day3GuruParameterization_1.xlsx");
			workbook1.write(fileOut);
			fileOut.close();
			driver.quit();
		}
	}

	@BeforeClass(alwaysRun = true)
	public void suiteSetUp() throws IOException {
		System.out.println("inside before classss0001");
		// create a new work book
		// File file= new File("D:/SaveTestNGResultToExcel.xlsx");
		// FileInputStream in = new FileInputStream(file);
		System.out.println("inside before class0");
		workbook1 = new XSSFWorkbook();

		System.out.println("inside before class1");
		// create a new work sheet
		sheet1 = workbook1.createSheet("TestNG Result Summary");

		System.out.println("inside before class2");
		// add test result excel file column header
		System.out.println("inside before class3");
		// write the header in the first row
		System.out.println("inside before class4");
		try {

			// Get current working directory and load the data file

			workingDir = System.getProperty("user.dir");
			datafile = new UIMap(workingDir + "/Resources/datafile.properties");
			// Get the object map file
			uimap = new UIMap(workingDir + "/Resources/locator.properties");

			System.out.println("inside before class  22222222222");

			// Setting up Chrome driver path.
			// System.setProperty("webdriver.chrome.driver",
			// "E:/Selenium/chromedriver_win32/chromedriver.exe");

//			System.setProperty("webdriver.chrome.driver", datafile.getData("chromeDriverPath"));
//
//			System.out.println("inside before class 333333333");
//			// Launching Chrome browser.
//			driver = new ChromeDriver();
			
			
			
		} catch (Exception e) {
			throw new IllegalStateException("Can't start the Firefox Web Driver", e);
		}

		System.out.println("inside before class  12123123");

	}

	@AfterClass
	public void suiteTearDown() {
		//driver.close();
		
	}

	@DataProvider(name = "data1")
	public Object[][] readExcelFile() throws IOException, Exception {

		file1 = new FileInputStream(new File("E:/Selenium/Day3GuruParameterization_1.xlsx"));

		// Create Workbook instance holding reference to .xlsx file
		workbook1 = new XSSFWorkbook(file1);

		// Get first/desired sheet from the workbook
		sheet1 = workbook1.getSheetAt(0);

		int rows = sheet1.getLastRowNum() + 1;
		int columns = 2;

		String excelData[][] = new String[rows][columns + 1];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				XSSFCell c1 = sheet1.getRow(i).getCell(j);

				excelData[i][j] = c1.getStringCellValue();
				System.out.println(excelData[i][j]);

			}

			excelData[i][2] = "" + i;
		}
		return excelData;
	}

	
	
}