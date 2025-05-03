package Sprint_01;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class S6_38 {
	
	@Test
	public void TestA() throws InterruptedException
	{
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		//Login to https://login.salesforce.com/?locale=in 
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
			//Click on menu button from the Left corner
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		
			//Click view All and click Service Console from App Launcher 
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement element = driver.findElement(By.xpath("//p[text()='Service Console']"));
		driver.executeScript("arguments[0].click();", element);
			//Click on the drop down and select Refunds 
		driver.findElement(By.xpath("//button[@title='Show Navigation Menu']")).click();
		WebElement element2 = driver.findElement(By.xpath("//span[text()='Refunds']"));
		driver.executeScript("arguments[0].click();", element2);
			//Click on New 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='New']")).click();
			//Select Account name 
		driver.findElement(By.xpath("//input[@title='Search Accounts']")).click();
		WebElement element3 = driver.findElement(By.xpath("//span[text()='Testleaf Software']"));
		driver.executeScript("arguments[0].click();", element3);

			//Select Status as Canceled 
		driver.findElement(By.xpath("//a[@class='select']")).click();
		WebElement element4 = driver.findElement(By.xpath("//a[text()='Canceled']"));
		driver.executeScript("arguments[0].click()",element4); 

			//Give Amount as 50000 and select Referenced in Type 
		driver.findElement(By.xpath("(//span[text()='Amount']/following::input[1])[2]")).sendKeys("50000");
		driver.findElement(By.xpath("(//span[text()='Type']/following::a[1])[2]")).click();
		WebElement element6 = driver.findElement(By.xpath("//a[text()='Referenced']"));
		driver.executeScript("arguments[0].click();", element6);
			//Select Processing Mode as External 
		driver.findElement(By.xpath("//span[text()='Processing Mode']/following::a[1]")).click();
		WebElement element5 = driver.findElement(By.xpath("//a[text()='External']"));
		driver.executeScript("arguments[0].click();", element5);

			//Click Save                                     
		driver.findElement(By.xpath("//button[@title='Save']")).click();
			//Expected Result:success Refund 'R-000000001' was created.      
		String text = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
		System.out.println(text);

	}

}
