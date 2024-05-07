package com.actitime.automation;

import com.commonfunction.automation.CommonFunction;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActitmeKeyBoardOperations {
    public static void main(String[] args) throws InterruptedException {
        CommonFunction commonFunction = new CommonFunction();
        WebDriver driver=commonFunction.launchBrowser("chrome");
        driver.get("https://online.actitime.com/sd1/tasks/tasklist.do");
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        // Code For New  Tab
        WebElement actiTimeLink = driver.findElement(By.partialLinkText("actiTIME Inc."));
        actions.contextClick(actiTimeLink).build().perform();
        actions.keyDown(Keys.ARROW_DOWN).build().perform();
        actions.keyUp(Keys.ARROW_DOWN).build().perform();
        actions.keyDown(Keys.ARROW_DOWN).build().perform();
        actions.keyUp(Keys.ARROW_DOWN).build().perform();
        Thread.sleep(2000);
        actions.keyDown(Keys.ENTER).build().perform();
        actions.keyUp(Keys.ENTER).build().perform();

    }
}
