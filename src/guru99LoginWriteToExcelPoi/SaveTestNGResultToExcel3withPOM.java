package guru99LoginWriteToExcelPoi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.base.Verify;

import utils.UtilData;

public class SaveTestNGResultToExcel3withPOM {

	public WebDriver driver;
	public UIMap uimap;
	public UIMap datafile;
	public String workingDir;
	
	Day1POMLogin loginPage;

	// Declare An Excel Work Book
	HSSFWorkbook workbook;
	// Declare An Excel Work Sheet
	HSSFSheet sheet;
	// Declare A Map Object To Hold TestNG Results
	Map<String, Object[]> TestNGResults;
	
	
	

	
	
	//public static String driverPath = "C:/workspace/tools/selenium/";

	@Test(description = "Opens the TestNG Demo Website for Login Test", priority = 1)
	public void LaunchWebsite() throws Exception {

		try {
			
			System.out.println("HEllo1");
			driver.get(UtilData.url);
			System.out.println("HEllo1");
			driver.manage().window().maximize();
			System.out.println("HEllo1");
			TestNGResults.put("2", new Object[] { 1d, "Navigate to demo website", "Site gets opened", "Pass" });
			System.out.println("HEllo1");
		} catch (Exception e) {
			System.out.println("HEllo2");
			TestNGResults.put("2", new Object[] { 1d, "Navigate to demo website", "Site gets opened", "Fail" });
			System.out.println("HEllo22");
			Assert.assertTrue(false);
		}
	}

	@Test(description = "Fill the Login Details", priority = 2)
	public void FillLoginDetails() throws Exception {

		try {
			// Get the username element
			loginPage.typeUsername(UtilData.username);
			loginPage.typePassowrd(UtilData.password);
			Thread.sleep(1000);

			TestNGResults.put("3", new Object[] { 2d, "Fill Login form data (Username/Password)",
					"Login details gets filled", "Pass" });

		} catch (Exception e) {
			TestNGResults.put("3",
					new Object[] { 2d, "Fill Login form data (Username/Password)", "Login form gets filled", "Fail" });
			Assert.assertTrue(false);
		}
	}

	@Test(description = "Perform Login", priority = 3)
	public void DoLogin() throws Exception {

		try {
			// Click on the Login button
			loginPage.clickLogin();

			Thread.sleep(5000);
			// Assert the user login by checking the Online user
			//WebElement onlineuser = driver.findElement(uimap.getLocator("online_user"));
			

			//Verify.verify(onlineuser.getText().equalsIgnoreCase("Hi, john"));
			
			//Verify.verify(true);	
			
			Verify.verify(driver.getCurrentUrl().contains("Managerhomepage.php"));
			
			TestNGResults.put("4",
					new Object[] { 3d, "Click Login and verify welcome message", "Login success", "Pass" });
			
		} catch (Exception e) {
			TestNGResults.put("4",
					new Object[] { 3d, "Click Login and verify welcome message", "Login fail", "Fail" });
			Assert.assertTrue(false);
		}
	}
	
	

	@BeforeClass(alwaysRun = true)
	public void suiteSetUp() throws IOException {
		System.out.println("inside before classss0001");
		// create a new work book
		//File file= new  File("D:/SaveTestNGResultToExcel.xlsx");
	//	FileInputStream in = new FileInputStream(file);
		System.out.println("inside before class0");
		workbook = new HSSFWorkbook();
		
		System.out.println("inside before class1");
		// create a new work sheet
		sheet = workbook.createSheet("TestNG Result Summary");
		
		System.out.println("inside before class2");
		TestNGResults = new LinkedHashMap<String, Object[]>();
		// add test result excel file column header
		System.out.println("inside before class3");
		// write the header in the first row
		TestNGResults.put("1", new Object[] { "Test Step No.", "Action", "Expected Output", "Actual Output" });
		System.out.println("inside before class4");
		try {

			// Get current working directory and load the data file
			
			
			workingDir = System.getProperty("user.dir");
			datafile = new UIMap(workingDir + "/Resources/datafile.properties");
			// Get the object map file
			uimap = new UIMap(workingDir + "/Resources/locator.properties");

			System.out.println("inside before class  22222222222");
			
			// Setting up Chrome driver path.
			System.setProperty("webdriver.chrome.driver", UtilData.chromeDriverPath);
			
			System.out.println("inside before class 333333333");
			// Launching Chrome browser.
			driver = new ChromeDriver();
			
			//loginPage=new Day1POMLogin(driver);
			loginPage=new PageFactory().initElements(driver,Day1POMLogin.class);
			
			//
		//	System.setProperty("webdriver.gecko.driver" , "C:/geckodriver.exe" );
		//	WebDriver driver = new FirefoxDriver();
			
			System.out.println("inside before class  44444444444");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		} catch (Exception e) {
			throw new IllegalStateException("Can't start the Firefox Web Driver", e);
		}
		
		System.out.println("inside before class  12123123");

	}

	@AfterClass
	public void suiteTearDown() {
		// write excel file and file name is SaveTestNGResultToExcel.xls
		Set<String> keyset = TestNGResults.keySet();
		int rownum = 0;
		for (String key : keyset) {
			Row row = sheet.createRow(rownum++);
			Object[] objArr = TestNGResults.get(key);
			int cellnum = 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellnum++);
				if (obj instanceof Date)
					cell.setCellValue((Date) obj);
				else if (obj instanceof Boolean)
					cell.setCellValue((Boolean) obj);
				else if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Double)
					cell.setCellValue((Double) obj);
			}
		}
		try {
			
			File file1= new  File("E:/SaveTestNGResultToExcel.xls");
			FileOutputStream out = new FileOutputStream(file1);
			workbook.write(out);
			out.close();
			System.out.println("Successfully saved Selenium WebDriver TestNG result to Excel File!!!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// close the browser
		driver.close();
		driver.quit();
	}
}