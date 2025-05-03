package Sprint_01;

/*
* Test Steps:
1. Login to https://login.salesforce.com
2. Click on toggle menu button from the left corner
3. Click view All and click Sales from App Launcher
4. Click on Opportunity tab
* //*[@title='Opportunities']/following::div[1]
5. Search the Opportunity 'Salesforce Automation by *Your Name*'
//span[contains(text(), 'Stalin')]

6. Click on  the Dropdown icon and Select Delete
//button[@name='Clone']
//*[@title='Clone']/ancestor::li/following-sibling::li
//span[contains(text(), 'Delete')]
//*[@title='Delete']
7. Verify Whether Oppurtunity is Deleted using Oppurtunity Name
Expected Result: Oppurtunity is Successfully deleted
Step Video: https://drive.google.com/file/d/1ZQSDwwQzwOiZX9PAhsjbbxJANZ-fW5od/view?usp=sharing
*
* */

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class S6_016_DeleteOpportunity extends TestBase{

    @Test
    public void deleteOpportunity() throws InterruptedException{

        //Click on toggle menu button from the left corner
        driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();

        //click on 'View All'
        driver.findElement(By.xpath("//*[text()='View All']")).click();

        Thread.sleep(4000);

        //click on 'Sales'
        driver.findElement(By.xpath("//*[text()='Sales']")).click();

        //Click on Opportunity tab
        driver.findElement(By.xpath("//*[@title='Opportunities']/following::div[1]")).click();

        //Search the Opportunity 'Salesforce Automation by *Your Name*'
        WebElement eleName = driver.findElement(By.xpath("//span[contains(text(), 'Stalin')]"));
        driver.executeScript("arguments[0].click();", eleName);

        //Click on  the Dropdown icon and Select Delete
        driver.findElement(By.xpath("//*[@title='Clone']/ancestor::li/following-sibling::li")).click();

        //Confirm 'Delete'
        driver.findElement(By.xpath("//*[@title='Delete']")).click();
        driver.findElement(By.xpath("//button[@title='Delete']")).click();

        String text = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
        String expected = "Opportunity \"Opp4 by Stalin\" was deleted";
        String actual = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
        Assert.assertTrue(actual.contains(expected));
        System.out.println(text);


    }
}
