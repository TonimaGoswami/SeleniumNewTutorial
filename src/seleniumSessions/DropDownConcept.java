package seleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DropDownConcept {
	WebDriver driver;

	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/tanu/Downloads/IMP-Drivers/chromedriver");
		driver = new ChromeDriver(); // launch chrome
		// driver.manage().window().maximize(); //maximize window
		driver.manage().deleteAllCookies(); // delete cookies
		// dynamic waits
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// enter Url
		driver.get("https://www.jqueryui.com/droppable/");

	}

	public void handleDropDown() {
		driver.switchTo().frame(0); // switch to frame no.1(index-0)

		Actions action = new Actions(driver);
		action.clickAndHold(driver.findElement(By.cssSelector("div#draggable")))
				.moveToElement(driver.findElement(By.cssSelector("div#droppable"))).release().build().perform();

		driver.quit();

	}

	public static void main(String[] args) {
		DropDownConcept ob = new DropDownConcept();
		ob.setUp();
		ob.handleDropDown();

	}

}
