package mylearningAutomation;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AutomateMylearningFInal {
	public static void main(String[] args) throws InterruptedException {

		String pwd = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", pwd + "\\Software\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// Maximizing the window
		driver.manage().window().maximize();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
		// navigate to mylearning portal
		driver.get("http://mylearning.accenture.com");
		System.out.println("launched Mylearning portal and wait for 30secs to perfrom next step");
		Thread.sleep(30000);

		// Used Try-Catch block to handle login exception
		try {
			driver.findElement(By.xpath("//*[@id='bySelection']/div[2]/div/span")).click();
			Thread.sleep(5000);
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
			Thread.sleep(20000);
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
			String codenotreceived = driver.findElement(By.xpath("//*[@id='vipMessageContent']")).getText();
			System.out.println("Message is=" + codenotreceived);
			driver.close();
		}
		// Once user enters the security code and clicked on continue
		Thread.sleep(30000);
		// User has logged in to mylearning portal
		System.out.println("Reading Text from Notice window");
		Thread.sleep(2000);
		String text1 = driver.findElement(By.xpath("//*[@id='modalTimeZoneDataPrivacyBody']/div/p[2]")).getText();
		System.out.println("Notice message is=" + text1);
		driver.findElement(By.xpath("//*[@id='btnOkTimezone']")).click();
		Thread.sleep(2000);
		// To display Welcome message
		String text2 = driver.findElement(By.xpath("//*[@id='sec_home_1']/div/div/div/segment/div/div[1]/h1"))
				.getText();
		System.out.println("Login successful:" + text2);
		Thread.sleep(10000);

		// Taking lists of training in mylearning page
		System.out.println("Navigated to Mylearning page to get all the trainings list");
		System.out
				.println("Please wait for some moments to page gets loded, so that all the trainings will be visible");
		Thread.sleep(40000);
		try {
			// Printing all links in a page
			// Storing all the links in a page to List variable
			java.util.List<WebElement> mylearninglinks = driver.findElements(By.tagName("a"));
			// Giving the size of the links
			System.out.println("Total Links Found: " + mylearninglinks.size());
			// To print all the link name
			for (int i = 1; i <= mylearninglinks.size(); i = i + 1) {
				String linkName = mylearninglinks.get(i).getText();
				// If statement is to filter out only the training names
				if (linkName.length() == 0 || linkName == null) {
					// If condition is to check the value stars with 0 & NULL
					// No Link name defined
				} else if (linkName.equals("X") || linkName.equals("Previous") || linkName.equals("Next")
						|| linkName.equals("Favorites") || linkName.equals(" ETHICS & COMPLIANCE")
						|| linkName.equals(" UPCOMING TRAINING") || linkName.equals("myLearning")
						|| linkName.equals(" CURRENT TRAINING") || linkName.equals("Open Search box")
						|| linkName.equals("Training Policy / Data Privacy Notification")
						|| linkName.equals("See more from this Learning Path...")) {
					// This condition is to avoid other links except trainings
					// to avoid other links that appear on the page.
				} else {
					System.out.println("mylearninglink:" + linkName);
					WriteToExcel.writeList(linkName);
					Thread.sleep(1000);
					// To print actual Require training links name
				}
			}
		} catch (Exception e) {
			System.out.println("Printed required links name in mylearning page");
		}

		// Getting all the links in current training page
		// Double click on current training link
		Actions act1 = new Actions(driver);
		WebElement link1 = driver.findElement(By.xpath("//*[@id='menu_current_training']/a"));
		act1.doubleClick(link1).build().perform();
		Thread.sleep(10000);
		// Printing the page title
		String text3 = driver.findElement(By.xpath("//*[@id='currentTrainingTitle']")).getText();
		System.out.println("Text3 is =" + text3);
		Thread.sleep(10000);
		// Here we are going to user Try-Catch block to handle exceptions
		// Taking lists of training in current page
		try {
			// Printing all links in a page
			// Storing all the links in a page to List variable
			java.util.List<WebElement> Currenttraininglinks = driver.findElements(By.tagName("a"));
			// Giving the size of the links
			System.out.println("Total Links Found: " + Currenttraininglinks.size());
			// To print all the link name
			for (int j = 1; j <= Currenttraininglinks.size(); j = j + 1) {
				String linkName = Currenttraininglinks.get(j).getText();
				// If statement is to filter out only the training names
				if (linkName.length() == 0 || linkName == null) {
					// If condition is to check the value stars with 0 & NULL
					// No Link name defined
				} else if (linkName.equals("myLearning") || linkName.equals(" CURRENT TRAINING")
						|| linkName.equals(" UPCOMING TRAINING") || linkName.equals(" ETHICS & COMPLIANCE")
						|| linkName.equals("Open Search box") || linkName.equals("Favorites")
						|| linkName.equals("Training Policy / Data Privacy Notification")) {
					// This condition is to avoid other links except trainings
					// to avoid other links that appear on the page.
				} else {
					System.out.println("Link:" + linkName);
					WriteToExcel.writeList(linkName);
					Thread.sleep(1000);
					// To print actual Require training links name
				}
			}
		} catch (Exception e) {
			System.out.println("Printed required links name in Current training page");
		}

		// Getting all the links in Upcoming Training page
		// Double click on Upcoming Training link
		Actions act11 = new Actions(driver);
		WebElement link2 = driver.findElement(By.xpath("//*[@id='menu_upcoming_training']/a"));
		act11.doubleClick(link2).build().perform();
		Thread.sleep(40000);
		// Printing the page title
		try {
			String text4 = driver.findElement(By.xpath("//*[@id='menu_upcoming_training']/a")).getText();
			System.out.println("Text4 is =" + text4);
		} catch (Exception e) {
			System.out.println("Its having trainings");
		}
		// Here we are going to use Try-Catch block to handle exceptions
		// Taking lists of training in Upcoming Training page
		try {
			// Printing all links in a page
			// Storing all the links in a page to List variable
			java.util.List<WebElement> UpcomingTraining = driver.findElements(By.tagName("a"));
			// Giving the size of the links
			System.out.println("Total Links Found: " + UpcomingTraining.size());
			// To print all the link name
			for (int k = 1; k <= UpcomingTraining.size(); k = k + 1) {
				String linkName = UpcomingTraining.get(k).getText();
				// If statement is to filter out only the training names
				if (linkName.length() == 0 || linkName == null) {
					// If condition is to check the value stars with 0 & NULL
					// No Link name defined
				} else if (linkName.equals("myLearning") || linkName.equals(" CURRENT TRAINING")
						|| linkName.equals(" UPCOMING TRAINING") || linkName.equals(" ETHICS & COMPLIANCE")
						|| linkName.equals("Open Search box") || linkName.equals("Favorites")
						|| linkName.equals("Policy 1151 - Training Operations.")
						|| linkName.equals("Training Policy / Data Privacy Notification")) {
					// This condition is to avoid other links except trainings
					// to avoid other links that appear on the page.
				} else {
					System.out.println("Link:" + linkName);
					WriteToExcel.writeList(linkName);
					Thread.sleep(2000);
					// To print actual Require training links name
				}
			}
		} catch (Exception e) {
			String UpcomingMessage = driver.findElement(By.xpath("//*[@id='upcomingTrainingPage']/div/div[2]/p"))
					.getText();
			System.out.println("Message from Upcoming Training:" + UpcomingMessage);
			String msg="Message from Upcoming Training:" + UpcomingMessage;
			WriteToExcel.writeList(msg);
			Thread.sleep(5000);
		}

		// Getting all the links in Upcoming Training page
		// Double click on Upcoming Training link
		Actions act111 = new Actions(driver);
		WebElement link3 = driver.findElement(By.xpath("//*[@id='menu_encTraining']/a"));
		act111.doubleClick(link3).build().perform();
		Thread.sleep(10000);
		// Here we are going to use Try-Catch block to handle exceptions
		// Taking lists of training in Upcoming Training page
		try {
			// Printing all links in a page
			// Storing all the links in a page to List variable
			java.util.List<WebElement> Ethics = driver.findElements(By.tagName("a"));
			// Giving the size of the links
			System.out.println("Total Links Found: " + Ethics.size());
			// To print all the link name
			for (int k = 1; k <= Ethics.size(); k = k + 1) {
				String linkName = Ethics.get(k).getText();
				// If statement is to filter out only the training names
				if (linkName.length() == 0 || linkName == null) {
					// If condition is to check the value stars with 0 & NULL
					// No Link name defined
				} else if (linkName.equals("myLearning") || linkName.equals(" CURRENT TRAINING")
						|| linkName.equals(" UPCOMING TRAINING") || linkName.equals(" ETHICS & COMPLIANCE")
						|| linkName.equals("Open Search box") || linkName.equals("Favorites")
						|| linkName.equals("Policy 1151 - Training Operations")
						|| linkName.equals("Training Policy / Data Privacy Notification")) {
					// This condition is to avoid other links except trainings
					// to avoid other links that appear on the page.
				} else {
					System.out.println("Link:" + linkName);
					WriteToExcel.writeList(linkName);
					Thread.sleep(2000);
					// To print actual Require training links name
				}
			}
		} catch (Exception e) {
			String EthichMessage = driver.findElement(By.xpath("//*[@id='encTrainingMessage']")).getText();
			System.out.println("Message from Ethics & Compliance:" + EthichMessage);
			String msg="Message from Ethics & Compliance:" + EthichMessage;
			WriteToExcel.writeList(msg);
			Thread.sleep(5000);

		}

		System.out.println("Execution is completed & We have got all the trainings that are pending in the portal");
		System.out.println("Sending Email...");
		WriteToExcel.sendEmail();
	}

}