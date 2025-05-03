package Sprint_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class S6_030_DeleteDashboard {

	@Test
	public void s6_030_DeleteDashboard() throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

		// Login to https://login.salesforce.com
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();

		// Click on the toggle menu button from the left corner
		WebElement AppLauncher = driver.findElement(By.xpath("//button[@title='App Launcher']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(AppLauncher).build().perform();
		AppLauncher.click();

		// Click View All and click Dashboards from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search apps')]")).sendKeys("Dashboards");

		// Click on the Dashboards tab
		driver.findElement(By.xpath("//*[text()='Dashboards']")).click();

		// Search the Dashboard 'Salesforce Automation by *Your Name*'
		Thread.sleep(5000);
		String FirstRowDashboardName = driver.findElement(By.xpath("(//table//tbody//tr//th[1]//child::a)[1]"))
				.getText();
		driver.findElement(By.xpath("//input[@placeholder='Search recent dashboards...']"))
				.sendKeys(FirstRowDashboardName);

		// Click on the Dropdown icon and Select Delete
		Thread.sleep(3000);
		WebElement FirstRowDropdown = driver
				.findElement(By.xpath("(//table//tbody//tr[1]//td[1]//following::button)[1]"));
		driver.executeScript("arguments[0].click()", FirstRowDropdown);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Delete']//parent::a")).click();

		// Click on the Delete option in the displayed popup window.
		Thread.sleep(3000);
		driver.findElement(By.xpath("//h1[text()='Delete Dashboard']//following::button[@title='Delete']")).click();
		Thread.sleep(3000);

		// Verify Whether Dashboard is Deleted using Dashboard Name
		String DashboardDeletedText = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
		if (DashboardDeletedText.contains("deleted")) {
			System.out.println("Dashboard is deleted successfullyt");
		} else {
			System.out.println("Dashboard is not deleted successfully");
		}

	}
}
