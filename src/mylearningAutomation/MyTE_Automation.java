package mylearningAutomation;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class MyTE_Automation {

	public static void main(String[] args) throws InterruptedException, IOException {
		String pwd = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", pwd + "\\Software\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// Maximizing the window
		driver.manage().window().maximize();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
		// navigate to myTE portal
		driver.get("https://myte.accenture.com/");
		System.out.println("launched MyTE portal and wait for 10secs to perfrom next step");
		Thread.sleep(10000);
		String getUserName, getPassword, Mon1, Tue1, Wed1, Thu1, Fri1, Sat1, Sun1, Mon2, Tue2, Wed2, Thu2, Fri2, Sat2,
				Sun2, Mon3, Tue3;

		// Used Try-Catch block to handle login exception
		try {
			/*
			 * driver.findElement(By.xpath(
			 * "//*[@id='bySelection']/div[2]/div/span")).click();
			 * Thread.sleep(5000);
			 */

			getUserName = ExcelHandling_Myte.getInputData("UserName");
			getPassword = ExcelHandling_Myte.getInputData("Password");
			// enter the password
			driver.findElement(By.name("UserName")).sendKeys(getUserName);
			driver.findElement(By.name("Password")).sendKeys(getPassword);
			System.out.println("Entered user credentials");
			// click on the signin button
			driver.findElement(By.xpath("//*[@id='submitButton']")).click();
			System.out.println("Clicked on Sign in button");
			Thread.sleep(20000);
			try {
				String LoginFailed = driver.findElement(By.xpath("//*[@id='errorText']")).getText();
				if (LoginFailed.equals(
						"Incorrect user ID or password. Type the correct user ID and password, and try again.")) {
					System.out.println(LoginFailed);
					System.out.println("Since Login is failed,Closing the browser to stop the execution");
					driver.quit();
				}
			} catch (Exception e) {
			}
		} catch (Exception e) {
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
		/*
		 * // get the Current checkbooks selected status of Remember this
		 * private check box
		 */
		boolean selectState1 = driver.findElement(By.xpath("//*[@id='vipRememberDevice']")).isSelected();
		// This result will be boolean
		System.out.println("Current select State is=" + selectState1);

		// To get the symantic code below codes will be performed
		driver.findElement(By.xpath("//*[@id='vipOoblink']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='vipOobOptions']/label[1]")).click();
		// Click on Send button
		driver.findElement(By.xpath("//*[@id='vipSend']")).click();
		Thread.sleep(15000);
		// Check the confirmation message
		String text = driver.findElement(By.xpath("//*[@id='vipMessageContent']")).getText();
		System.out.println("Message is=" + text);
		Thread.sleep(15000);

		/*
		 * Once user enters security code, below codes will be performed to
		 * proceed
		 */
		Actions act = new Actions(driver);
		WebElement button = driver.findElement(By.xpath("//*[@id='vipSubmitOTP']"));
		act.doubleClick(button).build().perform();
		System.out.println("Logged in successfully.Lets wait for few moments to navigate to home page");

		/*
		 * String codenotreceived =
		 * driver.findElement(By.xpath("//*[@id='vipMessageContent']")).getText(
		 * ); System.out.println("Message is=" + codenotreceived);
		 * driver.close();
		 */

		// Once user enters the security code and clicked on continue
		Thread.sleep(10000);
		// User has logged in to myTE portal
		String Title = driver.findElement(By.xpath("//*[@id='gaMain']/tbody/tr/td/div/h1")).getText();
		System.out.println("Reached myte=" + Title);
		driver.findElement(By.xpath("//*[@id='ctl00_MainContentPlaceHolder_AnnouncementControl_lnk_Enter2']")).click();
		String EmployeeName = driver
				.findElement(By.xpath("//*[@id='ctl00_ctl00_MainContentPlaceHolder_lnk_EmployeeNameText']")).getText();
		System.out.println("Hi," + EmployeeName);

		System.out.println("Entered in to MYTE");
		Thread.sleep(2000);

		Thread.sleep(2000);

		// click mytebox
		WebElement myteBox = driver.findElement(By.xpath("//td[@adr=\'0\' and	 @idx=\'0\']"));
		myteBox.click();
		System.out.println("Clicked the myte box");
		Thread.sleep(2000);

		// Click on assignment
		WebElement clickAssignment = driver.findElement(By.id("x:1665319875.4:mkr:ButtonImage"));
		clickAssignment.click();
		System.out.println("Selected the assignment field");
		Thread.sleep(2000);

		// Select the assignment
		WebElement selectAssignment = driver.findElement(By.id("x:1846955549.13:adr:32:tag:"));
		selectAssignment.click();
		System.out.println("Selected the trainings charge code");
		Thread.sleep(2000);

		// Getting values for 1st week
		Mon1 = ExcelHandling_Myte.getInputData("Mon1");
		Tue1 = ExcelHandling_Myte.getInputData("Tue1");
		Wed1 = ExcelHandling_Myte.getInputData("Wed1");
		Thu1 = ExcelHandling_Myte.getInputData("Thu1");
		Fri1 = ExcelHandling_Myte.getInputData("Fri1");
		Sat1 = ExcelHandling_Myte.getInputData("Sat1");
		Sun1 = ExcelHandling_Myte.getInputData("Sun1");

		// Getting values for 2nd Week
		Mon2 = ExcelHandling_Myte.getInputData("Mon2");
		Tue2 = ExcelHandling_Myte.getInputData("Tue2");
		Wed2 = ExcelHandling_Myte.getInputData("Wed2");
		Thu2 = ExcelHandling_Myte.getInputData("Thu2");
		Fri2 = ExcelHandling_Myte.getInputData("Fri2");
		Sat2 = ExcelHandling_Myte.getInputData("Sat2");
		Sun2 = ExcelHandling_Myte.getInputData("Sun2");

		// Getting values for 3rd Week
		Mon3 = ExcelHandling_Myte.getInputData("Mon3");
		Tue3 = ExcelHandling_Myte.getInputData("Tue3");

		// Click on cell1
		// Setting 9hrs to Monday cell

		/*
		 * System.out.println("Setting 9hrs to Monday cell"); WebElement
		 * clickCell1 =
		 * driver.findElement(By.xpath("//*[@id='x:-33.10000:adr:0']/td[3]"));
		 * clickCell1.click(); clickCell1.sendKeys(Mon1); Thread.sleep(1000);
		 * 
		 * // Setting 9hrs to Tuesday cell
		 * System.out.println("Setting 9hrs to Tuesday cell"); WebElement
		 * clickCell2 =
		 * driver.findElement(By.xpath("//*[@id='x:-33.10000:adr:0']/td[4]"));
		 * clickCell2.click(); clickCell2.sendKeys(Tue1); Thread.sleep(1000);
		 * 
		 * // Setting 9hrs to Wednesday cell
		 * System.out.println("Setting 9hrs to Wednesday cell"); WebElement
		 * clickCell3 =
		 * driver.findElement(By.xpath("//*[@id='x:-33.10000:adr:0']/td[5]"));
		 * clickCell3.click(); clickCell3.sendKeys(Wed1); Thread.sleep(1000);
		 * 
		 * // Setting 9hrs to Thursday cell
		 * System.out.println("Setting 9hrs to Thursday cell"); WebElement
		 * clickCell4 =
		 * driver.findElement(By.xpath("//*[@id='x:-33.10000:adr:0']/td[6]"));
		 * clickCell4.click(); clickCell4.sendKeys(Thu1); Thread.sleep(1000);
		 * 
		 * // Setting 9hrs to Friday cell
		 * System.out.println("Setting 9hrs to Friday cell"); WebElement
		 * clickCell5 =
		 * driver.findElement(By.xpath("//*[@id='x:-33.10000:adr:0']/td[7]"));
		 * clickCell5.click(); clickCell5.sendKeys(Fri1); Thread.sleep(1000);
		 * 
		 * // Setting 9hrs to Saturday cell
		 * System.out.println("Setting 9hrs to Saturday cell"); WebElement
		 * clickCell6 =
		 * driver.findElement(By.xpath("//*[@id='x:-33.10000:adr:0']/td[8]"));
		 * clickCell6.click(); clickCell6.sendKeys(Sat1); Thread.sleep(1000);
		 * 
		 * // Setting 9hrs to Sunday cell
		 * System.out.println("Setting 9hrs to Sunday cell"); WebElement
		 * clickCell7 =
		 * driver.findElement(By.xpath("//*[@id='x:-33.10000:adr:0']/td[9]"));
		 * clickCell7.click(); clickCell7.sendKeys(Sun1); Thread.sleep(1000);
		 * 
		 * // Setting 9hrs to Monday cell
		 * System.out.println("Setting 9hrs to Monday cell"); WebElement
		 * clickCell8 =
		 * driver.findElement(By.xpath("//*[@id='x:-33.10000:adr:0']/td[10]"));
		 * clickCell8.click(); clickCell8.sendKeys(Mon2); Thread.sleep(1000);
		 * 
		 * // Setting 9hrs to Tuesday cell
		 * System.out.println("Setting 9hrs to Tuesday cell"); WebElement
		 * clickCell9 =
		 * driver.findElement(By.xpath("//*[@id='x:-33.10000:adr:0']/td[11]"));
		 * clickCell9.click(); clickCell9.sendKeys(Tue2); Thread.sleep(1000);
		 * 
		 * // Setting 9hrs to Wednesday cell
		 * System.out.println("Setting 9hrs to Wednesday cell"); WebElement
		 * clickCell10 =
		 * driver.findElement(By.xpath("//*[@id='x:-33.10000:adr:0']/td[12]"));
		 * clickCell10.click(); clickCell10.sendKeys(Wed2); Thread.sleep(1000);
		 * 
		 * // Setting 9hrs to Thursday cell
		 * System.out.println("Setting 9hrs to Thursday cell"); WebElement
		 * clickCell11 =
		 * driver.findElement(By.xpath("//*[@id='x:-33.10000:adr:0']/td[13]"));
		 * clickCell11.click(); clickCell11.sendKeys(Thu2); Thread.sleep(1000);
		 * 
		 * // Setting 9hrs to Friday cell
		 * System.out.println("Setting 9hrs to Friday cell"); WebElement
		 * clickCell12 =
		 * driver.findElement(By.xpath("//*[@id='x:-33.10000:adr:0']/td[14]"));
		 * clickCell12.click(); clickCell12.sendKeys(Fri2); Thread.sleep(1000);
		 * 
		 * // Setting 9hrs to Saturday cell
		 * System.out.println("Setting 9hrs to Saturday cell"); WebElement
		 * clickCell13 =
		 * driver.findElement(By.xpath("//*[@id='x:-33.10000:adr:0']/td[15]"));
		 * clickCell13.click(); clickCell13.sendKeys(Sat2); Thread.sleep(1000);
		 * 
		 * // Setting 9hrs to Sunday cell
		 * System.out.println("Setting 9hrs to Sunday cell"); WebElement
		 * clickCell14 =
		 * driver.findElement(By.xpath("//*[@id='x:-33.10000:adr:0']/td[16]"));
		 * clickCell14.click(); clickCell14.sendKeys(Sun2); Thread.sleep(1000);
		 * 
		 * // Setting 9hrs to Monday cell
		 * System.out.println("Setting 9hrs to Monday cell"); WebElement
		 * clickCell15 =
		 * driver.findElement(By.xpath("//*[@id='x:-33.10000:adr:0']/td[17]"));
		 * clickCell15.click(); clickCell15.sendKeys(Mon3); Thread.sleep(1000);
		 * 
		 * // Setting 9hrs to Tuesday cell
		 * System.out.println("Setting 9hrs to Tuesday cell"); WebElement
		 * clickCell16 =
		 * driver.findElement(By.xpath("//*[@id='x:-33.10000:adr:0']/td[18]"));
		 * clickCell16.click(); clickCell16.sendKeys(Tue3); Thread.sleep(1000);
		 * System.out.println("Filled required hours to all the fields");
		 */

		// Selecting first Day location
		System.out.println("Selecting Locations");
		driver.findElement(By.xpath("//*[@id='locationByDayCell_0']")).click();
		System.out.println("Location window is opened");
		Thread.sleep(2000);

		driver.switchTo().frame("LocationByDayPopupIFrame");
		System.out.println("Focused on IFrame");
		// Selecting Country
		WebElement Country1 = driver.findElement(By.id("ctl00_PopupContentPlaceHolder_homeOfficeSelector_ddlCountry"));
		Country1.sendKeys("IN");
		System.out.println("Selected Country as INDIA");
		Thread.sleep(1000);

		/*
		 * // Saving the location driver.findElement(By.xpath(
		 * "//*[@id='ctl00_PopupContentPlaceHolder_locationByDayOkButton']")).
		 * click(); Thread.sleep(1000);
		 */
		// Selecting Location1
		try {
			driver.findElement(By.id("ctl00_PopupContentPlaceHolder_homeOfficeSelector_ddlLocation1")).click();
			Select Location11 = new Select(driver
					.findElement(By.xpath("//*[@id='ctl00_PopupContentPlaceHolder_homeOfficeSelector_ddlLocation1']")));
			Location11.selectByVisibleText("Bengaluru");
			System.out.println("Selected Bengalore by visible text");
			Thread.sleep(2000);
		} catch (Exception e) {
			WebElement Location11 = driver
					.findElement(By.id("ctl00_PopupContentPlaceHolder_homeOfficeSelector_ddlLocation1"));
			Location11.sendKeys("01/01");
			System.out.println("Selected Bengalore by value 01/01(By ID)");
			Thread.sleep(2000);
		}
		

		// Selecting Location2
		WebElement Location21 = driver
				.findElement(By.id("ctl00_PopupContentPlaceHolder_homeOfficeSelector_ddlLocation2"));
		Location21.sendKeys(
				"BDC7  - Pritech Park (SEZ), Sarjapur - Marathalli Outer Ring Road, Sy. No. 51 - 64/4,Bellandur Village, Varthur Hobli, Bangalore - 560103, INDIA");
		System.out.println("Selected Location2 as BDC7..");
		Thread.sleep(1000);

		// Checking Radio button selection status
		boolean status1 = driver.findElement(By.xpath("//*[@id='ctl00_PopupContentPlaceHolder_currentDayRadio']"))
				.isSelected();
		System.out.println("Selected Day only: Status is(by Xpath)=" + status1);
		Thread.sleep(1000);
		/*
		 * If the "Selected Day only" option is not selected, below code will
		 * perform to select the option
		 */
		if (status1 == false) {
			driver.findElement(By.xpath("//*[@id='ctl00_PopupContentPlaceHolder_currentDayRadio']")).click();
		} else {
			System.out.println("Radio button 'Selected Day only' is selected");
		}

		// Saving the location
		driver.findElement(By.xpath("//*[@id='ctl00_PopupContentPlaceHolder_locationByDayOkButton']")).click();
		System.out.println("wait for few second to save First location");
		Thread.sleep(5000);

		// Selecting second Day location
		System.out.println("Selecting Locations");
		driver.findElement(By.xpath("//*[@id='locationByDayCell_1']")).click();
		System.out.println("Location window is opened");
		Thread.sleep(2000);

		driver.switchTo().frame("LocationByDayPopupIFrame");
		System.out.println("Focused on IFrame");
		// Selecting Country
		WebElement Country2 = driver.findElement(By.id("ctl00_PopupContentPlaceHolder_homeOfficeSelector_ddlCountry"));
		Country2.sendKeys("IN");
		System.out.println("Selected Country as INDIA");
		Thread.sleep(1000);

		// Saving the location
		driver.findElement(By.xpath("//*[@id='ctl00_PopupContentPlaceHolder_locationByDayOkButton']")).click();
		Thread.sleep(2000);

		// Selecting Location1
		try {
			driver.findElement(By.id("ctl00_PopupContentPlaceHolder_homeOfficeSelector_ddlLocation1")).click();
			Select Location12 = new Select(driver
					.findElement(By.xpath("//*[@id='ctl00_PopupContentPlaceHolder_homeOfficeSelector_ddlLocation1']")));
			Location12.selectByVisibleText("Bengaluru");
			System.out.println("Selected Bengalore by visible text");
			Thread.sleep(2000);
		} catch (Exception e) {
			WebElement Location12 = driver
					.findElement(By.id("ctl00_PopupContentPlaceHolder_homeOfficeSelector_ddlLocation1"));
			Location12.sendKeys("01/01");
			System.out.println("Selected Bengalore by value 01/01(By ID)");
			Thread.sleep(2000);
		}
		// Selecting Location2
		WebElement Location22 = driver
				.findElement(By.id("ctl00_PopupContentPlaceHolder_homeOfficeSelector_ddlLocation2"));
		Location22.sendKeys(
				"BDC7  - Pritech Park (SEZ), Sarjapur - Marathalli Outer Ring Road, Sy. No. 51 - 64/4,Bellandur Village, Varthur Hobli, Bangalore - 560103, INDIA");
		System.out.println("Selected Location2 as BDC7..");
		Thread.sleep(1000);

		// Checking Radio button selection status
		boolean status2 = driver.findElement(By.xpath("//*[@id='ctl00_PopupContentPlaceHolder_currentDayRadio']"))
				.isSelected();
		System.out.println("Selected Day only: Status is(by Xpath)=" + status2);
		Thread.sleep(1000);
		/*
		 * If the "Selected Day only" option is not selected, below code will
		 * perform to select the option
		 */
		if (status2 == false) {
			driver.findElement(By.xpath("//*[@id='ctl00_PopupContentPlaceHolder_currentDayRadio']")).click();
		} else {
			System.out.println("Radio button 'Selected Day only' is selected");
		}

		// Saving the location
		driver.findElement(By.xpath("//*[@id='ctl00_PopupContentPlaceHolder_locationByDayOkButton']")).click();
		System.out.println("Wait for few seconds to save second location");
		Thread.sleep(5000);

		// Selecting Third Day location
		System.out.println("Selecting Locations");
		driver.findElement(By.xpath("//*[@id='locationByDayCell_2']")).click();
		System.out.println("Location window is opened");
		Thread.sleep(2000);

		driver.switchTo().frame("LocationByDayPopupIFrame");
		System.out.println("Focused on IFrame");
		// Selecting Country
		WebElement Country3 = driver.findElement(By.id("ctl00_PopupContentPlaceHolder_homeOfficeSelector_ddlCountry"));
		Country3.sendKeys("IN");
		System.out.println("Selected Country as INDIA");
		Thread.sleep(1000);

		// Saving the location
		driver.findElement(By.xpath("//*[@id='ctl00_PopupContentPlaceHolder_locationByDayOkButton']")).click();
		Thread.sleep(1000);

		// Selecting Location1
		
		try {
			driver.findElement(By.id("ctl00_PopupContentPlaceHolder_homeOfficeSelector_ddlLocation1")).click();
			Select Location13 = new Select(driver
					.findElement(By.xpath("//*[@id='ctl00_PopupContentPlaceHolder_homeOfficeSelector_ddlLocation1']")));
			Location13.selectByVisibleText("Bengaluru");
			System.out.println("Selected Bengalore by visible text");
			Thread.sleep(2000);
		} catch (Exception e) {
			WebElement Location13 = driver
					.findElement(By.id("ctl00_PopupContentPlaceHolder_homeOfficeSelector_ddlLocation1"));
			Location13.sendKeys("01/01");
			System.out.println("Selected Bengalore by value 01/01(By ID)");
			Thread.sleep(2000);
		}
		// Selecting Location2
		WebElement Location23 = driver
				.findElement(By.id("ctl00_PopupContentPlaceHolder_homeOfficeSelector_ddlLocation2"));
		Location23.sendKeys(
				"BDC7  - Pritech Park (SEZ), Sarjapur - Marathalli Outer Ring Road, Sy. No. 51 - 64/4,Bellandur Village, Varthur Hobli, Bangalore - 560103, INDIA");
		System.out.println("Selected Location2 as BDC7..");
		Thread.sleep(1000);

		// Checking Radio button selection status
		boolean status3 = driver.findElement(By.xpath("//*[@id='ctl00_PopupContentPlaceHolder_currentDayRadio']"))
				.isSelected();
		System.out.println("Selected Day only: Status is(by Xpath)=" + status3);
		Thread.sleep(1000);
		/*
		 * If the "Selected Day only" option is not selected, below code will
		 * perform to select the option
		 */
		if (status3 == false) {
			driver.findElement(By.xpath("//*[@id='ctl00_PopupContentPlaceHolder_currentDayRadio']")).click();
		} else {
			System.out.println("Radio button 'Selected Day only' is selected");
		}

		// Saving the location
		driver.findElement(By.xpath("//*[@id='ctl00_PopupContentPlaceHolder_locationByDayOkButton']")).click();
		System.out.println("Wait for few seconds to save Third location");
		Thread.sleep(5000);

		// Selecting Fourth Day location
		System.out.println("Selecting Locations");
		driver.findElement(By.xpath("//*[@id='locationByDayCell_3']")).click();
		System.out.println("Location window is opened");
		Thread.sleep(2000);

		driver.switchTo().frame("LocationByDayPopupIFrame");
		System.out.println("Focused on IFrame");
		// Selecting Country
		WebElement Country4 = driver.findElement(By.id("ctl00_PopupContentPlaceHolder_homeOfficeSelector_ddlCountry"));
		Country4.sendKeys("IN");
		System.out.println("Selected Country as INDIA");
		Thread.sleep(1000);

		// Saving the location
		driver.findElement(By.xpath("//*[@id='ctl00_PopupContentPlaceHolder_locationByDayOkButton']")).click();
		Thread.sleep(1000);

		// Selecting Location1
		try {
			driver.findElement(By.id("ctl00_PopupContentPlaceHolder_homeOfficeSelector_ddlLocation1")).click();
			Select Location14 = new Select(driver
					.findElement(By.xpath("//*[@id='ctl00_PopupContentPlaceHolder_homeOfficeSelector_ddlLocation1']")));
			Location14.selectByVisibleText("Bengaluru");
			System.out.println("Selected Bengalore by visible text");
			Thread.sleep(2000);
		} catch (Exception e) {
			WebElement Location14 = driver
					.findElement(By.id("ctl00_PopupContentPlaceHolder_homeOfficeSelector_ddlLocation1"));
			Location14.sendKeys("01/01");
			System.out.println("Selected Bengalore by value 01/01(By ID)");
			Thread.sleep(2000);
		}
		// Selecting Location2
		WebElement Location24 = driver
				.findElement(By.id("ctl00_PopupContentPlaceHolder_homeOfficeSelector_ddlLocation2"));
		Location24.sendKeys(
				"BDC7  - Pritech Park (SEZ), Sarjapur - Marathalli Outer Ring Road, Sy. No. 51 - 64/4,Bellandur Village, Varthur Hobli, Bangalore - 560103, INDIA");
		System.out.println("Selected Location2 as BDC7..");
		Thread.sleep(1000);

		// Checking Radio button selection status
		boolean status4 = driver.findElement(By.xpath("//*[@id='ctl00_PopupContentPlaceHolder_currentDayRadio']"))
				.isSelected();
		System.out.println("Selected Day only: Status is(by Xpath)=" + status4);
		Thread.sleep(1000);
		/*
		 * If the "Selected Day only" option is not selected, below code will
		 * perform to select the option
		 */
		if (status4 == false) {
			driver.findElement(By.xpath("//*[@id='ctl00_PopupContentPlaceHolder_currentDayRadio']")).click();
		} else {
			System.out.println("Radio button 'Selected Day only' is selected");
		}

		// Saving the location
		driver.findElement(By.xpath("//*[@id='ctl00_PopupContentPlaceHolder_locationByDayOkButton']")).click();
		System.out.println("Wait for few seconds to save Fourth location");
		Thread.sleep(5000);

		// Selecting Fifth Day location
		System.out.println("Selecting Locations");
		driver.findElement(By.xpath("//*[@id='locationByDayCell_4']")).click();
		System.out.println("Location window is opened");
		Thread.sleep(2000);

		driver.switchTo().frame("LocationByDayPopupIFrame");
		System.out.println("Focused on IFrame");
		// Selecting Country
		WebElement Country5 = driver.findElement(By.id("ctl00_PopupContentPlaceHolder_homeOfficeSelector_ddlCountry"));
		Country5.sendKeys("IN");
		System.out.println("Selected Country as INDIA");
		Thread.sleep(1000);

		// Saving the location
		driver.findElement(By.xpath("//*[@id='ctl00_PopupContentPlaceHolder_locationByDayOkButton']")).click();
		Thread.sleep(1000);

		// Selecting Location1
		try {
			driver.findElement(By.id("ctl00_PopupContentPlaceHolder_homeOfficeSelector_ddlLocation1")).click();
			Select Location15 = new Select(driver
					.findElement(By.xpath("//*[@id='ctl00_PopupContentPlaceHolder_homeOfficeSelector_ddlLocation1']")));
			Location15.selectByVisibleText("Bengaluru");
			System.out.println("Selected Bengalore by visible text");
			Thread.sleep(2000);
		} catch (Exception e) {
			WebElement Location15 = driver
					.findElement(By.id("ctl00_PopupContentPlaceHolder_homeOfficeSelector_ddlLocation1"));
			Location15.sendKeys("01/01");
			System.out.println("Selected Bengalore by value 01/01(By ID)");
			Thread.sleep(2000);
		}
		// Selecting Location2
		WebElement Location25 = driver
				.findElement(By.id("ctl00_PopupContentPlaceHolder_homeOfficeSelector_ddlLocation2"));
		Location25.sendKeys(
				"BDC7  - Pritech Park (SEZ), Sarjapur - Marathalli Outer Ring Road, Sy. No. 51 - 64/4,Bellandur Village, Varthur Hobli, Bangalore - 560103, INDIA");
		System.out.println("Selected Location2 as BDC7..");
		Thread.sleep(1000);

		// Checking Radio button selection status
		boolean status5 = driver.findElement(By.xpath("//*[@id='ctl00_PopupContentPlaceHolder_currentDayRadio']"))
				.isSelected();
		System.out.println("Selected Day only: Status is(by Xpath)=" + status5);
		Thread.sleep(1000);
		/*
		 * If the "Selected Day only" option is not selected, below code will
		 * perform to select the option
		 */
		if (status5 == false) {
			driver.findElement(By.xpath("//*[@id='ctl00_PopupContentPlaceHolder_currentDayRadio']")).click();
		} else {
			System.out.println("Radio button 'Selected Day only' is selected");
		}

		// Saving the location
		driver.findElement(By.xpath("//*[@id='ctl00_PopupContentPlaceHolder_locationByDayOkButton']")).click();
		System.out.println("Wait for few seconds to save Fifth location");
		Thread.sleep(5000);

	}
}