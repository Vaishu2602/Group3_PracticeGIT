package Sprint_01;

/*
* Test Steps:
1. Login to https://login.salesforce.com
2. Click on the toggle menu button from the left corner
3. Click View All and click Legal Entities from App Launcher
// //p[contains(text(),'Legal Entities')]
4. Click on the Dropdown icon in the legal Entities tab
* //*[@title='Opportunities']/following::div[11]
5. Click on New Legal Entity
* //span[contains(text(), 'New Legal Entity')]
6. Enter Name as 'Salesforce Automation by *Your Name*'
//input[@name='Name']

7.Click save and verify Legal Entity Name
//button[@name='SaveEdit']
Expected Result:The Legal Entity is created Successfully
"Legal Entity "Stalin Durai" was created."

Step Video: https://drive.google.com/file/d/1JoZH4TIpasqcF4E2XfZIy-46iut9ApPm/view?usp=sharing9*
*
* */

import org.jsoup.nodes.Entities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class S6_023_CreateLegalEntity  extends TestBase{


    @Test
    public void createLegalEntity() throws InterruptedException{

        //Click on toggle menu button from the left corner
        driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();

        //click on 'View All'
        driver.findElement(By.xpath("//*[text()='View All']")).click();

        //Click View All and click Legal Entities from App Launcher
        WebElement eleAccounts = driver.findElement(By.xpath("//p[contains(text(),'Legal Entities')]"));
        driver.executeScript("arguments[0].click();", eleAccounts);


        //Click on the Dropdown icon in the legal Entities tab
        driver.findElement(By.xpath("//*[@title='Recently Viewed | Legal Entities']/following::one-app-nav-bar-item-dropdown[2]/div")).click();
//        driver.findElement(By.xpath("//*[@title='Recently Viewed | Legal Entities']/following::div[1]")).click();

        Thread.sleep(3000);

        //Click on New Legal Entity
        WebElement eleNewLegalentity = driver.findElement(By.xpath("//span[text() = 'New Legal Entity']"));
        driver.executeScript("arguments[0].click();", eleNewLegalentity);

//        driver.findElement(By.xpath("//*[contains(text(), 'New Legal Entity')]")).click();

        //Enter Name as 'Salesforce Automation by *Your Name*'
        driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Stalin Durai");

        //Click save and verify Legal Entity Name
        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();

        //Verify Work Type Group Name
        String text = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
        String expected = "Legal Entity \"Stalin Durai\" was created.";
        String actual = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
        Assert.assertTrue(actual.contains(expected));
        System.out.println(text);

        driver.close();
        driver.quit();

    }

}
