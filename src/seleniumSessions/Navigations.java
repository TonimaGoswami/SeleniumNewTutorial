package seleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigations {
	WebDriver driver;
	
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/tanu/Downloads/IMP-Drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
	}
	
	public void navigateTo() throws InterruptedException {
		driver.navigate().to("http://www.amazon.com");
		// back and forward simulation
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().back();
		driver.navigate().refresh();
		driver.quit();
	}
	
	
	

	public static void main(String[] args) throws InterruptedException {
		Navigations obj = new Navigations();
		obj.setUp();
		obj.navigateTo();
	}

}
