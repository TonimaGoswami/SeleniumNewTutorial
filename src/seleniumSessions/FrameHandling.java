package seleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandling {
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
		driver.get("https://www.freecrm.com");

	}

	public void login() throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys("ishita");
		driver.findElement(By.name("password")).sendKeys("141414");
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginBtn);
		Thread.sleep(3000);
		driver.switchTo().frame("mainpanel");
		// Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();

	}

	public void tearDown() {
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		FrameHandling handle = new FrameHandling();
		handle.setUp();
		handle.login();
		handle.tearDown();

	}

}
