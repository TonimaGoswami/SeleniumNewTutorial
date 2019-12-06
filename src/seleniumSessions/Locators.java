package seleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
	WebDriver driver;

	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/tanu/Downloads/IMP-Drivers/chromedriver");
		driver = new ChromeDriver(); // launch chrome
		// driver.manage().window().maximize(); //maximize window
		// driver.manage().deleteAllCookies(); //delete cookies
		// dynamic waits
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// enter Url
		driver.get("https://www.");

	}

	public static void main(String[] args) {

	}

}
