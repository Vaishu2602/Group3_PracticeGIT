package Sprint_01;

import java.awt.Window;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class S6_050_CreateContactForCampaign {
	
	@Test
	public void s6_050_CreateContactForCampaign() throws InterruptedException {
		String FirstName = "Vaishnavi";
		String LastName = "Krishnan";
		String FullName = FirstName + " " +LastName;
		System.out.println(FullName);
		
		
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		// Login to https://login.salesforce.com 
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		
		
		
		// Click on toggle menu button from the left corner
		WebElement AppLauncher = driver.findElement(By.xpath("//button[@title='App Launcher']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(AppLauncher).build().perform();

		driver.executeScript("arguments[0].click()", AppLauncher);
		
		// Click view All and click Sales from App Launcher 
		
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		// Click on Campaigns tab  
		Thread.sleep(3000);
		WebElement CampaignsTab = driver.findElement(By.xpath("//span[text()='Campaigns']"));
		driver.executeScript("arguments[0].click()", CampaignsTab);
		
		// Click Bootcamp link 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Bootcamp']")).click();
		
		// Click on New Contact under Search field 
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@title='New Contact']")).click();
		
		// Pick Salutation as 'Mr.'
		Thread.sleep(2000);
		WebElement SalutationDropdown = driver.findElement(By.xpath("//span[text()='Salutation']//following::a[text()='--None--']"));
		driver.executeScript("arguments[0].click()", SalutationDropdown);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li//a[@title='Mr.']")).click();
		
		// Enter first name as <your First Name>
		 driver.findElement(By.xpath("//span[text()='First Name']//following::input[@placeholder='First Name']")).sendKeys(FirstName);
		 
		// Enter last name as <your last name> 
		 driver.findElement(By.xpath("//span[text()='Last Name']//following::input[@placeholder='Last Name']")).sendKeys(LastName);
		 
		// Click Save
		 driver.findElement(By.xpath("(//h1//button//following::span[text()='Save'])[2]")).click();
		 Thread.sleep(5000);
		 
		// Click on Add Contact from Campaign member 
		// WebElement CampaignMembers = driver.findElement(By.xpath("//span[@title='Campaign Members']"));
		 driver.executeScript("window.scrollBy(0,350)");
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//div[@title='Add Contacts']")).click();
		 
		 // Select the Created Contact
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("(//a[@title='" + FullName + "']//preceding::td//input[@aria-label='Select item 1'])[2]//following::span[contains(@class,'checkbox')][1]")).click();
		                      
		 // Click Next 
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//button[text()='Next']")).click();
		 
		 // Click Submit on the Add to Campaign pop up
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//button[text()='Submit']")).click();
		 
		 // verify the created Contact under Campaign by clicking 'View All' 
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//span[text()='Campaign Members']//following::span[text()='View All']")).click();
		 Thread.sleep(2000);
		 WebElement CreatedContact = driver.findElement(By.xpath("//a[@title='" + FullName + "']"));
		 if(CreatedContact.isDisplayed()) {
			 System.out.println("Contact is created under Campaign");
		 }else {
			System.out.println("Contact is not created under Campaign");
		}
		 
		// Navigate to Contacts tab 
		 Thread.sleep(2000);
		 WebElement ContactsTab = driver.findElement(By.xpath("//a[@title='Contacts']"));
		 driver.executeScript("arguments[0].click()", ContactsTab);
		 
		// Search for Contact with your Name 
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys(FirstName,Keys.ENTER);
		 Thread.sleep(3000);
		 
		 if(driver.findElement(By.xpath("//th//a[@title='" + FullName + "']")).isDisplayed()) {
			 System.out.println("Contact is Verifed");
		 }else {
			System.out.println("Contact is not verified");
		}
	}

}
