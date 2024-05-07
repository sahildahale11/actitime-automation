package com.actitime.automation;

import com.commonfunction.automation.CommonFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class ChangeStatusAndVerify {
    public static void main(String[] args) throws InterruptedException {
        CommonFunction commonFunction = new CommonFunction();
        WebDriver driver = commonFunction.launchBrowser("chrome");
        driver.get("https://online.actitime.com/sd1/tasks/tasklist.do");
        Thread.sleep(5000);


        commonFunction.loginForActitime();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//div[@id='container_tasks']/following::div[1]")).click();
        driver.findElement(By.xpath("//div[text()='All Customers']/following::div[11]")).click();
        driver.findElement(By.xpath("//tr[@class='headers']/descendant::div[2]")).click();
        driver.findElement(By.xpath("//div[@class='components-SearchInput-icon--mqgNLbmO']/following::div[3]")).click();
        driver.findElement(By.xpath("//label[text()='All']/following::input[1]")).click();
        driver.findElement(By.xpath("//span[text()='Open tasks']/following::span[2]")).click();
        //((JavascriptExecutor) driver).executeScript("document.body.style.zoom='75%'");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[text()='Apply']")).click();
    }
}
