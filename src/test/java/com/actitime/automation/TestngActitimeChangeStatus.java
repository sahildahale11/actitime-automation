package com.actitime.automation;

import com.actitime.automation.common.CommonFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;

public class TestngActitimeChangeStatus {
    WebDriver driver;
    CommonFunction commonFunction;

    @BeforeClass
    public void setup() throws InterruptedException {
        commonFunction = new CommonFunction();
        driver = commonFunction.launchBrowser("chrome");
        driver.get("https://online.actitime.com/sd1/tasks/tasklist.do");
        Thread.sleep(5000);

    }

    @Test
    public void changeStatus() throws Exception {
        commonFunction.loginUserforactiTime("sahil.dahale98@gmail.com", "Pass@123");

        // Create a FluentWait object with a timeout of 30 seconds and a polling interval of 1 second
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(Exception.class); // Ignore any exception during polling

        // Wait for Time-Track element
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='container_tt']/following-sibling::div[1]")));
        String timeTrack = driver.findElement(By.xpath("//div[@id='container_tt']/following-sibling::div[1]")).getText();
        Assert.assertEquals(timeTrack, "Time-Track", "Test Case Fail, Unable to login application");

        // Click on task element
        fluentWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='container_tasks']")));
        driver.findElement(By.xpath("//div[@id='container_tasks']/following::div[1]")).click();


        // Click on Change Status
        WebElement element = driver.findElement(By.xpath("//div[@class='createdTasksTableContainer']/following::div[3]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        fluentWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='createdTasksTableContainer']/following::div[3]"))).click();
        // Click on Change Status
        fluentWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Change Status']"))).click();

        // Click on New Status dropdown
        fluentWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='New Status:']/following::div[6]")));
        driver.findElement(By.xpath("//div[text()='New Status:']/following::div[6]")).click();

        //Click on Planning Button
        fluentWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[27]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[3]/div[1]/div[3]")));
        driver.findElement(By.xpath("//body/div[27]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[3]/div[1]/div[3]")).click();


        // Click on Apply button
        WebElement applyButton = driver.findElement(By.xpath("//span[text()='Apply']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", applyButton);


        // Verify status change
//        fluentWait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//tbody/tr[1]/td[3]/div[1]/div[1]/div[1]/div[3]"), "Planning"));
//        String statusChange = driver.findElement(By.xpath("//tbody/tr[1]/td[3]/div[1]/div[1]/div[1]/div[3]")).getText();
//        Assert.assertEquals(statusChange, "Planning", "Status not changed to Planning");
//        System.out.println("Status changed to: " + statusChange);
//    }
        FluentWait<WebDriver> fluentWait1 = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class);

        fluentWait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[3]/div[1]/div[1]/div[1]/div[3]")));

        WebElement statusElement = driver.findElement(By.xpath("//tbody/tr[1]/td[3]/div[1]/div[1]/div[1]/div[3]"));
        String statusChange = statusElement.getText();
        System.out.println("Changed Status : "+statusChange);


    }
}
