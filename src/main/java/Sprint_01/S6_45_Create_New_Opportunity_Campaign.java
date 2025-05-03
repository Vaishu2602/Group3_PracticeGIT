package Sprint_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

@Test
public class S6_45_Create_New_Opportunity_Campaign {
	
	public void createCampaignOpp() throws InterruptedException {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(chromeOptions);
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

		// Step 1: Login to Login | Salesforce
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();

		// Click on toggle menu button from the left corner
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();

		// Click view All and click Sales from App Launcher--view all-sales
		Thread.sleep(6000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();

		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		WebElement campaigns = driver.findElement(By.xpath("//a[@title='Campaigns']"));
		driver.executeScript("arguments[0].click();", campaigns);
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='Bootcamp']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@title='New Opportunity']")).click();
		
		Thread.sleep(3000);
		String name="Parikshit";
		driver.findElement(By.xpath("//span[text()='Opportunity Name']//following::input[@class=' input'][1]")).sendKeys(name);
		
		
		
		driver.findElement(By.xpath("//span[text()='Close Date']//following::a[contains(@class,'display')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//td[@aria-selected='true']//following::td[1]")).click();
		
		
		driver.findElement(By.xpath("//span[text()='Stage']//following::a[text()='--None--'][1]")).click();
		driver.findElement(By.xpath("//a[@title='Needs Analysis']")).click();		
		
		driver.findElement(By.xpath("(//span[text()='Save'])[3]")).click();
		//a//span[text()='Opportunities' and @class='slds-truncate']
		
		Thread.sleep(3000);
		WebElement opp = driver.findElement(By.xpath("//span[text()='Opportunities'][1]"));
		driver.executeScript("arguments[0].click();", opp);
		
		
	
		boolean NameisPresent = driver.findElement(By.xpath("//a[@title='"+name+"']")).isDisplayed();
		
		if(NameisPresent) {
			
			System.out.println("Newly created Opportunity for "+name+" is Verified Successfully");
		}			
		
		
		
		
		
	}

}
