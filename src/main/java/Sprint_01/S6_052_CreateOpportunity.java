package Sprint_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class S6_052_CreateOpportunity {
	@Test
	public void s6_052_CreateOpportunity() throws InterruptedException {
		// TODO Auto-generated method stub
		String date="20";
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
		
		// Click View All
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		// Click on Content tab
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[text()='Content']")).click();
		
		// Click View All Key Deals in Key Deals
		Thread.sleep(2000);
		driver.executeScript("window.scrollBy(0,350)");
		driver.findElement(By.xpath("//a[@aria-label='View All Key Deals']")).click();
		
		// Click the dropdown from Opportunities and select All Opportunities
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Recently Viewed']//following::button[@title='Select a List View: Opportunities']")).click();
		driver.findElement(By.xpath("(//div[text()='Recent List Views']//following::span[text()='All Opportunities'])[1]")).click();
		
		// Click on New
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='New']")).click();
		
		// Give Opportunity Name as SRM Steels 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[text()='Opportunity Name']//following::input[@name='Name']")).sendKeys("Sample");
		
		// Select Type as New Customer and Lead Source as Partner Referral 
		Thread.sleep(2000);
		WebElement TypeDropdown = driver.findElement(By.xpath("(//label[text()='Type']//following::button)[1]"));
		driver.executeScript("arguments[0].click()", TypeDropdown);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@title='New Customer']")).click();
		
		Thread.sleep(2000);
		WebElement LeadSourceDropdown = driver.findElement(By.xpath("(//label[text()='Lead Source']//following::button)[1]"));
		driver.executeScript("arguments[0].click()", LeadSourceDropdown);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@title='Partner Referral']")).click();
		
		// Give Amount as 75000 and Select Close Date as Next month 20th day 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[text()='Amount']//following::input[@name='Amount']")).sendKeys("75000");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[text()='Close Date']//following::input[@name='CloseDate']")).click();
		//table[contains(@class,'datepicker')]//tbody//td[contains(@class,'today')]
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@title='Next Month']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table[contains(@class,'datepicker')]//tbody//td//span[text()='" + date + "']")).click();
		
		// Select Stage as Needs Analysis
		Thread.sleep(2000);
		WebElement StageDropdown = driver.findElement(By.xpath("//label[text()='Stage']//following::button[@aria-label='Stage']"));
		driver.executeScript("arguments[0].click()", StageDropdown);
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		
		// Click in Primary Campaign  Source and Select first option 
		Thread.sleep(2000);
		WebElement AdditionalInformation = driver.findElement(By.xpath("//span[text()='Additional Information']"));
		driver.executeScript("arguments[0].scrollIntoView(true)", AdditionalInformation);
		Thread.sleep(2000);
		WebElement PrimaryCampaignSource = driver.findElement(By.xpath("//label[text()='Primary Campaign Source']//following::input[@placeholder='Search Campaigns...']"));
		driver.executeScript("arguments[0].click()", PrimaryCampaignSource);
		driver.findElement(By.xpath("//ul[@aria-label='Recent Campaigns']//li[2]")).click();
		
		//Click Save and Verify the SRM Steels opportunity is created 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(5000);
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).isDisplayed());
		
		
	}

}
