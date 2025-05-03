package Sprint_01;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class S6_006_EditWorkTypeGroup {

	@Test
	public void s6_006_EditWorkTypeGroup() throws InterruptedException, AWTException {

		String WorkTypeGroupName = "SampleTest";

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

//			Click on the toggle menu button from the left corner
		WebElement AppLauncher = driver.findElement(By.xpath("//button[@title='App Launcher']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(AppLauncher).build().perform();

		driver.executeScript("arguments[0].click()", AppLauncher);

//			Click View All and click Work Type Groups from App Launcher 
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search apps')]")).sendKeys("Work Type Groups");

//			⦁	Click on the Work Type Group tab 
		driver.findElement(By.xpath("//*[text()='Work Type Groups']")).click();

//			⦁	Click on the Dropdown icon in the Work Type Groups tab
		driver.findElement(
				By.xpath("(//a[contains(@title,'Work Type Groups')]//following::one-app-nav-bar-item-dropdown)[2]"))
				.click();

//			⦁	Click on New Work Type Group 
		WebElement newWorkTypeGroup = driver.findElement(By.xpath("//span[text()='New Work Type Group']"));
		driver.executeScript("arguments[0].click()", newWorkTypeGroup);

//			⦁	Enter Work Type Group Name as 'Salesforce Automation by *Your Name*' 
		driver.findElement(By.xpath("//label[text()='Work Type Group Name']//following::input[@name='Name']"))
				.sendKeys(WorkTypeGroupName);

//			⦁	Click save and verify Work Type Group Name 
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		String text = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
		System.out.println(text);

		Thread.sleep(5000);

		WebElement close = driver.findElement(By.xpath(
				"(//a[contains(@title,'Work Type Groups')]//following::one-app-nav-bar-item-dropdown)[2]//following::button//span[text()='Close tab']"));
		driver.executeScript("arguments[0].click()", close);

//			Search the Work Type Group 'Salesforce Automation by *Your Name*' 
		driver.findElement(
				By.xpath("//input[contains(@placeholder,'Search this list...')][@name='WorkTypeGroup-search-input']"))
				.sendKeys(WorkTypeGroupName);
		driver.findElement(
				By.xpath("//input[contains(@placeholder,'Search this list...')][@name='WorkTypeGroup-search-input']"))
				.sendKeys(Keys.ENTER);

//			Click on the Dropdown icon and Select Edit 

		WebElement dropdown = driver.findElement(By.xpath("//td//a//span//child::span"));

		try {
			dropdown.click();
		} catch (StaleElementReferenceException e) {
			dropdown = driver.findElement(By.xpath("//td//a//span//child::span"));
		}
		dropdown.click();
		driver.findElement(By.xpath("//a[contains(@title,'Edit')]")).click();

//			Enter Description as 'Automation'. 
		driver.findElement(By.xpath("//label[text()='Description']//following::textarea")).sendKeys("Automation");

//			Select Group Type as 'Capacity' 
		WebElement CapacityDropDown = driver
				.findElement(By.xpath("//label[text()='Group Type']//following::button[@data-value='Default']"));
		driver.executeScript("arguments[0].click()", CapacityDropDown);
		driver.findElement(By.xpath("//span[text()='Capacity']")).click();

//			Click on Save 
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(5000);

		
//			Click on 'Salesforce Automation by *Your Name*'and Verify Description as 'Automation'

		WebElement EditedWorkTypeGroupName = driver.findElement(By.xpath("//a[@title='" + WorkTypeGroupName + "']"));

		try {
			EditedWorkTypeGroupName.click();
		} catch (StaleElementReferenceException e) {
			EditedWorkTypeGroupName = driver.findElement(By.xpath("//a[@title='" + WorkTypeGroupName + "']"));
		}
		EditedWorkTypeGroupName.click();
		String DescriptionText = driver.findElement(By.xpath(
				"(//span[text()='Description'][@class='test-id__field-label']//following::lightning-formatted-text)[1]"))
				.getText();
		System.out.println("DEscription Text: " + DescriptionText);
	}
}
