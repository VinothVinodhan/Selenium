package mylearningAutomation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelFileHandle {

	public static void main(String[] args) throws IOException {
		String fpath = "C://Users//manju//Desktop//Credentials.xlsx";
		FileInputStream fis = new FileInputStream(fpath);
		
		XSSFWorkbook xl = new XSSFWorkbook(fis);
		XSSFSheet sh = xl.getSheet("Sheet1");
		XSSFRow r = sh.getRow(1);
		XSSFCell c = r.getCell(0);
		System.out.println("UserName is="+c);
		
		XSSFRow r1 = sh.getRow(2);
		XSSFCell c1 = r.getCell(1);
		System.out.println("Password is="+c1);

		String pwd = System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.driver", pwd + "\\Software\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);

		driver.get("https://gmail.com");
		//driver.findElement(By.name("UserName")).sendKeys("v.periasamy");
		//driver.findElement(By.name("Password")).sendKeys("MANJU@VINODHAN13");
		
		
	}

}