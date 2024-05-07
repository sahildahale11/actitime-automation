package com.actitime.automation;

import com.commonfunction.automation.CommonFunction;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class DeleteCustomerTestNg {
    WebDriver driver;

    @BeforeClass
    public void setup() throws InterruptedException {
        CommonFunction commonFunction = new CommonFunction();
        driver = commonFunction.launchBrowser("Chrome");
        driver.get("https://online.actitime.com/sd1/tasks/tasklist.do");
        Thread.sleep(5000);
        commonFunction.loginForActitime();
        Thread.sleep(7000);


    }

    @Test
    public void deleteCustomer() throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Click on task
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='container_tasks']/following::div[1]"))).click();
        // Search customer
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Add New']/following::input[1]"))).sendKeys("Mr.john Palekar");
        // click on customer
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='filteredContainer']/descendant::div[9]"))).click();
        // click on edit button
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='filteredContainer']/descendant::div[9]/following::div[2]"))).click();
        // click on action button
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='nameLabel'][text()='Mr.john Palekar']/following::div[6]"))).click();
        // click on delete button
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='deleteButton'])[1]"))).click();
        //  Click on  'Delete permanently'
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Delete permanently']"))).click();
        driver.navigate().refresh();
       WebElement deleteCustomerVerify= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Add New']/following::input[1]")));
       deleteCustomerVerify.sendKeys("Mr.john Palekar");
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='filteredContainer']/descendant::div[9]"))).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String text = alert.getText().trim();
        System.out.println("Alert text : "+text);
        if (text.equalsIgnoreCase("Selected customer has been deleted concurrently."))
       {
           System.out.println("Test Case Pass, Project will be deleted ");
       }
       else
       {
           throw new Exception("Test case failed , Project can not be deleted");
       }
       alert.accept();

    }
}
