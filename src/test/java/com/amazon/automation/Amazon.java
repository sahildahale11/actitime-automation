package com.amazon.automation;

import com.commonfunction.automation.CommonFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

public class Amazon {
    public static void main(String[] args) throws InterruptedException {
        CommonFunction commonFunction = new CommonFunction();
        WebDriver driver = commonFunction.launchBrowser("chrome");
        driver.get("https://www.amazon.in/");
        Thread.sleep(5000);
        // Logic to Click on new Tab
        Actions actions = new Actions(driver);
        WebElement miniTVLink = driver.findElement(By.partialLinkText("Amazon miniTV"));
        actions.keyDown(Keys.CONTROL).click(miniTVLink).keyUp(Keys.CONTROL).build().perform();

        String currentWindowHandle = driver.getWindowHandle();
        Thread.sleep(2000);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(currentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                String title =driver.getTitle();
                System.out.println(title);
                if (title.equals("Amazon miniTV - Watch Free Web Series, Movies, Short Films & K-Dramas Online"))
                {
                    System.out.println("Successfully Switch to New Tab");
                }
                else {
                    System.out.println("unable to switch to new tab");
                }
                break;

            }
        }











        // another logic for new tab
        /*WebElement miniTVLink = driver.findElement(By.partialLinkText("Amazon miniTV"));

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).click(miniTVLink).keyUp(Keys.CONTROL).build().perform();
        // Switch to the new tab
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)); // Assuming the new tab is at index 1*/


    }
}
