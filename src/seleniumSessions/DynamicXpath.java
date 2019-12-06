package seleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicXpath {
	WebDriver driver;

	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/tanu/Downloads/IMP-Drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.half.ebay.com");

	}

	public void searchItem() {
		driver.findElement(By.xpath("*//input[@class='gh-tb ui-autocomplete-input']")).sendKeys("Java");
		// driver.findElement(By.xpath("//input[contains(@class, 'gh-tb
		// ui-autocomplete-input')]")).sendKeys("Java");
		driver.findElement(By.xpath("//a[contains(text(), 'Sign in')]")).click();

	}

	public static void main(String[] args) {
		DynamicXpath object = new DynamicXpath();
		object.setUp();
		object.searchItem();

	}

}
