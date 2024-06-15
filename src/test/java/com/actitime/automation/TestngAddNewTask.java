package com.actitime.automation;

import com.actitime.automation.common.CommonFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TestngAddNewTask {
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
    public void addNewTask() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Click on Task
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='container_tasks']/following::div[1]")));
        el.click();
        // Click on Add new Button
        driver.findElement(By.xpath("//div[text()='Add New']")).click();
        String addCustumertext = driver.findElement(By.xpath("//div[text()='+ New Customer' or text()='+ New Project' or text()='+ New Tasks'or text()='Import Tasks from CSV']")).getText();
        if (addCustumertext.equals("+ New Customer") || addCustumertext.equals("+ New Project") || addCustumertext.equals("+ New Tasks") || addCustumertext.equals("Import Tasks from CSV")) {
            System.out.println("Test Case pass : Add New Button Clickable");
        } else {
            throw new Exception("unable to search");
        }
        // click on add task button
        driver.findElement(By.xpath("//div[text()='+ New Tasks']")).click();
        Thread.sleep(5000);
        // click on select customer dropdown
        String customerName = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/div[1]/div[1]/div[3]")).getText();
        System.out.println("name : " + customerName);
        if (customerName.isEmpty() || "null".equalsIgnoreCase(customerName) || customerName == null) {
            WebElement customerOption = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[5]")));
            customerOption.click();
        } else {
            System.out.println(" Customer value Already Set");
        }
        // Click on  Project Name
        String projectName = driver.findElement(By.xpath("//DIV[@class='selectedItem'][text()='The Frame']/self::DIV")).getText();
        System.out.println("name : " + projectName);
        if (projectName.isEmpty() || "null".equalsIgnoreCase(projectName) || projectName == null) {
            WebElement customerOption = driver.findElement(By.xpath("//DIV[@class='itemRow cpItemRow selected'][text()='The Frame']/self::DIV"));
            customerOption.click();
        } else {
            System.out.println("Project Name by Default set");
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='importTasksHeader']/following::input[2]")).sendKeys("Meeting Hashmap");
        driver.findElement(By.xpath("//div[@class='importTasksHeader']/following::input[6]")).sendKeys("Automation meeting");
        driver.findElement(By.xpath("//div[@class='importTasksHeader']/following::input[10]")).sendKeys(" market target");
        driver.findElement(By.xpath("//div[@class='importTasksHeader']/following::input[14]")).sendKeys("Amazon Web  Services");
        driver.findElement(By.xpath("//div[@class='importTasksHeader']/following::input[18]")).sendKeys(" Econ Task ");
        driver.findElement(By.xpath("//div[text()='Create Tasks']")).click();
        Thread.sleep(3000);
        List<WebElement> taskRows = driver.findElements(By.xpath("//tr[contains(@class,'taskRow')]/td[2]//div[@class='title']"));
        for (WebElement we : taskRows) {
            if (we.isDisplayed()) {
                String weText = we.getText();
                System.out.println("New Added Task : " + weText);
            } else {
                Actions actions1 = new Actions(driver);
                actions1.scrollToElement(we).build().perform();
                String weText = we.getText();
                System.out.println("New Added Task: " + weText);
            }
        }
    }
}
