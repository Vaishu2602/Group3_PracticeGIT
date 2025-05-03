package Sprint_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class S6_024_EditLegalEntity {
	@Test

	public void s6_024_EditLegalEntity() throws InterruptedException {

		String LegalEntityName = "Vaishu";

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
		// driver.executeScript("arguments[0].click()", AppLauncher);

		// Click View All and click Legal Entities from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search apps')]")).sendKeys("Legal Entities");

		// Click on the legal Entities tab
		driver.findElement(By.xpath("//*[text()='Legal Entities']")).click();

		Thread.sleep(3000);

//		Click on New Legal Entity
		driver.findElement(By.xpath("//div[@title='New']")).click();

//		Enter Name as 'Salesforce Automation by *Your Name*'
		driver.findElement(By.xpath("//label[text()='Legal Entity Name']//following::input[@name='Name']"))
				.sendKeys(LegalEntityName);

//		Click save and verify Legal Entity Name
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(2000);
		String LegalEntityNameCreatedText = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]"))
				.getText();
		System.out.println(LegalEntityNameCreatedText);

		Thread.sleep(3000);

		// Search the Legal Entity 'Salesforce Automation by *Your Name*'
		driver.findElement(
				By.xpath("(//a[contains(@title,'Legal Entity')]//following::one-app-nav-bar-menu-button)[1]//a"))
				.click();
		WebElement MyLegalEntities = driver
				.findElement(By.xpath("//p[text()='Recent lists']//following::span[text()='My Legal Entities']"));
		driver.executeScript("arguments[0].click()", MyLegalEntities);

		driver.findElement(By.xpath("//input[contains(@placeholder,'Search this list...')] "))
				.sendKeys(LegalEntityName);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search this list...')] ")).sendKeys(Keys.ENTER);

		// Click on the Dropdown icon and Select Edit

		WebElement FirstRowDropdown = driver.findElement(By.xpath("//table//tbody//tr[1]//td[6]"));
		try {
			FirstRowDropdown.click();
		} catch (Exception e) {
			FirstRowDropdown = driver.findElement(By.xpath("//table//tbody//tr[1]//td[6]"));
		}
		FirstRowDropdown.click();

		driver.findElement(By.xpath("//a[contains(@title,'Edit')]")).click();

		Thread.sleep(3000);
		// Enter the Company name as 'Tetsleaf'.
		driver.findElement(By.xpath("//label[text()='Company Name']//following::input[@name='CompanyName']"))
				.sendKeys("Testleaf");

		// Enter Description as 'SalesForce'.
		driver.findElement(By.xpath("//label[text()='Description']//following::textarea")).sendKeys("SalesForce");

		// Select Status as 'Active'
		Thread.sleep(3000);
		WebElement StatusDropdown = driver
				.findElement(By.xpath("//label[text()='Status']//following::button[@data-value='--None--']"));
		driver.executeScript("arguments[0].scrollIntoView(true)", StatusDropdown);
		Thread.sleep(2000);
		driver.executeScript("arguments[0].click()", StatusDropdown);
		driver.findElement(By.xpath("//span[text()='Active']")).click();

		// Click on Save and Verify Status as Active
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		System.out.println("Saved");
		Thread.sleep(2000);

		String FirstRowStatusText = driver.findElement(By.xpath("(//table//tbody//tr[1]//td[5]//span)[2]")).getText();
		String FirstRowLegalEntityName = driver.findElement(By.xpath("//table//tbody//tr[1]//th//a")).getText();
		if (FirstRowLegalEntityName.equals(LegalEntityName) && FirstRowStatusText.contentEquals("Active")) {
			System.out.println("Status is verified");
		} else {
			System.out.println("Status not verified");
		}
		System.out.println("Entity Name : " + FirstRowLegalEntityName + " Status: " + FirstRowStatusText);

	}

}
