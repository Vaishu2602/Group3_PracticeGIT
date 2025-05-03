package Sprint_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


@Test
public class S6_28_CreateNewDashboard {
	
	
	public void newDashboard() throws InterruptedException {

		
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
		Thread.sleep(6000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		Thread.sleep(3000);
		WebElement Dashboards = driver.findElement(By.xpath("//p[text()='Dashboards']"));
		
		driver.executeScript("arguments[0].scrollIntoView(true);", Dashboards);
//		
		Thread.sleep(3000);
		
		Dashboards.click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='New Dashboard']")).click();
		
		
		//driver.executeScript("document.getElementById('dashboardNameInput').setAttribute('id', 'Salesforce Automation by Parikshit')");
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='dashboardNameInput']")));
		
		Thread.sleep(10000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='dashboard']")));		
		
		driver.findElement(By.id("dashboardNameInput")).sendKeys("Salesforce Automation by Parikshit");
		
//		Actions actionon = new Actions(driver);
//		WebElement dashboardNameInput = driver.findElement(By.xpath("//div//input[@id='dashboardNameInput']"));
//		actionon.moveToElement(dashboardNameInput).sendKeys("Salesforce Automation by Parikshit");
//		driver.findElement(By.xpath("//button[text()='Create']")).click();
//		
		//button[text()='Done']
		//span[@title='Salesforce Automation by Parikshit']
		
		driver.findElement(By.xpath("//button[@id='submitBtn']")).click();
		
		Thread.sleep(6000);
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@title='dashboard']")));

	
		Thread.sleep(6000);
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='dashboard']")));
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[text()='Done']")).click();
	
		
		String name = driver.findElement(By.xpath("//span[@title='Salesforce Automation by Parikshit']")).getText();
		if (name.contains("Parikshit")) {
			
			System.out.println("New Dashboard Created.");
		}
		
		


	   
		
	}
}
