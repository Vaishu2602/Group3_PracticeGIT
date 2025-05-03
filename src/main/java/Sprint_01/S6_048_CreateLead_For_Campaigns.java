package Sprint_01;

/*
* Test Steps:
1. Login to https://login.salesforce.com
2. Click on toggle menu button from the left corner
3. Click view All and click Sales from App Launcher
4. Click on  Campaigns tab
5. Click Bootcamp link
6. Click Add Leads
7. Click on New Lead
8. Pick Salutation as 'Mr.'
9. Enter first name as <your First Name>
10. Enter last name as <your last name>
11. Enter company as 'TestLeaf'
12. Click Save
13. Click Next
14. Click Submit on the Add to Campaign pop up
15. verify the created Lead under Campaign
16. Navigate to Leads tab
17. Search for Lead with your Name
Expected Result: Lead should be created in Leads tab and associated to Campaign
*
* */

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class S6_048_CreateLead_For_Campaigns extends TestBase{

    @Test
    public void createLead() throws InterruptedException{

        Thread.sleep(1000);

        //Click on toggle menu button from the left corner
        driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();

        //click on 'View All'
        driver.findElement(By.xpath("//*[text()='View All']")).click();

        Thread.sleep(1000);

        //Click on  Campaigns tab
        WebElement eleAccounts = driver.findElement(By.xpath("//p[contains(text(),'Campaigns')]"));
        driver.executeScript("arguments[0].click();", eleAccounts);

        //Click Bootcamp link
        driver.findElement(By.xpath("//*[@title='Bootcamp']")).click();

        //Click Add Leads
        driver.findElement(By.xpath("//div[@title='Add Leads']")).click();

        WebElement eleLeadSearch = driver.findElement(By.xpath("//input[@title='Search Leads']"));
        driver.executeScript("arguments[0].click();", eleLeadSearch);

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@title='Search Leads']")).sendKeys("a");
        driver.findElement(By.xpath("//input[@title='Search Leads']")).clear();
//        driver.findElement(By.xpath("//input[@title='Search Leads']")).click();
//        driver.findElement(By.xpath("//*[@icon-name='utility:search']")).click();


        //click on New Lead
        driver.findElement(By.xpath("//span[@title='New Lead']")).click();

        //Pick Salutation as 'Mr.'
        driver.findElement(By.xpath("//*[@class='salutation compoundTLRadius compoundTRRadius compoundBorderBottom form-element__row uiMenu']")).click();
        driver.findElement(By.xpath("//*[@title='Mr.']")).click();

        //Enter first name as <your First Name>
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Stalin");

        //Enter last name as <your last name>
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Durai");

        //Enter company as 'TestLeaf'
        driver.findElement(By.xpath("//label/span[contains(text(), 'Company')]/following::input[1]")).sendKeys("Testleaf");

        //Click Save
        driver.findElement(By.xpath("//*[@class='forceModalActionContainer--footerAction forceModalActionContainer']/button[2]")).click();

        Thread.sleep(1000);

        //Click Next
        driver.findElement(By.xpath("//*[@class='modal-footer slds-modal__footer']/button[text()='Next']")).click();

        Thread.sleep(1000);

        //Click Submit on the Add to Campaign pop up
        driver.findElement(By.xpath("//*[@class='modal-footer slds-modal__footer']/button[(text()='Submit')]")).click();

        String text = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
        System.out.println(text);
        String expected = "Lead \"Stalin Durai\" was created";
        String actual = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
        Assert.assertTrue(actual.contains(expected));
        System.out.println(text);

        //verify the created Lead under Campaign

        //Navigate to Leads tab
        WebElement ele = driver.findElement(By.xpath("//a[@title='Leads']"));
        driver.executeScript("arguments[0].click();", ele);

        driver.navigate().refresh();

        Thread.sleep(1000);

        //Search for Lead with your Name
        WebElement eleSearch = driver.findElement(By.xpath("//*[@name='Lead-search-input']"));
        driver.executeScript("arguments[0].click();", eleSearch);

        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@name='Lead-search-input']")).sendKeys("S Dasda");
        driver.findElement(By.xpath("//*[@name='Lead-search-input']")).sendKeys(Keys.ENTER);

        String exp = "S Dasda";
        String act = driver.findElement(By.xpath("//a[@title='S Dasda']")).getText();
        Assert.assertTrue(act.contains(exp));

        driver.close();
        driver.quit();

    }
}
