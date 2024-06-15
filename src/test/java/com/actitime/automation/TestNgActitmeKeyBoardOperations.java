package com.actitime.automation;

import com.actitime.automation.common.CommonFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNgActitmeKeyBoardOperations {
    WebDriver driver;
    @BeforeClass
    public void setup() throws InterruptedException {
        CommonFunction commonFunction = new CommonFunction();
        // Assign the WebDriver instance to the class-level 'driver' variable
        driver = commonFunction.launchBrowser("chrome");
        driver.get("https://online.actitime.com/sd1/tasks/tasklist.do");
        Thread.sleep(5000);
    }


    @Test
    public void KeyBoardOperations() throws InterruptedException {
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
