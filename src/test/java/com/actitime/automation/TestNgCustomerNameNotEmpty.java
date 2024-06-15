package com.actitime.automation;

import com.actitime.automation.common.CommonFunction;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNgCustomerNameNotEmpty {
    WebDriver driver;
    @BeforeClass
    public void setup() throws InterruptedException {
        CommonFunction commonFunction = new CommonFunction();
        driver =commonFunction.launchBrowser("chrome");
        driver.get("https://online.actitime.com/sd1/tasks/tasklist.do");
        Thread.sleep(5000);
        commonFunction.loginForActitime();
        Thread.sleep(7000);

    }
    @Test
    public void CustomerNameIsNotEmpty() throws Exception {
        driver.findElement(By.xpath("//div[@id='container_tasks']/following::div[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[text()='Add New']")).click();
        driver.findElement(By.xpath("//div[text()='+ New Customer']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='customerNameDiv']/child::input"));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='inputContainer']/following::textarea[8]"));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='customerImportDiv']/descendant::div[6]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='itemRow cpItemRow ' and text()='Big Bang Company']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
        Thread.sleep(2000);
        String verifyBlankData = driver.findElement(By.xpath("//div[text()='Customer name cannot be empty']")).getText();
        if (verifyBlankData.equals("Customer name cannot be empty"))
        {
            System.out.println("Test Case pass,Customer name cannot be empty and Customer Can not be created");
        }
        else {
            throw new Exception("Customer Created Successfully");
        }
        // click on cancel button
        driver.findElement(By.xpath("//div[text()='Create Customer']/following::div[2]")).click();
// click on Alart box OK button
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }
}
