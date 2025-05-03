package Sprint_01;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class S6_036_BoardExamSchedule {
	
	public static RemoteWebDriver driver;
	@Test
	public void s6_036_BoardExamSchedule() throws InterruptedException, MalformedURLException {
		
		EdgeOptions options = new EdgeOptions(); 
		options.addArguments("--disable-notifications");
		  DesiredCapabilities dc = new DesiredCapabilities(options); 
		  dc.setBrowserName("MicrosoftEdge"); //
		  dc.setPlatform(Platform.LINUX);
		  driver = new RemoteWebDriver(new URL("http://20.40.48.160:4444/wd/hub"), dc);


//		ChromeDriver driver = new ChromeDriver(options);
		Shadow dom = new Shadow(driver);
		 
		//Launch Salesforce application.
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		//Login with username  and password.
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		
		//Click on Learn More link in Mobile Publisher
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Mobile Publisher']//following::button[@title='Learn More']")).click();
		
		//Click confirm in the redirecting page.
		String mainWindow = driver.getWindowHandle();
		Set<String> childWindow = driver.getWindowHandles();
		
		for (String x : childWindow) {
			if(!x.equals(mainWindow)) {
				driver.switchTo().window(x);
			}
		}
		
		//Click confirm in the redirecting page.
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		Thread.sleep(3000);
		
		System.out.println(driver.getWindowHandle());
		
		//Click on the Learning and select Learning on trailhead
		Actions actions = new Actions(driver);
		dom.findElementByXPath("//span[text()='Learning']").click();
		Thread.sleep(2000);
		WebElement LearningOnTrailHead = dom.findElementByXPath("//span[text()='Learning on Trailhead']");
		actions.moveToElement(LearningOnTrailHead).build().perform();
		
		//Click on  Salesforce Certification
		Thread.sleep(3000);
		dom.findElementByXPath("//a[text()='Salesforce Certification']").click();
		Thread.sleep(3000);
		//Navigate to Certifications window
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getTitle());
		
		//Select Salesforce Architect
		driver.findElement(By.xpath("//div[@class='roleMenu-item_text'][text()='Architect']")).click();
		Thread.sleep(3000);
		
		//Click on LearnMore in Technical Architect Certification
		WebElement SystemArchitect = driver.findElement(By.xpath("//a[text()='System Architect']"));
		driver.executeScript("arguments[0].scrollIntoView(true)",SystemArchitect);
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[text()='Technical Architect']//preceding::a[text()='Learn More'])[5]")).click();
		Thread.sleep(5000);
		
		Set<String> AllWindowIDs = driver.getWindowHandles();
		List<String> AllWindowIdList = new ArrayList<String>(AllWindowIDs);
		driver.switchTo().window(AllWindowIdList.get(2));
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		
		List<WebElement> Verification = driver.findElements(By.xpath("//div[text()='About the CTA Credential']//following::ul[1]//li"));
		driver.executeScript("arguments[0].scrollIntoView(true)",driver.findElement(By.xpath("//div[text()='About the CTA Credential']")));
		Thread.sleep(3000);;
		String ArchitechtReviewBoardEvaluationText = Verification.get(0).getText();
		String TechnicalArchitectReviewBoardExamText = Verification.get(1).getText();
		
		
		Assert.assertTrue(Verification.get(0).isDisplayed(), ArchitechtReviewBoardEvaluationText);
		System.out.println(ArchitechtReviewBoardEvaluationText);
		Assert.assertTrue(Verification.get(1).isDisplayed(), TechnicalArchitectReviewBoardExamText);
		System.out.println(TechnicalArchitectReviewBoardExamText);
		driver.quit();
		
		
		
	}

}
