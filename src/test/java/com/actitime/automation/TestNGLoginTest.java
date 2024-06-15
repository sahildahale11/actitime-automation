package com.actitime.automation;

import com.actitime.automation.common.CommonFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ISuite;
import org.testng.TestListenerAdapter;
import org.testng.annotations.*;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestNGLoginTest extends TestListenerAdapter {
    WebDriver driver;
    String ScreenShotFloderPath;

    public void onStart(ISuite suite)
    {
        System.out.println("This is onStart method of ISuiteListener");
        String currentDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd_MM_yy"));
        System.out.println(currentDate);
        ScreenShotFloderPath=System.getProperty("user.dir")+"/reports"+currentDate;
        File file = new File(ScreenShotFloderPath);
        if (!file.exists())
        {
            //Check if the floder is not present
            file.mkdir(); // Create a folder
        }
    }


    @BeforeClass(groups = "regression")
    public void launchBrowser() throws InterruptedException {
        CommonFunction commonFunction = new CommonFunction();
        driver = commonFunction.launchBrowser("chrome");
        driver.get("https://online.actitime.com/sd1/tasks/tasklist.do");
        Thread.sleep(5000);
    }


    @DataProvider
    public Object[][] getTestData() {
        return new Object[][]{{"sahil.dahale98@gmail.com", "Pass@123", "Valid"},
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

    @Test(dataProvider = "getTestData", groups = "regression")
    public void Login(String username, String password, String status) throws Exception {
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("pwd")).sendKeys(password);
        driver.findElement(By.xpath("//a[@id='loginButton']/child::div")).click();
        Thread.sleep(10000);
        // - Normal code without using Assertion
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

        // -- replace code with Hard Assertion
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
    // Take Screenshots
//    public void onTestFailure(ITestResult result) {
//        // getTestContext return context (variables, method name, exceptions, results) of the @Test method
//        try {
//            WebDriver driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
//            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
//            File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
//
//            //get the method name from context
//
//            String methodName = result.getMethod().getMethodName();
//
//            String fileName = ScreenShotFloderPath+"/"+methodName+".png";
//            File dstFile = new File(fileName);
//            FileUtils.copyFile(srcFile, dstFile);
//        } catch (Exception e) {
//        }
//    }

    }






