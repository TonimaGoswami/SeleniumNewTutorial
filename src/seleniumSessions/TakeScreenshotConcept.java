package seleniumSessions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenshotConcept {
	
WebDriver driver;
	
	public void setUp() throws IOException {
		System.setProperty("webdriver.chrome.driver", "/Users/tanu/Downloads/IMP-Drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		//Take screenshot and store as a file format
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//now copy the screenshot at desired location using CopyFile method
		FileUtils.copyFile(src, new File("/Users/tanu/Documents/workspace/SeleniumNewTutorial/src/seleniumSessions/google.png"));
		driver.quit();
	}
	

	public static void main(String[] args) throws IOException {
		TakeScreenshotConcept ob = new TakeScreenshotConcept();
		ob.setUp();

	}

}
