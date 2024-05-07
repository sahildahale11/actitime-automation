package com.actitime.automation;

import com.commonfunction.automation.CommonFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TestNgAddFilter {
    WebDriver driver;

    @BeforeClass
    public void setup() throws InterruptedException {
        CommonFunction commonFunction = new CommonFunction();
        driver = commonFunction.launchBrowser("chrome");
        driver.get("https://online.actitime.com/sd1/tasks/tasklist.do");
        Thread.sleep(5000);
        commonFunction.loginForActitime();
        Thread.sleep(10000);

    }

    @Test
    public void addFilter() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='container_tasks']/following::div[1]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Add filters']"))).click();
        List<WebElement> checkboxes = driver.findElements(By.xpath("//div[@class='components-FieldsSelector-fieldList--CFSNG6qi']//label"));
        int selectedCount = 0;
        for (int i = 0; i < checkboxes.size(); i++) {
            if (selectedCount >= 2) {
                break; // If two checkboxes are already selected, exit the loop
            }
            WebElement checkBox = checkboxes.get(i);
            try {
                wait.until(ExpectedConditions.elementToBeClickable(checkBox)).click(); // Wait until checkbox is clickable, then click
                if (checkBox.isSelected()) {
                    String cbText = checkBox.getText();
                    System.out.println(cbText);
                    selectedCount++; // Increment the count of selected checkboxes
                }
            } catch (org.openqa.selenium.StaleElementReferenceException ex) {
                // Re-locate the element if it becomes stale
                checkboxes = driver.findElements(By.xpath("//div[@class='components-FieldsSelector-fieldList--CFSNG6qi']//label"));
                checkBox = checkboxes.get(i);
                wait.until(ExpectedConditions.elementToBeClickable(checkBox)).click(); // Wait until checkbox is clickable, then click
                if (checkBox.isSelected()) {
                    String cbText = checkBox.getText();
                    System.out.println(cbText);
                    selectedCount++; // Increment the count of selected checkboxes
                }
            }
        }

//            if (checkBox.isSelected()) {
//                String cbText = checkBox.getText();
//                System.out.println(cbText);
//                selectedCount++; // Increment the count of selected checkboxes
//            }
            //Click On apply Button
            Thread.sleep(10000);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Apply']"))).click();
        }

    }


