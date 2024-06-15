package com.actitime.automation;

import com.actitime.automation.common.CommonFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestNgPrintAllTaskTest2 {
     WebDriver driver;
     CommonFunction commonFunction;
     WebDriverWait wait;

    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        commonFunction = new CommonFunction();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void printAllTasks() throws Exception {
        driver.get("https://online.actitime.com/sd1/tasks/tasklist.do");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        commonFunction.loginForActitime();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='container_tasks']/following::div[1]")));
        WebElement taskElement = driver.findElement(By.xpath("//div[@id='container_tasks']/following::div[1]"));
        taskElement.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='All Customers']/following::div[11]")));
        WebElement allCustomersElement = driver.findElement(By.xpath("//div[text()='All Customers']/following::div[11]"));
        allCustomersElement.click();

        Thread.sleep(2000); // Wait for the tasks to load (not recommended, but used here for simplicity)

        List<WebElement> taskRows = driver.findElements(By.xpath("//tr[contains(@class,'taskRow')]/td[2]//div[@class='title']"));
        for (WebElement we : taskRows) {
            if (we.isDisplayed()) {
                String weText = we.getText();
                System.out.println(weText);
            } else {
                Actions actions1 = new Actions(driver);
                actions1.moveToElement(we).perform();
                String weText = we.getText();
                System.out.println(weText);
            }
        }
    }
}
