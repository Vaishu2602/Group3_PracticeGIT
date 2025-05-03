package Sprint_01;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class S6_20 {
	@Test
	public void testA() throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		// driver = new ChromeDriver(options);
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		// Login to Login | Salesforce
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		// username: gokul.sekar@testleaf.com
		// password: Leaf$321

		// Click on toggle menu button from the left corner
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		// Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//Click on contacts under 'All Items'
		WebElement element = driver.findElement(By.xpath("//p[text()='Contacts']"));
		driver.executeScript("arguments[0].click();", element);
		//Get the size of conatcts available and print the list
		Thread.sleep(3000);
		//WebElement contactName = driver.findElement(By.xpath("(//a[contains(text(),'Naveen Elumalai')])[13]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].scrollIntoView();", contactName);
		js.executeScript("window.scrollBy(0,350)", "");
		//Thread.sleep(3000);
		String text = driver.findElement(By.xpath("//span[@class='countSortedByFilteredBy']")).getText();
		System.out.println(text);
		//search for the contact using unique name 
		driver.findElement(By.xpath("//input[@name='Contact-search-input']")).sendKeys("Naveen Elumalai");
		driver.findElement(By.xpath("//button[@name='refreshButton']")).click();
		//Click on the dropdown icon available in the unique contact and select edit
		Thread.sleep(3000);
		WebElement element2 = driver.findElement(By.xpath("(//a[@role='button'])[30]"));
		driver.executeScript("arguments[0].click();", element2);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		//Edit Title as Test
		driver.findElement(By.xpath("(//input[@name='Title'])")).sendKeys("Test");
		//select your birthday in the birthday field
		driver.findElement(By.xpath("//input[contains(@name,'Birthdate')]")).sendKeys("08/06/1993");
		//edit Lead Source as Purchased list
		WebElement element3 = driver.findElement(By.xpath("//button[contains(@aria-label,'Lead Source')]"));
		driver.executeScript("arguments[0].click();",element3); 
		driver.findElement(By.xpath("//span[contains(@title,'Purchased List')]")).click();
		//Edit Phone number with personal number
		driver.findElement(By.xpath("//input[contains(@name,'Phone')]")).sendKeys("990099009");
		//Click Save and Verify and Print Phone number
		driver.findElement(By.xpath("(//button[contains(text(),'Save')])[2]")).click();
		Thread.sleep(2000);
		String text2 = driver.findElement(By.xpath("//span[contains(@class,'forceOutputPhone')]")).getText();
		System.out.println(text2);

	}
}