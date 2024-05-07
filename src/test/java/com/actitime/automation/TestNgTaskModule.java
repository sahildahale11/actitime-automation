package com.actitime.automation;

import com.commonfunction.automation.CommonFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestNgTaskModule {
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
    public void login() throws Exception {
        //login credentials
        commonFunction.loginUserforactiTime("sahil.dahale98@gmail.com", "Pass@123");

//        driver.findElement(By.name("username")).sendKeys("sahil.dahale98@gmail.com");
//        driver.findElement(By.name("pwd")).sendKeys("Pass@123");
//        driver.findElement(By.xpath("//a[@id='loginButton']/child::div")).click();
        Thread.sleep(10000);
        //  verify dashboard login
       /* String timeTrack = driver.findElement(By.xpath("//div[@id='container_tt']/following-sibling::div[1]")).getText();
        if (timeTrack.equals("Time-Track")) {
            System.out.println("Test Case Pass, Successfully landed on Time-Track module");
        } else {
            throw new Exception("Test Case Fail, Unable to login application");
        }
        Thread.sleep(10000);
        // click on TAsk
        driver.findElement(By.xpath("//div[@id='container_tasks']/following::div[1]")).click();
        Thread.sleep(5000);
        //Verify search box feature is working or not
        driver.findElement(By.xpath("//div[text()='Add New']/following::input[1]")).sendKeys("Galaxy Corporation");
        Thread.sleep(3000);
       String verifySearchBox = driver.findElement(By.xpath("//div[@class='filteredContainer']/descendant::div[9]")).getText();
       if (verifySearchBox.equals("Galaxy Corporation"))
       {
           System.out.println("Testcase passed,Search box is working Properly");
       }
       else {
           throw new Exception("Test case fail, search box is not working properly");
       }
        //click on Add New Button and verify button is clickable or not
        driver.findElement(By.xpath("//div[text()='Add New']")).click();
        String addCustumertext = driver.findElement(By.xpath("//div[text()='+ New Customer' or text()='+ New Project' or text()='+ New Tasks'or text()='Import Tasks from CSV']")).getText();
        if (addCustumertext.equals("+ New Customer") || addCustumertext.equals("+ New Project") || addCustumertext.equals("+ New Tasks")|| addCustumertext.equals("Import Tasks from CSV")) {
            System.out.println("Test Case pass : Add New Button Clickable");
        } else {
            throw new Exception("unable to search");
        }
        Thread.sleep(2000);
*/


        // Wait for Time-Track module to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='container_tt']/following-sibling::div[1]")));

        // Verify if Time-Track module is displayed
        String timeTrack = driver.findElement(By.xpath("//div[@id='container_tt']/following-sibling::div[1]")).getText();
        Assert.assertEquals(timeTrack, "Time-Track", "Test Case Fail, Unable to login application");

        // Wait for Task element to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='container_tasks']/following::div[1]")));

        // click on Task
        driver.findElement(By.xpath("//div[@id='container_tasks']/following::div[1]")).click();

        // Wait for search box to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Add New']/following::input[1]")));

        // Verify search box feature is working or not
        driver.findElement(By.xpath("//div[text()='Add New']/following::input[1]")).sendKeys("Galaxy Corporation");

        Thread.sleep(3000); // Introducing sleep to wait for search results to appear

        try {
            // Verify search box result
            String verifySearchBox = driver.findElement(By.xpath("//div[@class='filteredContainer']/descendant::div[9]")).getText();
            Assert.assertEquals(verifySearchBox, "Galaxy Corporation", "Test case fail, search box is not working properly");
        } catch (Exception e) {
            throw new Exception("Search box result not found");
        }

        // Wait for Add New button to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Add New']")));

        // Click on Add New Button and verify button is clickable or not
        driver.findElement(By.xpath("//div[text()='Add New']")).click();

        Thread.sleep(2000);

    }
}
