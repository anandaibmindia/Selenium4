package DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderParallel {
	public WebDriver driver;

	FileInputStream file = null;
	XSSFWorkbook workbook = null;
	XSSFSheet sheet = null;

//@BeforeMethod
//public void initiateWorkBook() throws BiffException, IOException{
//
//}

	@Test(dataProvider = "data1")
	public void login(String email, String password, String row)
			throws InterruptedException, UnhandledAlertException, Exception {

		System.setProperty("webdriver.chrome.driver", "E:/Selenium/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://manage.bigrock.in/servlet/LoginServlet?role=customer&currenturl=https://manage.bigrock.in");

//driver.get("http://flipkart.com");
		driver.findElement(By.id("login-username")).sendKeys(email);
		driver.findElement(By.id("login-password")).sendKeys(password);

		Thread.sleep(3000);
		driver.findElement(By.className("login-submit")).click();
		Thread.sleep(10000);

		String currentUrl = driver.getCurrentUrl();

		System.out.println("LoginServlet url  ---------------------------------------------- " + currentUrl);

		Row row1 = sheet.getRow(Integer.parseInt(row));
		
		row1.createCell(2).setCellValue("FAIL");
		
		if(currentUrl.contains("ListAllOrdersServlet"))		
		{
			row1.createCell(2).setCellValue("PASS");
			
		}
		
		

		FileOutputStream fileOut = new FileOutputStream("E:/Selenium/DataDrivenFrameworkInput.xlsx");
		workbook.write(fileOut);
		fileOut.close();

		driver.quit();
	}

	@DataProvider(name = "data1", parallel = true)
	public Object[][] readExcelFile() throws IOException, Exception {

		file = new FileInputStream(new File("E:/Selenium/DataDrivenFrameworkInput.xlsx"));

		// Create Workbook instance holding reference to .xlsx file
		workbook = new XSSFWorkbook(file);

		// Get first/desired sheet from the workbook
		sheet = workbook.getSheetAt(0);

		int rows = sheet.getLastRowNum() + 1;
		int columns = 2;

		String excelData[][] = new String[rows][columns + 1];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				XSSFCell c1 = sheet.getRow(i).getCell(j);

				excelData[i][j] = c1.getStringCellValue();
				System.out.println(excelData[i][j]);

			}

			excelData[i][2] = "" + i;
		}
		return excelData;
	}
}
