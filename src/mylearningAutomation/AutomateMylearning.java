package mylearningAutomation;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions; //To mouse clicks operations
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomateMylearning {

	public static void main(String[] args) throws InterruptedException, IOException {
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
		System.out.println("launched Mylearning portal IE browser");
		Thread.sleep(30000);

		try {
			String getUserName, getPassword;

			getUserName = ExcelOperations.getInputData("UserName");
			getPassword = ExcelOperations.getInputData("Password");
			// Giving credentials

			driver.findElement(By.xpath("//*[@id='bySelection']/div[2]/div/span")).click();
			Thread.sleep(5000);

			// enter the password
			driver.findElement(By.name("UserName")).sendKeys(getUserName);
			driver.findElement(By.name("Password")).sendKeys(getPassword);
			// click on the signin button
			driver.findElement(By.xpath("//*[@id='submitButton']")).click();
			Thread.sleep(60000);
		} catch (Exception e) {
			System.out.println("Login Failed");
			driver.close();
		}

		System.out.println("Logged in");
		// get the Default checkbooks selected status of Remember this private
		// device
		boolean selectState = driver.findElement(By.xpath("//*[@id='vipRememberDevice']")).isSelected();
		System.out.println("Default selectState=" + selectState);
		// If the check box is enabled, below code will do uncheck for Remember
		// this private device option
		if (selectState == true) {
			driver.findElement(By.xpath("//*[@id='rememberDeviceLabel']")).click();
		}
		// get the Current checkbooks selected status of Remember this private
		// device
		boolean selectState1 = driver.findElement(By.xpath("//*[@id='vipRememberDevice']")).isSelected();
		System.out.println("Current selectState=" + selectState1);

		// To click on the link "DOnt have a security code"
		driver.findElement(By.xpath("//*[@id='vipOoblink']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='vipOobOptions']/label[1]")).click();
		// Click on Send button
		driver.findElement(By.xpath("//*[@id='vipSend']")).click();
		Thread.sleep(5000);
		// Check the confirmation message
		String text = driver.findElement(By.xpath("//*[@id='vipMessageContent']")).getText();
		System.out.println("Message is=" + text);
		Thread.sleep(2000);
		if (text.equals("A security code has been sent to 919*****86.")) {
			System.out.println("Please enter symantice code in the text box");
		} else {
			System.out.println("Script Failed, please rerun it again");
			driver.quit();
		}
		Thread.sleep(20000);
		// continue to login
		System.out.println("Clicking on Continue Button");

		Actions act = new Actions(driver);
		WebElement button = driver.findElement(By.xpath("//*[@id='vipSubmitOTP']"));
		act.doubleClick(button).build().perform();

		driver.findElement(By.xpath("//*[@id='vipSubmitOTP']")).click();
		Thread.sleep(60000);
		// Logged in to portal
		System.out.println("Reading Text from Notice window");
		Thread.sleep(10000);
		String text1 = driver.findElement(By.xpath("//*[@id='modalTimeZoneDataPrivacyBody']/div/p[2]")).getText();
		System.out.println("Notice message is=" + text1);
		Thread.sleep(10000);
		if (text1.equals(
				" The Time Zone set on your machine and the Time Zone set in myLearning do not match. Please update your time zone settings if needed. The myLearning time zone setting is adjusted via the 'My Profile' link which can be accessed by clicking on your Profile picture located in the top navigation bar.")) {
			System.out.println("User has logged in to Mylearning portal successfully");
			driver.findElement(By.xpath("//*[@id='btnOkTimezone']")).click();
		} else {
			System.out.println("Login Failed, please check");
			driver.findElement(By.xpath("//*[@id='btnOkTimezone']")).click();
		}
		// To display Welcome message
		String text2 = driver.findElement(By.xpath("//*[@id='sec_home_1']/div/div/div/segment/div/div[1]/h1"))
				.getText();
		System.out.println("Login successful," + text2);
		Thread.sleep(1000);
		// Click on Current link
		if (text2.equals("Hello Vinothkumar Periasamy,")) {
			driver.findElement(By.xpath("//*[@id='menu_current_training']/a")).click();
			Thread.sleep(10000);
			String text3 = driver.findElement(By.xpath("//*[@id='currentTrainingTitle']")).getText();
			System.out.println("Text3 is =" + text3);
		} else {
			// Double click on current training link
			Actions act1 = new Actions(driver);
			WebElement link1 = driver.findElement(By.xpath("//*[@id='menu_current_training']/a"));
			act1.doubleClick(link1).build().perform();
			Thread.sleep(10000);
			String text4 = driver.findElement(By.xpath("//*[@id='currentTrainingTitle']")).getText();
			System.out.println("Text4 is =" + text4);

			// To read title of the training card
		}

		System.out.println("Taking first training title");

		try {
			java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
			System.out.println("Total Links Found: " + links.size());

			for (int i = 1; i <= links.size(); i = i + 1)

			{
				String linkName = links.get(i).getText();
				if (linkName.length() == 0 || linkName == null) {
					// no link name defined
				} else if (linkName.equals("myLearning") || linkName.equals(" CURRENT TRAINING")
						|| linkName.equals(" UPCOMING TRAINING") || linkName.equals(" ETHICS & COMPLIANCE")
						|| linkName.equals("Open Search box") || linkName.equals("Favorites")
						|| linkName.equals("Training Policy / Data Privacy Notification")) {
					// to avoid other links that appear on the application.
				}

				else {
					System.out.println("Link:" + linkName);
				}
			}
		} catch (Exception e) {
			// System.out.println("Exception occurred and handled.");
		}

		System.out.println("mylearning page");
		Actions act1 = new Actions(driver);
		WebElement link1 = driver.findElement(By.xpath("//*[@id='menu_brand']/span"));
		act1.doubleClick(link1).build().perform();
		Thread.sleep(10000);
		String text5 = driver.findElement(By.xpath("//*[@id='menu_brand']/span")).getText();
		System.out.println("Text5 is =" + text5);

		try {
			java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
			System.out.println("Total Links Found: " + links.size());

			for (int j = 1; j <= links.size(); j = j + 1)

			{
				String linkName = links.get(j).getText();
				if (linkName.length() == 0 || linkName == null) {
					// no link name defined
				} else if (linkName.equals("X") || linkName.equals("Previous") || linkName.equals("Next")
						|| linkName.equals("See more from this Learning Path...") || linkName.equals("Open Search box")
						|| linkName.equals("Favorites")
						|| linkName.equals("Training Policy / Data Privacy Notification")
						|| linkName.equals("myLearning") || linkName.equals(" CURRENT TRAINING")
						|| linkName.equals(" UPCOMING TRAINING") || linkName.equals(" ETHICS & COMPLIANCE")) {
					// to avoid other links that appear on the application.
				}

				else {
					System.out.println("Link:" + linkName);
				}
			}
		} catch (Exception e) {
			// System.out.println("Exception occurred and handled.");
		}

	}

}
