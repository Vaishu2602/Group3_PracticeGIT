package Sprint_01;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

@Test
public class S6_34_Administrator_Certifications {

	public void adminCertificate() throws InterruptedException {

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

		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		String mainwindowHandle = driver.getWindowHandle();
		Set<String> windowhandles = driver.getWindowHandles();
		for (String handle : windowhandles) {
			driver.switchTo().window(handle);
		}

		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();

		Shadow shadowdom = new Shadow(driver);

		WebElement learning = shadowdom.findElementByXPath("//span[text()='Learning']");
		learning.click();
		
		Thread.sleep(3000);
		WebElement trailhead = shadowdom.findElementByXPath("//span[text()='Learning on Trailhead']");
		//trailhead.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement trailhead1 = wait.until(ExpectedConditions.elementToBeClickable(shadowdom.findElementByXPath("//span[text()='Learning on Trailhead']")));
		Actions ac=new Actions(driver);
		ac.moveToElement(trailhead1).perform();
		
		
	
		//a[text()='Salesforce Certification']
		WebElement certification = shadowdom.findElementByXPath("//a[text()='Salesforce Certification']");
		ac.moveToElement(certification).click().perform();
		
		//div[@class='credentials-card_title']
		  List<WebElement> listofCertifications = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
		  System.out.println("Certifications Available:");
		  for(WebElement lists:listofCertifications) {
			  
			  String text = lists.getText();
			 
			  System.out.println(text);
		  }
		  
		
		

	}

}
