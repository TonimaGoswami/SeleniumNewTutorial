package seleniumSessions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElements {
	WebDriver driver;

	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/tanu/Downloads/IMP-Drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.half.ebay.com");
	}

	public void countLinks() {
		// get the count of links on the page
		List<WebElement> linkList = driver.findElements(By.tagName("a"));
		// print size of arrayList
		System.out.println(linkList.size());

		// get the text of links on the page
		for (int i = 0; i < linkList.size(); i++) {
			String linkText = linkList.get(i).getText();
			System.out.println(linkText);

		}

	}

	public static void main(String[] args) {
		FindElements obj = new FindElements();
		obj.setUp();
		obj.countLinks();

	}

}
