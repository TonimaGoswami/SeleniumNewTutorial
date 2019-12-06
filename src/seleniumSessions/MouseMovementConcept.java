package seleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovementConcept {

	WebDriver driver;

	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/tanu/Downloads/IMP-Drivers/chromedriver");
		driver = new ChromeDriver();
		// driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.spicejet.com/");

	}

	public void login() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(
				driver.findElement(By.xpath("*//li[@class='li-login float-right']/a[@id='ctl00_HyperLinkLogin']")))
				.build().perform();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Corporate Accounts")).click();
		driver.quit();

	}

	public static void main(String[] args) throws InterruptedException {
		MouseMovementConcept obj = new MouseMovementConcept();
		obj.setUp();
		obj.login();

	}

}
