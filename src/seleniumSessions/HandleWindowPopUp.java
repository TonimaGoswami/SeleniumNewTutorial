package seleniumSessions;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindowPopUp {
	public void login() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/tanu/Downloads/IMP-Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.popuptest.com/goodpopups.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.cssSelector("a.black")).click();
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		String ParentWindowId = it.next();
		System.out.println("Parent window ID:" + ParentWindowId);

		String ChildWindowId = it.next();
		System.out.println("Child window ID:" + ChildWindowId);
		driver.switchTo().window(ChildWindowId);
		System.out.println("Child window title:" + driver.getTitle());
		driver.close();
		Thread.sleep(5);
		driver.switchTo().window(ParentWindowId);
		System.out.println("Parent window title:" + driver.getTitle());
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		HandleWindowPopUp obj = new HandleWindowPopUp();
		obj.login();

	}

}
