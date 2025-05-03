package Sprint_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class S6_10_CreateCase {
	
	
public static void main(String[] args) throws InterruptedException {
	
	ChromeDriver driver = new ChromeDriver();
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
	driver.findElement(By.xpath("//p[text()='Sales']")).click();
	
	//Click on More-->New Case
	
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[text()='More']")).click();
	Thread.sleep(3000);
	WebElement CaseButton = driver.findElement(By.xpath("//a[@role='menuitem']//span[text()='Cases']"));
	driver.executeScript("arguments[0].click();", CaseButton);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a[@title='New']//div[text()='New']")).click();
	
	// Choose Contact Name from the dropdown
	
	driver.findElement(By.xpath(" //input[@placeholder='Search Contacts...']")).sendKeys("Gokul");

	//select the first name
	driver.findElement(By.xpath("//label[text()='Contact Name']//following::lightning-base-combobox-formatted-text[@title='Gokul'][1]")).click();
	
	//Select Case origin as email
	
	driver.findElement(By.xpath("//label[text()='Case Origin']//following::button[@data-value='--None--'][1]")).click();
	WebElement email= driver.findElement(By.xpath("//label[text()='Case Origin']//following::span[text()='Email']"));
	driver.executeScript("arguments[0].click();", email);
	
	driver.findElement(By.xpath("//label[text()='Status']//following::button[@data-value='New']")).click();
	WebElement escaleted = driver.findElement(By.xpath("//label[text()='Status']//following::span[@title='Escalated']"));
	driver.executeScript("arguments[0].click();", escaleted);
	
	// Enter Subject as 'Testing' and description as 'Dummy
	
	driver.findElement(By.xpath("//label[text()='Subject']//following-sibling::div//input[@name='Subject']")).sendKeys("Testing");
	
	driver.findElement(By.xpath("//label[text()='Description']//following-sibling::div//textarea[@part='textarea']")).sendKeys("Dummy");
	
	//Click 'Save' and verify the message
	
			 
	driver.findElement(By.xpath(" (//button[text()='Save'])[2]")).click();
	
	Thread.sleep(2000);
	//div[contains(@class,'toastContainer')]/div[@role='alert']//div[contains(@class,'toastContent')]
	//div[@role='alert'])[3]
	String SuccessMesg = driver.findElement(By.xpath("(//div[@role='alert'])[3]//following::span[contains(@class,'toastMessage')]")).getText();
	System.out.println(SuccessMesg);

}	

}
