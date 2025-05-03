package Sprint_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class S6_012_DeleteCase {

	@Test
	public void s6_012_DeleteCase() throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

//		Login to https://login.salesforce.com 
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();

//			Click on the toggle menu button from the left corner
		WebElement AppLauncher = driver.findElement(By.xpath("//button[@title='App Launcher']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(AppLauncher).build().perform();

		driver.executeScript("arguments[0].click()", AppLauncher);

//			Click View All and click Sales from App Launcher 
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();

//			Click on Cases tab
		// WebElement MoreDropdown =
		// driver.findElement(By.xpath("(//span[text()='More']//following::lightning-icon[contains(@class,'down')])[1]//span"));

		WebElement MoreDropdown = driver.findElement(By.xpath("//span[text()='More']"));
		try {
			MoreDropdown.click();
		} catch (StaleElementReferenceException e) {
			// MoreDropdown =
			// driver.findElement(By.xpath("(//span[text()='More']//following::lightning-icon[contains(@class,'down')])[1]//span"));
			MoreDropdown = driver.findElement(By.xpath("//span[text()='More']"));
		}
		MoreDropdown.click();

		WebElement CaseOption = driver.findElement(By.xpath("(//span[text()='Cases'])[2]"));
		driver.executeScript("arguments[0].click()", CaseOption);

//			⦁	Click on New Case
		driver.findElement(By.xpath("//div[text()='New']")).click();

//			⦁	Choose Contact Name from the dropdown
		WebElement contactNameDropdown = driver.findElement(By.xpath("//input[@placeholder='Search Contacts...']"));
		contactNameDropdown.sendKeys("Gokul Sekar");

		driver.findElement(By.xpath(
				"(//label[text()='Contact Name']//following::lightning-base-combobox-formatted-text[@title='Gokul Sekar'])[1]"))
				.click();

//			⦁	Select Case origin as email
		driver.findElement(By.xpath("//label[text()='Case Origin']//following::button[@aria-label='Case Origin']"))
				.click();
		driver.findElement(By.xpath(
				"//label[text()='Case Origin']//following::button[@aria-label='Case Origin']//following::span[text()='Email']"))
				.click();

//			⦁	Select status as Escalated
		driver.findElement(By.xpath("//label[text()='Status']//following::button[@aria-label='Status']")).click();
		driver.findElement(By.xpath("//label[text()='Status']//following::span[text()='Escalated']")).click();

//			⦁	Enter Subject as 'Testing' and description as 'Dummy'
		driver.findElement(By.xpath("//label[text()='Subject']//following::input[@name='Subject']"))
				.sendKeys("Testing");
		driver.findElement(By.xpath("(//label[text()='Description']//following::textarea)[1]")).sendKeys("Dummy");

//			⦁	Click 'Save' and verify the message
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		String CaseCreatedtext = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
		System.out.println(CaseCreatedtext);

//		Click on Cases tab
		WebElement CasesTab = driver.findElement(By.xpath("//a[@title='Cases']"));
		driver.executeScript("arguments[0].click()", CasesTab);

//			Click on the Dropdown icon and select Delete from the case you created by reffering 'case owner alias'
		WebElement RowDropDown = driver
				.findElement(By.xpath("//table[@aria-label='Recently Viewed']//tbody//tr[1]//td[7]//span"));
		try {
			RowDropDown.click();
		} catch (StaleElementReferenceException e) {
			RowDropDown = driver
					.findElement(By.xpath("//table[@aria-label='Recently Viewed']//tbody//tr[1]//td[7]//span"));
		}
		RowDropDown.click();

		WebElement DeleteOption = driver.findElement(By.xpath("//a[@title='Delete']"));
		driver.executeScript("arguments[0].click()", DeleteOption);
		Thread.sleep(3000);

		driver.findElement(By.xpath("//h1[text()='Delete Case']//following::span[text()='Delete']")).click();

		Thread.sleep(2000);
//			Verify the case with your name is deleted or not
		String CaseDeletedText = driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']")).getText();
		System.out.println(CaseDeletedText);
		if (CaseDeletedText.contains("deleted")) {
			System.out.println("Case is Deleted");
		} else {
			System.out.println("Case is not deleted.");
		}

	}

}
