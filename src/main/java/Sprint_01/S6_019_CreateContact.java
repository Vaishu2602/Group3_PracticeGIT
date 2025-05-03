package Sprint_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class S6_019_CreateContact {

	@Test
	
	public void s6_019_CreateContact() throws InterruptedException {
		String FirstName = "Naveen";
		String LastName = "Elumalai";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
//		Login to https://login.salesforce.com 
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		
//		Click on Global Actions SVG icon
		driver.findElement(By.xpath("(//span[text()='Global Actions']//preceding::div[contains(@class,'tooltip')])[3]")).click();
		
		
//		After clicking Global Actions SVG icon, Click 'New Contact'.
		driver.findElement(By.xpath("//span[text()='New Contact']")).click();
		
//		Pick Salutation as 'Mr.'
		WebElement SalutationDropdown = driver.findElement(By.xpath("(//span[text()='Salutation']//following::a[text()='--None--'])[1]"));
		driver.executeScript("arguments[0].click()", SalutationDropdown);
		driver.findElement(By.xpath("//a[@title='Mr.']")).click();
		
//		Enter First Name as 'Naveen'
		driver.findElement(By.xpath("//span[text()='First Name']//following::input[@placeholder='First Name']")).sendKeys(FirstName);
		
//		Enter Last Name as 'Elumalai'
		driver.findElement(By.xpath("//span[text()='Last Name']//following::input[@placeholder='Last Name']")).sendKeys(LastName);

//		Enter email as 'naveen@test.com'
		driver.findElement(By.xpath("(//span[text()='Email'])[2]//following::input[@inputmode='email']")).sendKeys("naveen@test.com");

//		Create a New Account for Account Name
		WebElement AccountNameBox = driver.findElement(By.xpath("//span[text()='Account Name']//following::input[@title='Search Accounts']"));
		driver.executeScript("arguments[0].click()", AccountNameBox);
		driver.findElement(By.xpath("//span[@title='New Account']")).click();
		
//		Enter account name as 'Credits' and save
		driver.findElement(By.xpath("((//span[text()='Account Name'])[2]//following::input)[1]")).sendKeys("Credits");
		Thread.sleep(2000);
//		Click and save
		driver.findElement(By.xpath("(//button[@title='Save'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		Thread.sleep(2000);
//		Verify contact using Unique name and print the name
		String AccountNameText = driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']")).getText();
		System.out.println(AccountNameText);
		String UniqueName = FirstName + " " + LastName;
		if(AccountNameText.contains(UniqueName)) {
			System.out.println("Contact is Verified and printed...");
		}else {
			System.out.println("Contact is not verified");
		}
		driver.close();
	}
}
