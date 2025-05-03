package Sprint_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

@Test
public class S6_22_DeleteContact {
	
	public void deleteContact() throws InterruptedException {
		
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(chromeOptions);
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

		//Step 1: Login to Login | Salesforce 
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();

		//Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();

		//Click view All and click Sales from App Launcher--view all-sales
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		Thread.sleep(3000);
		WebElement Accounts = driver.findElement(By.xpath("//p[text()='Accounts']"));
		
		driver.executeScript("arguments[0].scrollIntoView(true);", Accounts);
//		
		Thread.sleep(3000);
//		Actions actionon = new Actions(driver);
//		actionon.moveToElement(Accounts).click();
		
	 Accounts.click();

	    Thread.sleep(5000);
		WebElement Contacts = driver.findElement(By.xpath("//span[text()='Contacts']"));
		driver.executeScript("arguments[0].click();", Contacts);
		
		driver.findElement(By.xpath("//input[@name='Contact-search-input']")).sendKeys("Naveen Elumalai");
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[@title='Naveen Elumalai']/following::a[@role='button'])[2]")).click();
		
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
	
		Thread.sleep(2000);

		String EditSuccess = driver.findElement(By.xpath("(//div[@role='alert'])[3]//following::span[contains(@class,'toastMessage')]")).getText();
		String updatedMessage = EditSuccess.replace("Undo", "").trim();  // Removes "Undo" and trims any extra spaces
		System.out.println(updatedMessage);

	}

}
