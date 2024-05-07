package com.actitime.automation;

import com.commonfunction.automation.CommonFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class TestNGLoginTest {
    WebDriver driver;



    @BeforeClass(groups ="regression")
    public void launchBrowser() throws InterruptedException {
        CommonFunction commonFunction = new CommonFunction();
        driver = commonFunction.launchBrowser("chrome");
        driver.get("https://online.actitime.com/sd1/tasks/tasklist.do");
        Thread.sleep(5000);
    }


    @DataProvider
    public Object[][] getTestData() {
        return new Object[][] {
                {"sahil.dahale98@gmail.com", "Pass@123", "Valid"},
//                {"sd.hingoli@gmail.com", "Pass", "Invalid"},
//                {"sahil@123gmail.com", "Pass@123", "Invalid"},
//                {"rrrmgr@gmail.com", "kmgk123", "Invalid"},
//                {"", "Pass@123", "Invalid"},
//                {"", "Pass@55523", "Invalid"},
//                {"sd.hingoli@gmail.com", "", "Invalid"},
//                {"hp@gamil.com", "", "Invalid"},
//                {"", "", "Invalid"},
        };
    }

    @Test(dataProvider = "getTestData",groups = "regression")
    public void Login(String username, String password,String status) throws Exception {


       driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("pwd")).sendKeys(password);
        driver.findElement(By.xpath("//a[@id='loginButton']/child::div")).click();
        Thread.sleep(10000);
       /* if (status.equals("Valid")) {
            String timeTrack = driver.findElement(By.xpath("//div[@id='container_tt']/following-sibling::div[1]")).getText();
            if (timeTrack.equals("Time-Track")) {
                System.out.println("Test Case Pass, Successfully landed on Time-Track module");
            } else {
                throw new Exception("Test Case Fail, Unable to login application");
            }
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@class='logoutContainer']/descendant::a[2]"))).click();
            String headerContainer = driver.findElement(By.id("headerContainer")).getText();
            if (headerContainer.equals("Please identify yourself"))
            {
                System.out.println("Successfully Logout");
            }
            else {
                throw new Exception("Unable to logout");
            }
        }
        else
        {
            throw new Exception("invalid Credentials");
        }*/


        if (status.equals("Valid")) {
            String timeTrack = driver.findElement(By.xpath("//div[@id='container_tt']/following-sibling::div[1]")).getText();
            Assert.assertEquals(timeTrack, "Time-Track", "Test Case Fail, Unable to login application");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@class='logoutContainer']/descendant::a[2]"))).click();

            String headerContainer = driver.findElement(By.id("headerContainer")).getText();
            Assert.assertEquals(headerContainer, "Please identify yourself", "Unable to logout");

            System.out.println("Successfully Logout");
        } else {
            throw new Exception("invalid Credentials");
        }

    }
}
