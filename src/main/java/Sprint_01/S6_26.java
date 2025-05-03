package Sprint_01;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class S6_26 {
	
	@Test
	public void testA() throws InterruptedException
	{
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Login to https://login.salesforce.com
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
			//Login button
		driver.findElement(By.id("Login")).click();
			//Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
			//Click View All and click Legal Entities from App Launcher
		WebElement element = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		driver.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		
			//Click on the legal Entities tab 
		WebElement element2 = driver.findElement(By.xpath("//a[@title='Legal Entities']"));
		driver.executeScript("arguments[0].click();", element2);
		Thread.sleep(3000);

			//Click the sort arrow in the Last Modified Date.
		WebElement element3 = driver.findElement(By.xpath("(//span[text()='Sort'])[2]"));
		driver.executeScript("arguments[0].click();", element3);
		Thread.sleep(3000);
		WebElement element4 = driver.findElement(By.xpath("(//span[text()='Sort'])[2]"));
		driver.executeScript("arguments[0].click();", element4);
		//driver.findElement(By.xpath("(//span[text()='Sort'])[2]")).click();

			//Verify the Legal Entities displayed in ascending order by Last Modified Date.
		Thread.sleep(3000);
		String text = driver.findElement(By.xpath("//span[@data-aura-class='uiOutputDateTime']")).getText();
		System.out.println(text);
			//Expected Result: Legal Entities Should be displayed in ascending order by Last Modified Date.

	}

}
