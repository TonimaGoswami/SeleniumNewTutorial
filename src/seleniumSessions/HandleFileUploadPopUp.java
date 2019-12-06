package seleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFileUploadPopUp {

	public void login() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/tanu/Downloads/IMP-Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://html.com/input-type-file/");
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@id ='fileupload']"))
				.sendKeys("/Users/tanu/Downloads/Internship_Memorandum.rtf");
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		HandleFileUploadPopUp obj = new HandleFileUploadPopUp();
		obj.login();

	}

}
