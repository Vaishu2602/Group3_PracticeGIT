package Sprint_01;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class S6_14 {
	@Test
	public void testA() throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		//driver = new ChromeDriver(options);
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		// Login to Login | Salesforce
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		// username: gokul.sekar@testleaf.com
		// password: Leaf$321

		// Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();

		// Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//Thread.sleep(3000);
		// click on search button and provide value as sales
		driver.findElement(By.xpath("(//input[@role='combobox'])[2]")).sendKeys("sales");
		driver.findElement(By.xpath("(//mark[text()='Sales'])[3]")).click();
		//Click on Opportunity tab 
		WebElement element = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		driver.executeScript("arguments[0].click();", element);
		//Click on New button
		driver.findElement(By.xpath("//a[@title='New']")).click();
		//Enter Opportunity name as 'Salesforce Automation by *Your Name*,Get the text and Store it
		driver.findElement(By.xpath("//label[text()='Opportunity Name']/following::div[1]/input")).sendKeys("Salesforce Automation by Aravinth D");
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath("//label[text()='Opportunity Name']/following::div[1]/input")).getAttribute("value");
		System.out.println(text);
		//Choose close date as Today
		driver.findElement(By.xpath("//label[text()='Close Date']/following::div[1]/input")).click();
		driver.findElement(By.xpath("//td[contains(@class,'slds-is-today')]/span[1]")).click();

		//Select 'Stage' as Need Analysis
		Thread.sleep(2000);
		WebElement element2 = driver.findElement(By.xpath("//label[text()='Stage']/following::button[1]"));
		driver.executeScript("arguments[0].click();", element2);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();

		//click Save and VerifyOppurtunity Name
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		Thread.sleep(2000);
		String text2 = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
		System.out.println(text2);



}
}
