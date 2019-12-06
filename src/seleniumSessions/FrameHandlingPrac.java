package seleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandlingPrac {
	WebDriver driver;

	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/tanu/Downloads/IMP-Drivers/chromedriver");
		driver = new ChromeDriver();
		// driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.spicejet.com/");

	}

	public void liveChat() throws InterruptedException {
		driver.findElement(By.xpath("*//div[@id='divChatButton']")).click();
		driver.switchTo().frame("iframe");
		driver.findElement(By.xpath("*//div[4]/input[@class='wc-shellinput']")).clear();

	}

	public static void main(String[] args) throws InterruptedException {
		FrameHandlingPrac obj = new FrameHandlingPrac();
		obj.setUp();
		obj.liveChat();

	}

}
