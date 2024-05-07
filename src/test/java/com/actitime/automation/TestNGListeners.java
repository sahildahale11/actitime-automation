package com.actitime.automation;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestNGListeners implements ISuiteListener {
    String ScreenShotFloderPath;

    //ISuite Listeners
    @Override
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
    @Override
    public void onFinish(ISuite suite)
    {
        System.out.println("This is onFinish method of ISuiteListener");
    }
    ////ITest Listeners

    public void onStart(ITestContext context)
    {
        System.out.println("This is onStart Method of ITest Listners");
    }
    public void onFinish(ITestContext context)
    {
        System.out.println("This is onFinish Method of ITest Listners");
    }
    public void onTestStart(ITestResult result)
    {
        System.out.println("This is onStart Method of ITest Listners");
    }
    public void onTestSuccess(ITestResult result)
    {
        System.out.println("This is onStart Method of ITest Listners");
    }

    public void onTestFailure(ITestResult result) {
        // getTestContext return context (variables, method name, exceptions, results) of the @Test method
        try {
            WebDriver driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

            //get the method name from context

            String methodName = result.getMethod().getMethodName();

            String fileName = ScreenShotFloderPath+"/"+methodName+".png";
            File dstFile = new File(fileName);
            FileUtils.copyFile(srcFile, dstFile);
        } catch (Exception e) {
        }
    }


    public void onTestSkipped(ITestResult result) {
        System.out.println("This is onTestSkipped method of ITestListener");
    }



}
