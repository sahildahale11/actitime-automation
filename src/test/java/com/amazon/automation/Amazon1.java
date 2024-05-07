package com.amazon.automation;

import com.commonfunction.automation.CommonFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;

public class Amazon1 {
    public static void main(String[] args) throws InterruptedException, AWTException {
        CommonFunction commonFunction = new CommonFunction();
        WebDriver driver = commonFunction.launchBrowser("chrome");
        driver.get("https://www.amazon.in/");
        Thread.sleep(5000);

        Robot robot = new Robot();
        WebElement miniTVLink = driver.findElement(By.partialLinkText("Amazon miniTV"));

        robot.mouseMove(300, 300); // Move the cursor to (0,0) coordinates to avoid interfering with the page
        Thread.sleep(1000); // Adding a small delay for demonstration

        // Simulate a right-click operation on the element
        robot.mouseMove(miniTVLink.getLocation().getX(), miniTVLink.getLocation().getY());
        robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);



    }
}
