import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollingRobot {

	public static void main(String[] args) throws AWTException, InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:100");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("user_name")).clear();
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).clear();
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.name("Login")).click();
		
		Robot rob = new Robot();
		
		rob.keyPress(KeyEvent.VK_PAGE_DOWN);
		rob.keyRelease(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		
		rob.keyPress(KeyEvent.VK_PAGE_UP);
		rob.keyRelease(KeyEvent.VK_PAGE_UP);
		Thread.sleep(2000);
		
		
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(2000);
		driver.quit();
		

	}

}
