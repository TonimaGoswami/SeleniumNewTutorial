package seleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopUpHandle {

	public void login() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/tanu/Downloads/IMP-Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.name("proceed")).click(); 	// click on Go button
		Thread.sleep(5);
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText()); 				// get the text of alert and print it

		String text = alert.getText();
		if (text.equals("Please enter a valid user name")) {
			System.out.println("Correct alert message");
		} else {
			System.out.println("In-Correct alert message");
		}

		alert.accept(); 									// click Ok button
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		AlertPopUpHandle obj = new AlertPopUpHandle();
		obj.login();
		

	}

}
