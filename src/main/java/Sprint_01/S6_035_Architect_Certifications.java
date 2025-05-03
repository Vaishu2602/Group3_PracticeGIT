package Sprint_01;

/*
* Launch Salesforce application.

Login with username and password.

Click on Learn More link in Mobile Publisher
4.Click confirm in the redirecting page.

Click on the Learning and select Learning on trailhead

Click on  Salesforce Certification
7.Select Salesforce Architect.

Verify the Page title after selecting Architect

Verify the Certifications listed for Architect""                                                                     Expected Result:

Page title should be chaged to ""Certification - Architect Overview""

Below Certifications should be displayed
a) Application Architect
b) B2C Commerce Architect
c) Heroku Architecture Designer
d) System Architect
e) Technical Architect
*
* */

import io.github.sukgu.Shadow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class S6_035_Architect_Certifications extends TestBase{

    @Test
    public void verifyCerts() throws InterruptedException{

        Shadow dom = new Shadow(driver);

        //Click on Learn More link in Mobile Publisher
        driver.findElement(By.xpath("//*[@title='Learn More']")).click();

        //Click confirm in the redirecting page.
        String current = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> i1 = handles.iterator();
        while(i1.hasNext()){
            String childWindow = i1.next();
            if(!current.equalsIgnoreCase(childWindow)){
                driver.switchTo().window(childWindow);
            }
        }
        driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();

        //Click on 'Accept Cookies'
        driver.findElement(By.xpath("//button[contains(text(), 'Accept All Cookies')]")).click();

        //Click on the Learning
        WebElement learning = dom.findElementByXPath("//span[contains(text(), 'Learning')]");
        learning.click();

        Thread.sleep(3000);

        //MouseOver Learning on trailhead
        WebElement trailhead = dom.findElementByXPath("//span[contains(text(), 'Learning on Trailhead')]");
        Actions actions = new Actions(driver);
        actions.moveToElement(trailhead).perform();

        //Salesforce Certification
        WebElement certification = dom.findElementByXPath("//a[contains(text(), 'Salesforce Certification')]");
        certification.click();

        //Click on 'Solution Architect'
        driver.findElement(By.xpath("//div[@class='roleMenu-item_text'][text()='Architect']")).click();

        //Verify -- Page title should be chaged to ""Certification - Architect Overview""
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Certification - Architect Overview"));

        //Verify the Certifications listed for Architect""
        List<WebElement> list = driver.findElements(By.xpath("//*[@class='slds-container--center slds-container--x-large slds-p-top--small']/div/div[*]/div/div[3]/a[1]"));
        List<String> strList = new ArrayList<String>();
        for(int i=0;i< list.size();i++){
            strList.add(list.get(i).getText());
        }

        String[] str = {"Application Architect", "B2C Commerce Architect", "Heroku Architect", "System Architect", "Technical Architect"};
        for(int i=0;i< str.length;i++){
            Assert.assertTrue(strList.contains(str[i]));

        }

        driver.close();
        driver.quit();
    }
}
