package mylearningAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class OpenIE {

	public static void main(String[] args) {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		String pwd=  System.getProperty("user.dir");	
		System.setProperty("webdriver.ie.driver",pwd+"\\Software\\IEDriverServer.exe");
		WebDriver driver=new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(200,TimeUnit.SECONDS);
		driver.get("http://mylearning.accenture.com");
	}

}
