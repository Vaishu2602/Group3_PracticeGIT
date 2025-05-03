package Sprint_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class S6_001_CreateAc {

	@Test
	public void testA() throws InterruptedException {
		// TODO Auto-generated method stub
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
		//TestGit
		// Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();

		// Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//Thread.sleep(3000);
		// click on search button and provide value as sales
		driver.findElement(By.xpath("(//input[@role='combobox'])[2]")).sendKeys("sales");
		driver.findElement(By.xpath("(//mark[text()='Sales'])[3]")).click();

		// Click on Accounts tab
		// driver.findElement(By.xpath("(//span[text()='Accounts'])[1]")).click();
		WebElement eleAccounts = driver.findElement(By.xpath("//a[@title='Accounts']"));
		driver.executeScript("arguments[0].click();", eleAccounts);

		// Click on New button
		driver.findElement(By.xpath("//div[@title='New']")).click();

		// Enter 'your name' as account name: Aravinth
		driver.findElement(By.xpath("//label[text()='Account Name']/following::input[1]")).sendKeys("Aravinth");

		// Select Ownership as Public
		//Thread.sleep(3000);
		// driver.findElement(By.xpath("//label[text()='Ownership']/following::button[1]")).click();
		WebElement ele = driver.findElement(By.xpath("//label[text()='Ownership']/following::button[1]"));
		driver.executeScript("arguments[0].click();", ele);
		driver.findElement(By.xpath("//span[text()='Public']")).click();

		// Click save and verify Account name
		//driver.findElement(By.xpath("//label[text()='Description']/following::button[text()='Save']")).click();
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();

		String text = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
		System.out.println(text);

	}

}
