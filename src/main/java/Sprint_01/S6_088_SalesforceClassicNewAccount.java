package Sprint_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class S6_088_SalesforceClassicNewAccount {

	@Test
	public void s6_088_salesforceClassicNewAccount() {
		// TODO Auto-generated method stub
//		1. Navigate to Salesforce login page
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

//		2. Enter username as 'leaners@testleaf.com' and password as 'Leaf@1234' and click on the 'Login' button.
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		
//		3. Choose 'Account' from the dropdown
		WebElement AppLauncher = driver.findElement(By.xpath("//button[@title='App Launcher']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(AppLauncher).build().perform();
		driver.executeScript("arguments[0].click()", AppLauncher);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search apps')]")).sendKeys("Work Type Groups");

		
//		4. Click on the 'Go!' button.
//		5. Enter the Account Name as 'BootCamp Puppeteer_<Your Name>'
//		6. Enter the Billing Address
//		7. Click Copy Billing Address to Shipping Address link
//		8. Verify the Shipping Address reflects the Billing Address
//		9. Enter the SLA Expiration Date as Current Date + 20 days
//		10. Click on Save button.
//		11. Verify the newly creatd item under Recent Items and verify the new account form is dispalyed
//		12. Navigate to Accounts tab and Verify the newly Created account is displayed
//		13. Close the browser Expected Result:
//		Verify the newly Created account is displayed

	}
}
