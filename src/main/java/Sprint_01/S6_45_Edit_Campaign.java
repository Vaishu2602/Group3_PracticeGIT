package Sprint_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

@Test
public class S6_45_Edit_Campaign {

	public void editCampaign() throws InterruptedException {
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
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();

		// Click view All and click Sales from App Launcher--view all-sales
		Thread.sleep(6000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();

		driver.findElement(By.xpath("//p[text()='Sales']")).click();

		WebElement campaigns = driver.findElement(By.xpath("//a[@title='Campaigns']"));
		driver.executeScript("arguments[0].click();", campaigns);

		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='Bootcamp']")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Details']")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@title='Edit End Date']")).click();

		Thread.sleep(2000);
		WebElement datepick = driver.findElement(By.xpath("(//span[text()='Date Picker'])[2]"));
		driver.executeScript("arguments[0].click();", datepick);

		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@aria-selected='true']//following::td[4]")).click();
		String revenueAmt = "10,00,000";
		driver.findElement(By.xpath("(//span[text()='Expected Revenue in Campaign'])[2]//following::input[1]"))
				.sendKeys(revenueAmt);
		String BudgetAmt = "1,00,000";
		driver.findElement(By.xpath("(//span[text()='Budgeted Cost in Campaign'])[2]//following::input[1]"))
				.sendKeys(BudgetAmt);

		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();

		Thread.sleep(5000);
		WebElement revenue = driver.findElement(By.xpath(
				"(//span[text()='Expected Revenue in Campaign'])[1]//following::span[@class='forceOutputCurrency'][1]"));
		Object revenuetext = driver.executeScript("return arguments[0].innerText;", revenue);
		String revenueString = ((String) revenuetext).replace("₹", "").trim();
	//	WebElement budget = driver.findElement(By.xpath(
	//			"(//span[text()='Expected Revenue in Campaign'])[1]//following::span[@class='forceOutputCurrency'][3]"));
	//	Object budgettext = driver.executeScript("return argum	ents[0].innerText;", budget);
	//	String budgetString = ((String) budgettext).replace("₹", "").trim();
		if (revenueAmt.equals(revenueString)) {

			System.out.println("Values Updated Successfully");
			System.out.println("Revenue:₹"+revenueAmt);
			System.out.println("Budget :₹"+BudgetAmt);
		}

	}

}
