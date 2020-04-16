/*package mylearningAutomation;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ide {

	public static void main(String[] args) throws InterruptedException {

		// WebDriver driver = new FirefoxDriver();
		// System.setProperty("webdriver.chrome.driver", "D:\\Test
		// Automation\\ATAP-1.1.7\\eclipse\\workspace\\chromedriver.exe");
		// WebDriver driver = new ChromeDriver();

		String pwd = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", pwd + "\\Software\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://myte.accenture.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// gettng logged in
		try {
			// driver.findElement(By.xpath("//*[@id='bySelection']/div[2]/div/span")).click();
			// Thread.sleep(5000);
			String getUserName, getPassword;
			getUserName = ExcelOperations.getInputData("UserName");
			getPassword = ExcelOperations.getInputData("Password");
			// enter the password
			driver.findElement(By.name("UserName")).sendKeys(getUserName);
			driver.findElement(By.name("Password")).sendKeys(getPassword);

			// driver.findElement(By.id("userNameInput")).sendKeys("v.periasamy@accenture.com");
			// driver.findElement(By.name("Password")).sendKeys("MANJU@VINODHAN13");

			// Reading credentials from excel sheet
			// String UserName, Password;
			// getUserName = ExcelOperations.getInputData("UserName");
			// getPassword = ExcelOperations.getInputData("Password");
			// Sending the credentials
			// driver.findElement(By.name("UserName")).sendKeys(getUserName);
			// driver.findElement(By.name("Password")).sendKeys(getPassword);
			// click on the signin button
			driver.findElement(By.xpath("//*[@id='submitButton']")).click();
			System.out.println("Entered credetials and clicked on sign in button, lets wait for few seconds");
			Thread.sleep(60000);
		} catch (Exception e) {
			// If login failed, below codes will execute and browser will be
			// closed
			System.out.println("Login Failed");
			driver.close();
		}
		// get the Default check box selected status of Remember this private
		boolean selectState = driver.findElement(By.xpath("//*[@id='vipRememberDevice']")).isSelected();
		// This result will be in a boolean format
		System.out.println("Default selectState=" + selectState);
		// If the check box is enabled, below code will do uncheck for Remember
		if (selectState == true) {
			driver.findElement(By.xpath("//*[@id='rememberDeviceLabel']")).click();
		} else {
			// No action to be performed
		}
		// get the Current checkbooks selected status of Remember this private
		// check box
		boolean selectState1 = driver.findElement(By.xpath("//*[@id='vipRememberDevice']")).isSelected();
		// This result will be boolean //*[@id='rememberDeviceLabel']
		// //*[@id='vipRememberDevice']
		System.out.println("Current selectState=" + selectState1);

		// To get the symantic code below codes will be performed
		// 1st step s To click on the link "DOnt have a security code"
		driver.findElement(By.xpath("//*[@id='vipOoblink']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='vipOobOptions']/label[1]")).click();
		// Click on Send button
		driver.findElement(By.xpath("//*[@id='vipSend']")).click();
		Thread.sleep(15000);
		// Check the confirmation message
		String text = driver.findElement(By.xpath("//*[@id='vipMessageContent']")).getText();
		System.out.println("Message is=" + text);
		Thread.sleep(10000);
		try {
			// Once user enters security code, below codes will be performed to
			// proceed
			Actions act = new Actions(driver);
			WebElement button = driver.findElement(By.xpath("//*[@id='vipSubmitOTP']"));
			act.doubleClick(button).build().perform();
			System.out.println("Logged in successfully.Lets wait for few moments to navigate to home page");
		} catch (Exception e) {

		}
		// Once user enters the security code and clicked on continue
		Thread.sleep(30000);
		// User has logged in to mylearning portal
		System.out.println("Login successful");
		Thread.sleep(10000);
		//

		// Enter the credetials
		Thread.sleep(20000);

		// Click on enter myTimeandExpenses
		driver.findElement(By.xpath("//*[@id='ctl00_MainContentPlaceHolder_AnnouncementControl_lnk_Enter2']")).click();
		Thread.sleep(2000);

		// Click on record
		// WebElement record =
		// driver.findElement(By.xpath("//a[@href='javascript:__doPostBack('ctl00$ctl00$PrimaryMenu','Record')'"));
		// record.click();
		Thread.sleep(2000);

		// click mytebox
		WebElement myteBox = driver.findElement(By.xpath("//td[@adr=\'0\' and @idx=\'0\']"));
		myteBox.click();
		Thread.sleep(2000);

		// Click on assignment
		WebElement clickAssignment = driver.findElement(By.id("x:1665319875.4:mkr:ButtonImage"));
		clickAssignment.click();
		Thread.sleep(2000);

		// Select the assignment
		WebElement selectAssignment = driver.findElement(By.id("x:1846955549.13:adr:37:tag:"));
		selectAssignment.click();
		Thread.sleep(2000);

		// Click on cell1
		WebElement clickCell1 = driver.findElement(By.xpath("//td[@adr=\'3\' and @idx=\'3\']"));
		clickCell1.click();
		Thread.sleep(2000);

		// Set the 9 into cell1
		clickCell1.sendKeys("9");

		// Click on cell1
		WebElement clickCell2 = driver.findElement(By.xpath("//td[@adr=\'4\' and @idx=\'4\']"));
		clickCell2.click();
		Thread.sleep(2000);

		// Set the 9 into cell1
		clickCell2.sendKeys("9");

		// Click on cell1
		WebElement clickCell3 = driver.findElement(By.xpath("//td[@adr=\'5\' and @idx=\'5\']"));
		clickCell3.click();
		Thread.sleep(2000);

		// Set the 9 into cell1
		clickCell3.sendKeys("9");

		// Click on cell1
		WebElement clickCell4 = driver.findElement(By.xpath("//td[@adr=\'6\' and @idx=\'6\']"));
		clickCell4.click();
		Thread.sleep(2000);

		// Set the 9 into cell1
		clickCell4.sendKeys("9");

		// Click on cell1
		WebElement clickCell5 = driver.findElement(By.xpath("//td[@adr=\'7\' and @idx=\'7\']"));
		clickCell4.click();
		Thread.sleep(2000);

		// Set the 9 into cell1
		clickCell5.sendKeys("9");

		// Click on cell1
		WebElement clickCell6 = driver.findElement(By.xpath("//td[@adr=\'10\' and @idx=\'11\']"));
		clickCell6.click();
		Thread.sleep(2000);

		// Set the 9 into cell1
		clickCell6.sendKeys("9");

		// Click on cell1
		WebElement clickCell7 = driver.findElement(By.xpath("//td[@adr=\'11\' and @idx=\'11\']"));
		clickCell7.click();
		Thread.sleep(2000);

		// Set the 9 into cell1
		clickCell7.sendKeys("9");

		// Click on cell8
		WebElement clickCell8 = driver.findElement(By.xpath("//td[@adr=\'12\' and @idx=\'12\']"));
		clickCell8.click();
		Thread.sleep(2000);

		// Set the 9 into cell8
		clickCell8.sendKeys("9");

		// Click on cell1
		WebElement clickCell9 = driver.findElement(By.xpath("//td[@adr=\'13\' and @idx=\'13\']"));
		clickCell9.click();
		Thread.sleep(2000);

		// Set the 9 into cell1
		clickCell9.sendKeys("9");

		// Click on cell1
		WebElement clickCell10 = driver.findElement(By.xpath("//td[@adr=\'14\' and @idx=\'14\']"));
		clickCell10.click();
		Thread.sleep(2000);

		// Set the 9 into cell1
		clickCell10.sendKeys("9");

		WebElement calculateAndSaveHours = driver.findElement(By.id("btn_recalculate"));
		calculateAndSaveHours.click();
		Thread.sleep(3000);
	}
	public static String ReadCSVValue(String dayName){

		   try
	         {
	             FileReader fr = null;
	             BufferedReader br = null;
	             String inputPath = "Test.csv";
	             fr = new FileReader(inputPath);
	             br = new BufferedReader(fr);
	             String line = null;
	             ArrayList<Object> myList = new ArrayList<Object>();
	             line = br.readLine();
	             String line2;
	             line2=br.readLine();
	             while(line!=null)
	             {
		            	 String strar[] = line.split(",");
		            	 String strar1[] = line2.split(",");
		            	 for(int j=0;j<strar.length-1;j++){
		            		 if(strar[j].equalsIgnoreCase(dayName)){
		            	 return strar1[j];
		             }  
		             
	            	 }
	             }
	         }
	         catch(IOException e)
	         {
	             System.out.print(e);
	         }
		return null;
	    } 
}
*/