package Sprint_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class S6_078_DeletePayment {
	
	@Test
	public void s6_078_DeletePayment() throws InterruptedException {
		// TODO Auto-generated method stub
		
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");

			ChromeDriver driver = new ChromeDriver(options);
			//Launch the app
			driver.get("https://login.salesforce.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().window().maximize();
			
			//click login
			driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
			driver.findElement(By.id("password")).sendKeys("Leaf$321");
			driver.findElement(By.id("Login")).click();
			
			//Click on Global Actions SVG icon and click View All
			Thread.sleep(2000);
			WebElement AppLauncher = driver.findElement(By.xpath("//button[@title='App Launcher']"));
			Actions actions = new Actions(driver);
			actions.moveToElement(AppLauncher).build().perform();

			driver.executeScript("arguments[0].click()", AppLauncher);

			//Click View All and click PAyment Authorizations from App Launcher 
			driver.findElement(By.xpath("//button[text()='View All']")).click();
			driver.findElement(By.xpath("//input[contains(@placeholder,'Search apps')]")).sendKeys("Payment Authorizations");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[text()='Payment Authorizations']")).click();
			
			//Click on the Svg Icon of the payment account which was previously created in the create payment testcase and Click on the Svg Icon present at the end of the account number and click delete option
			Thread.sleep(3000);
			String PaymentNumber = driver.findElement(By.xpath("//table//tbody//tr[1]/th//a[text()]")).getText();
			driver.findElement(By.xpath("//table//tbody//tr[1]/td[6]//a")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@title='Delete']")).click();
	
			//Click on Delete button
			Thread.sleep(2000);
			driver.findElement(By.xpath("//h1[text()='Delete Payment Authorization']//following::button[@title='Delete']")).click();
			
			//Verify the payment is deleted 
			Thread.sleep(2000);
			WebElement Verification = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]"));
			Assert.assertTrue(Verification.isDisplayed());
			String Verificationtext = Verification.getText();
			Assert.assertTrue(Verificationtext.contains(PaymentNumber));
			System.out.println(Verificationtext);	
			Assert.assertFalse(driver.getPageSource().contains(PaymentNumber));
			System.out.println("Payment is deleted successfully");
			driver.getPageSource().contains(PaymentNumber);
		
		}
}
