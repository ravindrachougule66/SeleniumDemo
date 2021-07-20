import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
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
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.name("Customise")).click();
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.dragAndDrop(driver.findElement(By.id("cl1")),driver.findElement(By.id("cl6"))).build().perform();
		Thread.sleep(2000);
		
		act.clickAndHold(driver.findElement(By.id("cl6"))).build().perform();
		Thread.sleep(2000);
		act.moveToElement(driver.findElement(By.id("cl1"))).build().perform();
		Thread.sleep(2000);
		act.release().build().perform();
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(2000);
		driver.quit();

	}

}
