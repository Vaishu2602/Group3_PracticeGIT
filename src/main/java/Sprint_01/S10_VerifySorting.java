package Sprint_01;

import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class S10_VerifySorting {
	
	
	@Test
	public void SortAccountname() throws InterruptedException {

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
		driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();

		// Click view All and click Sales from App Launcher--view all-sales
		Thread.sleep(6000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();

		driver.findElement(By.xpath("//p[text()='Sales']")).click();

		// Click on Accounts tab

		WebElement Accounts = driver.findElement(By.xpath("//a[@title='Accounts']"));
		driver.executeScript("arguments[0].click();", Accounts);
		// tbody//tr//a
		// tbody//tr//th//a | //tbody//tr//td/a
		// tbody//tr//a[@data-refid='recordId']
		// th//a[@data-refid='recordId']
//		Thread.sleep(8000);
//
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	

		       // js.executeScript("window.scrollBy(0,950)", "");

	/*	long scrollHeight = 0;
		long previousHeight = -1;
		int retries = 0;
		
		while (true) {
			// Scroll down by 1000 pixels
			js.executeScript("window.scrollBy(0, 1000);");

			// Pause to allow content to load
			Thread.sleep(2000); // Adjust if necessary based on load speed

			// Get the new scroll height after the scroll
			scrollHeight = (Long) js.executeScript("return document.body.scrollHeight");

			// If the scroll height has not increased, check for retries and exit if max
			// retries are reached
			if (scrollHeight == previousHeight) {
				retries++;
				if (retries > 5) { // Allow a few retries before breaking
					break;
				}
			} else {
				retries = 0; // Reset retries if new content has loaded
			}

			previousHeight = scrollHeight;
		}
		*/
		WebElement elements = driver.findElement(By.xpath("//a[@data-refid='recordId']"));
	Actions ac=new Actions(driver);
		for(int i=0;i<30;i++) {
			ac.clickAndHold().dragAndDrop(Accounts, elements);
		ac.sendKeys(Keys.PAGE_DOWN);
		}
		
		/*long lastHeight = (Long) js.executeScript("return document.documentElement.scrollHeight");
		int attempts = 0;
		int maxAttempts = 5;

		while (attempts < maxAttempts) {
		    js.executeScript("window.scrollTo(0, document.documentElement.scrollHeight);");
		    Thread.sleep(3000);

		    long newHeight = (Long) js.executeScript("return document.documentElement.scrollHeight");

		    if (newHeight == lastHeight) {
		        attempts++;
		    } else {
		        attempts = 0;  // Reset if the page loaded more content
		    }

		    lastHeight = newHeight;
		}
*/
		

		List<WebElement> tableData = driver.findElements(By.xpath("//a[@data-refid='recordId']"));
		int sizeofAccounts = tableData.size();
		System.out.println("Size:" + sizeofAccounts);
		for (int i = 0; i < sizeofAccounts; i++) {

			String AcountNames = tableData.get(i).getText();

			System.out.println(AcountNames);
		}

		// Click sort arrow in the Account Name to sort in ascending order
		// a[@role='button']//span[text()='Account Name']
		// span[@title='Account Name']
		Thread.sleep(3000);
		WebElement AccountName = driver.findElement(By.xpath("//a[@role='button']//span[text()='Account Name']"));
		driver.executeScript("arguments[0].click();", AccountName);
		
		
		
		//verift if sorted ascending element is present/isPresent
		//span[text()='Sorted Ascending']
		//span[text()='Sorted Descending']
		
		boolean SortedAsc = driver.findElement(By.xpath("//span[text()='Sorted Ascending']")).isDisplayed();
		boolean SortedDesc = driver.findElement(By.xpath("//span[text()='Sorted Ascending']")).isDisplayed();
		
		if(SortedAsc) {
			System.out.println("Account Names are Sorted in Ascending");
		}
		else if(SortedDesc){
			System.out.println("Account Names are Sorted in Descending");

		}
		else{
			
			System.out.println("Not Sorted");
		}

	}

}
