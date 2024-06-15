package com.actitime.automation;


import com.actitime.automation.common.CommonFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ActiKeyboardOperationRobotClass {
    public static void main(String[] args) throws InterruptedException, AWTException {
        CommonFunction commonFunction = new CommonFunction();
        WebDriver driver =commonFunction.launchBrowser("chrome");
        driver.get("https://online.actitime.com/sd1/tasks/tasklist.do");
        Thread.sleep(5000);
        Robot robot = new Robot();
        WebElement link =driver.findElement(By.partialLinkText("actiTIME Inc."));

        Thread.sleep(1000); // Adding a small delay for demonstration

        // Simulate a right-click operation on the element
        robot.mouseMove(link.getLocation().getX(), link.getLocation().getY());
        robot.mousePress(KeyEvent.BUTTON3_DOWN_MASK);
        robot.mouseRelease(KeyEvent.BUTTON3_DOWN_MASK);



    }
}
