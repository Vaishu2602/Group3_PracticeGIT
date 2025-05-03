package Sprint_01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/*
* Test Steps:
1. Login to https://login.salesforce.com
2. Click on the toggle menu button from the left corner
3. Click View All and click Dashboards from App Launcher
4. Click on the Dashboards tab
5. Search the Dashboard 'Salesforce Automation by *Your Name*'
6. Click on the Dropdown icon and Select Edit
7.Click on the Edit Dashboard Properties icon
8. Enter Description as 'SalesForce' and click on save.
9. Click on Done and  Click on save in the popup window displayed.
10. Verify the Description.
Expected Result: The Dashboard is Edited Successfully
Step Video: https://drive.google.com/file/d/1G0jv2KquvgDXsrGOMFMeUiNng4wL_Pv1/view?usp=sharing
* */

public class S6_029_Edit_Dashboard extends TestBase{

    @Test
    public void editDashboard() throws InterruptedException {

        //Click on toggle menu button from the left corner
        driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();

        //click on 'View All'
        driver.findElement(By.xpath("//*[text()='View All']")).click();

        Thread.sleep(3000);

        //Click on the Dashboards tab
        WebElement eleAccounts = driver.findElement(By.xpath("//p[contains(text(),'Dashboards')]"));
        driver.executeScript("arguments[0].click();", eleAccounts);

        String txt = "Dashboard Stalin";

        Thread.sleep(3000);

        //Click on the dropdown
        List<WebElement> table = driver.findElements(By.xpath("//tbody/tr[*]"));
        for(int i=1;i< table.size();i++){


            if(driver.findElement(By.xpath("//tbody/tr["+i+"]")).getText().contains(txt)){
                driver.findElement(By.xpath("//tbody/tr["+i+"]/td[6]")).click();
                break;
            }
        }

        Thread.sleep(3000);

        //Click on Edit
        WebElement ele = driver.findElement(By.xpath("//lightning-menu-item[2]/div/a/span[contains(text(), 'Edit')]"));
        driver.executeScript("arguments[0].click();", ele);

        Thread.sleep(6000);

        WebElement frame = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
        driver.switchTo().frame(frame);

        driver.findElement(By.xpath("//*[@id='main']/div/div[1]/div[1]/div/div/span/button")).click();

        driver.findElement(By.name("dashboard-title")).clear();
        driver.findElement(By.name("dashboard-title")).sendKeys("Appended Salesforce");

        driver.findElement(By.xpath("//button[contains(text(), 'Save')]")).click();

        driver.switchTo().defaultContent();


        String text = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
        System.out.println(text);
        String expected = "Dashboard saved";
        String actual = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
        Assert.assertTrue(actual.contains(expected));
        System.out.println(text);

        driver.close();
        driver.quit();
    }
}
