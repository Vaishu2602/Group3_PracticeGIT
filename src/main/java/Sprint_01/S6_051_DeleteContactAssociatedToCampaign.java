package Sprint_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class S6_051_DeleteContactAssociatedToCampaign {
	@Test
	public void s6_051_DeleteContactAssociatedToCampaign() throws InterruptedException {
		// TODO Auto-generated method stub
		String FirstName = "Sample";
		String LastName = "Test";
		String FullName = FirstName + " " +LastName;
		
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
		
		Thread.sleep(3000);
		WebElement CampaignsTab = driver.findElement(By.xpath("//span[text()='Campaigns']"));
		driver.executeScript("arguments[0].click()", CampaignsTab);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Bootcamp']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@title='New Contact']")).click();
		Thread.sleep(2000);
		WebElement SalutationDropdown = driver.findElement(By.xpath("//span[text()='Salutation']//following::a[text()='--None--']"));
		driver.executeScript("arguments[0].click()", SalutationDropdown);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li//a[@title='Mr.']")).click();
		driver.findElement(By.xpath("//span[text()='First Name']//following::input[@placeholder='First Name']")).sendKeys(FirstName);
		driver.findElement(By.xpath("//span[text()='Last Name']//following::input[@placeholder='Last Name']")).sendKeys(LastName);
		driver.findElement(By.xpath("(//h1//button//following::span[text()='Save'])[2]")).click();
		 Thread.sleep(5000);
		 driver.executeScript("window.scrollBy(0,350)");
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//div[@title='Add Contacts']")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("(//a[@title='" + FullName + "']//preceding::td//input[@aria-label='Select item 1'])[2]//following::span[contains(@class,'checkbox')][1]")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//button[text()='Next']")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		//Click on Contacts tab 
		 Thread.sleep(2000);
		 WebElement ContactsTab = driver.findElement(By.xpath("//a[@title='Contacts']"));
		 driver.executeScript("arguments[0].click()", ContactsTab);
		
		//Search for Contact with name as <your name>
		 Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys(FullName,Keys.ENTER);
		 Thread.sleep(3000);
		 
		//Click on dropdown icon for the Lead and Select Delete
		 WebElement FirstRowDropdown = driver.findElement(By.xpath("//table//tbody//tr[1]//td[8]//span//a"));
		 driver.executeScript("arguments[0].click()", FirstRowDropdown);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[text()='Delete']//parent::a")).click();
			
		// Confirm the Delete for Lead
			Thread.sleep(3000);
			driver.findElement(By.xpath("//h1[text()='Delete Contact']//following::button[@title='Delete']")).click();
			Thread.sleep(3000);
			
		// Click on Campaign tab 
			Thread.sleep(3000);
			driver.executeScript("arguments[0].click()", CampaignsTab);		
			
		// Click Bootcamp link 
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@title='Bootcamp']")).click();
			
		// Verify the associated Contact                
			Thread.sleep(2000);
			driver.executeScript("window.scrollBy(0,350)");
			 driver.findElement(By.xpath("//span[text()='Campaign Members']//following::span[text()='View All']")).click();
			 Thread.sleep(2000);
			Assert.assertTrue(!driver.getPageSource().contains(FullName));
			 System.out.println("Contact associated to Campaign has been deleted");
			

	}

}
