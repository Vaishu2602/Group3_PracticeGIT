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

public class S6_070_DeleteLeads {
	
	@Test
	public void s6_070_DeleteLeads() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

		//Login to https://login.salesforce.com 
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		
		//Click on the toggle menu button from the left corner
	WebElement AppLauncher = driver.findElement(By.xpath("//button[@title='App Launcher']"));
	Actions actions = new Actions(driver);
	actions.moveToElement(AppLauncher).build().perform();

	driver.executeScript("arguments[0].click()", AppLauncher);

		//Click View All and click Sales from App Launcher 
	driver.findElement(By.xpath("//button[text()='View All']")).click();
	driver.findElement(By.xpath("//p[text()='Sales']")).click();
	
	String FirstName = "Test";
	String LastName = "Sample";
	String CompanyName = "TestLeafSample";
	
	// Click on the Leads tab
	Thread.sleep(2000);
	WebElement Leads = driver.findElement(By.xpath("//a[@title='Leads']"));
	driver.executeScript("arguments[0].click()", Leads);
	
	//Click on the New button
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@title='New']")).click();
	
	//Select the Salutation as 'Mr.'
	Thread.sleep(3000);
	WebElement SalutationDropdown = driver.findElement(By.xpath("//label[text()='Salutation']//following::button[@name='salutation']"));
	driver.executeScript("arguments[0].click()",SalutationDropdown);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[text()='Mr.']")).click();
	
	//Enter the First Name as 'Ganesh'
	Thread.sleep(2000);
	driver.findElement(By.xpath("//label[text()='First Name']//following::input[@name='firstName']")).sendKeys(FirstName);	
	
	//Enter the last name as 'Kumar'
	Thread.sleep(2000);
	driver.findElement(By.xpath("//label[text()='Last Name']//following::input[@name='lastName']")).sendKeys(LastName);
	
	//Enter the company name as 'TestLeaf'
	Thread.sleep(2000);
	driver.findElement(By.xpath("//label[text()='Company']//following::input[@name='Company']")).sendKeys(CompanyName);
	
	//Click on the save button
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
	
	// Click on the Leads tab
	Thread.sleep(2000);
	driver.executeScript("arguments[0].click()", Leads);
	
	//Search the Leads 'Kumar'
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys(LastName,Keys.ENTER);
	
	//Click on the Dropdown icon and Select Delete
	Thread.sleep(2000);
	WebElement Dropdown = driver.findElement(By.xpath("//table//tbody//tr[1]//td[10]//a"));
	driver.executeScript("arguments[0].click()", Dropdown);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[@title='Delete']")).click();
	
	//Click on the Delete option in the displayed popup window.
	Thread.sleep(2000);
	driver.findElement(By.xpath("//h1[text()='Delete Lead']//following::button[@title='Delete']")).click();
	
	//Verify Whether Leads is Deleted using Leads last name
	Thread.sleep(2000);
	WebElement Verification = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]"));
	Assert.assertTrue(Verification.isDisplayed());
	String Verificationtext = Verification.getText();
	Assert.assertTrue(Verificationtext.contains(LastName));
	System.out.println(Verificationtext);	
	}

}
