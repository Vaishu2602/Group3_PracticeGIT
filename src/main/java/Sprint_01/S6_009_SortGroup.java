package Sprint_01;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class S6_009_SortGroup {
	@Test
	public void testA() throws InterruptedException
	{
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		//Launch the app
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		//Click Login
		driver.findElement(By.id("Login")).click();
		
		//Click on the App Laucher Icon left to Setup
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		//Click View All and click Work Type Groups from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//Click on the Work Type Group tab
		driver.findElement(By.xpath("//p[text()='Work Type Groups']")).click();
		//WebElement eleAccounts = driver.findElement(By.xpath("//p[text()='Work Type Groups']"));
		//driver.executeScript("arguments[0].click();", eleAccounts);
		//Click the sort arrow in the Work Type Group Name
		//WebElement element = driver.findElement(By.xpath("//span[text()='Work Type Group Name']"));
		//driver.executeScript("arguments[0].click();",element);
		Thread.sleep(3000);
		//Verify the Work Type Group displayed in ascending order by Work Type Group Name.
		String text = driver.findElement(By.xpath("(//a[@data-refid='recordId'])[1]")).getText();
		System.out.println(text);


}
	
}
