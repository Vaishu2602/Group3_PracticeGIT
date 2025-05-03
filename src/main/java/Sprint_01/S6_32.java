package Sprint_01;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class S6_32 {

	@Test
	public void testA() throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Login to https://login.salesforce.com
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		// Login button
		driver.findElement(By.id("Login")).click();
		// Click on the toggle menu button from the left corner
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//Click View All and click Dashboards from App Launcher
		WebElement element = driver.findElement(By.xpath("//p[text()='Dashboards']"));
		driver.executeScript("arguments[0].click();", element);
		
		//Click on the Dashboards tab 
		WebElement element1 = driver.findElement(By.xpath("//span[text()='Dashboards']"));
		driver.executeScript("arguments[0].click();", element1);

		//Search the Dashboard 'Salesforce Automation by *Your Name*'
		driver.findElement(By.xpath("//input[@placeholder='Search recent dashboards...']")).sendKeys("By Aravinth");
		Thread.sleep(3000);
		//Click on the Dropdown icon and Select Subscribe
		WebElement element2 = driver.findElement(By.xpath("(//button[@type='button'])[15]"));
		driver.executeScript("arguments[0].click();", element2);
		driver.findElement(By.xpath("//span[text()='Subscribe']")).click();

		//Select frequency as 'Daily' and Click on Save in the Edit Subscription popup window.
		driver.findElement(By.xpath("//span[text()='Daily']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
		//Verify Whether the dashboard is subscribed. 
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		System.out.println(text);
		
	}

}
