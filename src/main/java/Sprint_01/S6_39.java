package Sprint_01;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class S6_39 {

	@Test
	public void testA() throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		// Login to https://login.salesforce.com/?locale=in
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		// Click on menu button from the Left corner
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();

		// Click view All and click Service Console from App Launcher
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement element = driver.findElement(By.xpath("//p[text()='Service Console']"));
		driver.executeScript("arguments[0].click();", element);
		// Click on the drop down and select Refunds
		driver.findElement(By.xpath("//button[@title='Show Navigation Menu']")).click();
		WebElement element2 = driver.findElement(By.xpath("//span[text()='Refunds']"));
		driver.executeScript("arguments[0].click();", element2);
		// 5.Click on drop down near Recently viewed and change into 'All'.
		driver.findElement(By.xpath("//button[@title='Select a List View: Refunds']")).click();
		driver.findElement(By.xpath("//span[text()='All Refunds']")).click();

		// 6. Click on Chart icon under New Button
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@title='Charts']")).click();
		// 7. Click New Chart
		Thread.sleep(3000);
		WebElement element3 = driver.findElement(By.xpath("(//span[@part='boundary'])[22]"));
		driver.executeScript("arguments[0].click();", element3);
		driver.findElement(By.xpath("//a[text()='New Chart']")).click();

		// 8. Give Chart Name and Select Chart Type
		driver.findElement(By.xpath("//label[text()='Chart Name']/following::input[1]")).sendKeys("Aravinth");
		driver.findElement(By.xpath("//label[text()='Chart Type']/following::button[1]")).click();
		WebElement element4 = driver.findElement(By.xpath("//span[@title='Horizontal Bar Chart']"));
		driver.executeScript("arguments[0].click();", element4);

		// 9. Select Aggregate Type as Average and ggregate Field as Amount
		WebElement element5 = driver.findElement(By.xpath("//label[text()='Aggregate Type']/following::button[1]"));
		driver.executeScript("arguments[0].click();", element5);
		WebElement element9 = driver.findElement(By.xpath("//span[@title='Average']"));
		driver.executeScript("arguments[0].click();", element9);
		Thread.sleep(2000);
		WebElement element6 = driver.findElement(By.xpath("//label[text()='Aggregate Field']/following::button[1]"));
		driver.executeScript("arguments[0].click();", element6);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@title='Amount'])[2]")).click();

		// 10. Select Grouping Field as Account and click Save
		WebElement element7 = driver.findElement(By.xpath("//label[text()='Grouping Field']/following::button[1]"));
		driver.executeScript("arguments[0].click();", element7);
		driver.findElement(By.xpath("(//span[@title='Account'])[3]")).click();
		driver.findElement(By.xpath("(//span[text()='Save'])[3]")).click();
		// 11. Click on settings icon and change the Chart Type
		Thread.sleep(2000);
		WebElement element8 = driver.findElement(By.xpath("(//span[@part='boundary'])[22]"));
		driver.executeScript("arguments[0].click();", element8);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[text()='Vertical Bar Chart']")).click();
		Thread.sleep(3000);
		// WebElement element10 =
		driver.findElement(By.xpath("(//span[@part='boundary'])[22]")).click();
		// driver.executeScript("arguments[0].click();", element10);
		driver.findElement(By.xpath("//a[text()='Donut Chart']")).click();
		// Expected Result: The Chart type should be changed.

	}

}
