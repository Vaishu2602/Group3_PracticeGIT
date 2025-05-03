package Sprint_01;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class S6_005_CreateWorkTypeGroup_Default {

    /*
    * Test Steps:
1. Login to https://login.salesforce.com
2. Click on the toggle menu button from the left corner
3. Click View All and click Work Type Groups from App Launcher
* //*[@data-label='Work Type Groups']
4. Click on the Dropdown icon in the Work Type Groups tab
5. Click on New Work Type Group
6. Enter Work Type Group Name as 'Salesforce Automation by *Your Name*'
//*[@name='Name']
//*[@id='combobox-button-211']
//*[contains(text(), 'combobox-button']
7.Click save and verify Work Type Group Name
//button[@name='SaveEdit']

Expected Result:
The Work Type Group is created Successfully
Step Video:
https://drive.google.com/file/d/1yzgZeBKH9TesJV5vm92c6-9Sffn6Ie63/view?usp=sharing
    *
    * */

    @Test
    public void createWorkType() throws InterruptedException{
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://login.salesforce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

        //Step 1: Login to Login | Salesforce
        driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
        driver.findElement(By.id("password")).sendKeys("Leaf$321");
        driver.findElement(By.id("Login")).click();

        //Click on toggle menu button from the left corner
        driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();

        //click on 'View All'
        driver.findElement(By.xpath("//*[text()='View All']")).click();

        Thread.sleep(4000);
        try{
            //Dismiss the Alert
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        }catch (Exception e){

        }
        //Click on Work Type Groups from App Launcher
        WebElement eleAccounts = driver.findElement(By.xpath("//p[contains(text(),'Work Type Groups')]"));
        driver.executeScript("arguments[0].click();", eleAccounts);

        //Click on New Work Type Group
        driver.findElement(By.xpath("//div[@title='New']")).click();

        //Enter Work Type Group Name as 'Salesforce Automation by *Your Name*'
        driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Stalin Durai");

        //Click save
        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();

        //Verify Work Type Group Name
        String text = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
        String expected = "Work Type Group \"Stalin Durai\" was created.";
        String actual = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
        Assert.assertEquals(expected, actual);
        System.out.println(text);

        driver.close();
        driver.quit();

    }


}
