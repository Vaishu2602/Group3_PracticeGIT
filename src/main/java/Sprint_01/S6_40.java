package Sprint_01;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class S6_40 {

	@Test
	public void testA() throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		// Login to https://login.salesforce.com/?locale=in
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		// Click on menu button from the Left corner
		//Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='App Launcher']")));
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();

		// Click view All and click Service Console from App Launcher
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement element = driver.findElement(By.xpath("//p[text()='Service Console']"));
		driver.executeScript("arguments[0].click();", element);
		//Click on the drop down and select Orders
		driver.findElement(By.xpath("//button[@title='Show Navigation Menu']")).click(); 
		driver.findElement(By.xpath("//span[text()='Orders']")).click();
		//Click on New 
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='New']")).click();
		
		//Select Account name as Testleaf Software 
		driver.findElement(By.xpath("//label[text()='Account Name']/following::input[1]")).sendKeys("TestLeaf Software");
		driver.findElement(By.xpath("//lightning-base-combobox-formatted-text[@title='Testleaf Software']")).click();
		//Contract number as '00000103' 
		driver.findElement(By.xpath("//label[text()='Contract Number']/following::input[1]")).click();
		driver.findElement(By.xpath("//span[@title='00000133']")).click();
		
		//Status as Draft 
		driver.findElement(By.xpath("//label[text()='Status']/following::button[1]")).click();
		driver.findElement(By.xpath("//span[@title='Draft']")).click();
		//Select Order Start Date as next month 10th date 
		driver.findElement(By.xpath("//label[text()='Order Start Date']/following::input[1]")).sendKeys("10/11/2024");
		//Click Save
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		String text = driver.findElement(By.xpath("//div[contains(@id,\"toastDescription\")]")).getText();
		System.out.println(text);

	}

}
