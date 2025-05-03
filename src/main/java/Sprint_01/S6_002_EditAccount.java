package Sprint_01;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class S6_002_EditAccount {
	
	@Test
	public void testA() throws InterruptedException
	{
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		//Launch the app
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		//Click Login
		driver.findElement(By.id("Login")).click();
		
		//Click on the App Laucher Icon left to Setup
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("(//input[@role='combobox'])[2]")).sendKeys("sales");
		driver.findElement(By.xpath("(//mark[text()='Sales'])[3]")).click();
		//Click on Accounts
		WebElement eleAccounts = driver.findElement(By.xpath("//a[@title='Accounts']"));
		driver.executeScript("arguments[0].click();", eleAccounts);
		//
		//Search for the Account Using the unique account name created by you 
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys("Aravinth");
		driver.findElement(By.xpath("//button[@name='refreshButton']")).click();
		Thread.sleep(3000);

		//Click on the displayed Account Dropdown icon and select Edit
		driver.findElement(By.xpath("(//a[@role='button'])[25]")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Edit']")));
		ele.click();
		}
		catch (org.openqa.selenium.StaleElementReferenceException e){
			System.out.println("StaleElementException occurred. Refreshing the page.");
		}

		// Select Type as Technology Partner
		WebElement ele = driver.findElement(By.xpath("//label[text()='Type']/following::button[1]"));
		driver.executeScript("arguments[0].click();", ele);
		driver.findElement(By.xpath("//span[@title='Technology Partner']")).click();

		//Select Industry as Healthcare 
		
		WebElement ele1 = driver.findElement(By.xpath("//label[text()='Industry']/following::button[1]"));
		driver.executeScript("arguments[0].click();", ele1);
		Thread.sleep(3000);
		WebElement ele7 = driver.findElement(By.xpath("//span[@title='Healthcare']"));
		driver.executeScript("arguments[0].click();", ele7);

		//Enter Billing Address
		driver.findElement(By.xpath("//label[text()='Billing Street']/following::textarea[1]")).sendKeys("Chennai");
		//Enter Shipping Address
		driver.findElement(By.xpath("//label[text()='Shipping Street']/following::textarea[1]")).sendKeys("Erode");
		//Select Customer Priority as Low
		WebElement ele2 = driver.findElement(By.xpath("//label[text()='Customer Priority']/following::button[1]"));
		driver.executeScript("arguments[0].click();", ele2);
		driver.findElement(By.xpath("//span[@title='Low']")).click();

		//Select SLA as Silver
		WebElement ele3 = driver.findElement(By.xpath("//label[text()='SLA']/following::button[1]"));
		driver.executeScript("arguments[0].click();", ele3);
		driver.findElement(By.xpath("//span[@title='Silver']")).click();

		//1Select Active as NO 
		WebElement ele4 = driver.findElement(By.xpath("//label[text()='Active']/following::button[1]"));
		driver.executeScript("arguments[0].click();", ele4);
		driver.findElement(By.xpath("//span[@title='No']")).click();

		//Enter Unique Number in Phone Field
		driver.findElement(By.xpath("//input[@name='Phone']")).sendKeys("9988778877");
		//Select Upsell Oppurtunity as No
		WebElement ele5 = driver.findElement(By.xpath("//label[text()='Upsell Opportunity']/following::button[1]"));
		driver.executeScript("arguments[0].click();", ele5);
		driver.findElement(By.xpath("(//label[text()='Upsell Opportunity']/following::span[@title='No'])[1]")).click();

		//Click on save and verfiy Phone number
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		String text1 = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
		System.out.println(text1);
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath("(//td[@role='gridcell'])[4]")).getText();
		System.out.println(text);

	}

}
