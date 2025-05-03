package Sprint_01;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class S6_15_EditOpportunity {
	@Test
	public void editOpprt() throws InterruptedException {
		
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
		driver.findElement(By.xpath("//button[text()='View All']")).click();

		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		//click on oppoetunity
		WebElement opprtunity = driver.findElement(By.xpath("//a[@title='Opportunities']"));
		driver.executeScript("arguments[0].click();", opprtunity);
		
		//enter text in input field
		driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys("Salesforce Automation By Parikshit");
		
		//click on down arrow dropdown And click on Edit
		Thread.sleep(3000);
		//a[@title='Edit']
		//a[contains(@class,'rowActionsPlaceHolder')]
		driver.findElement(By.xpath("//a[contains(@class,'rowActionsPlaceHolder')]")).click();
		
		Thread.sleep(5000);
		WebElement editoption = driver.findElement(By.xpath("//a[@title='Edit']"));
		driver.executeScript("arguments[0].click();", editoption);
		
		
		//select the calendar icon and next date from todays date
		//button[@title='Select a date for Close Date']
		Thread.sleep(3000);
		WebElement calendaeIcon = driver.findElement(By.xpath("//button[@title='Select a date for Close Date']"));
		Thread.sleep(3000);
		driver.executeScript("arguments[0].click();", calendaeIcon);
		driver.findElement(By.xpath("//td[contains(@class,'slds-is-today')]/following-sibling::td[1]")).click();
		
		//Select 'Stage' as Perception Analysis
		//button[@aria-label='Stage']
		driver.findElement(By.xpath("//button[@aria-label='Stage']")).click();
		Thread.sleep(3000);
		WebElement perception = driver.findElement(By.xpath("//label[text()='Stage']//following::span[text()='Perception Analysis']"));
		driver.executeScript("arguments[0].click();", perception);
		
		Thread.sleep(3000);
		//span[text()='Last Modified By']
//		WebElement element = driver.findElement(By.id("id_of_element"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		 
		WebElement eleAtBottom = driver.findElement(By.xpath("//a[@title='Delivery Status']"));
		Actions actionon = new Actions(driver);
		actionon.moveToElement(eleAtBottom).perform();
		
		//9. Select Deliver Status as In Progress
		//label[text()='Delivery/Installation Status']/following::button[@data-value='--None--']
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[text()='Delivery/Installation Status']/following::button[@data-value='--None--']")).click();
		WebElement inprogress = driver.findElement(By.xpath("//label[text()='Delivery/Installation Status']//following::span[@title='In progress']"));
		driver.executeScript("arguments[0].click();", inprogress);
		
		//Enter Description as SalesForce
		driver.findElement(By.xpath("//textarea[@part='textarea']")).sendKeys("Salesforce");
		//click save
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		
		Thread.sleep(2000);
		String EditSuccess = driver.findElement(By.xpath("(//div[@role='alert'])[3]//following::span[contains(@class,'toastMessage')]")).getText();
		System.out.println(EditSuccess);
		

		
//		Calendar calendar = Calendar.getInstance();
//		Date today = calendar.getTime();
//		calendar.add(Calendar.DAY_OF_YEAR, 1);
//		Date tomorrow = calendar.getTime();
//		//Use SimpleDateFormat to format the Date as a String:
//
//		
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
//
//		String todayAsString = dateFormat.format(today);
//		String tomorrowAsString = dateFormat.format(tomorrow);
//
//		System.out.println(todayAsString);
//		System.out.println(tomorrowAsString);
//		LocalDate tomorrow = LocalDate.now().plusDays(1);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        String tomorrowDate = tomorrow.format(formatter);
//        driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys(tomorrowDate);
		
		
		
	}

}
