package com.actitime.automation;

import com.commonfunction.automation.CommonFunction;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestngAddNewProject {
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
    public void AddNewProject() throws Exception {
        //Click on Task
        driver.findElement(By.xpath("//div[@id='container_tasks']/following::div[1]")).click();
        Thread.sleep(5000);
        // Click on Add new Button
        driver.findElement(By.xpath("//div[text()='Add New']")).click();
        String addCustumertext = driver.findElement(By.xpath("//div[text()='+ New Customer' or text()='+ New Project' or text()='+ New Tasks'or text()='Import Tasks from CSV']")).getText();
        if (addCustumertext.equals("+ New Customer") || addCustumertext.equals("+ New Project") || addCustumertext.equals("+ New Tasks") || addCustumertext.equals("Import Tasks from CSV")) {
            System.out.println("Test Case pass : Add New Button Clickable");
        } else {
            throw new Exception("unable to search");
        }
        // Click on New Project
        driver.findElement(By.xpath("//div[text()='+ New Project']")).click();
        Thread.sleep(5000);
        String projectName = "Maruti suzuki eartiga";
        driver.findElement(By.xpath("//div[@class='sectionDetails']/child::input")).sendKeys(projectName);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='comboboxButton']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id='createProjectPopup_content']//div[@class='searchItemList']/div[4]")).click();
        driver.findElement(By.xpath("//div[@class='sectionDetails']/descendant::textarea")).sendKeys("Blah blah blah");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[text()='Add tasks']/following::input[2]")).sendKeys("Task1");
        driver.findElement(By.xpath("//div[text()='Add tasks']/following::input[5]")).sendKeys("Task2");
        driver.findElement(By.xpath("//div[text()='Add tasks']/following::input[8]")).sendKeys("Task3");
        driver.findElement(By.xpath("//div[text()='Create Project']")).click();
        Thread.sleep(3000);
        // verify project is created or not
        String customerexist = driver.findElement(By.xpath("//div[text()='Customer already contains a project with the specified name']")).getText();
        System.out.println(customerexist);
        if (customerexist.equals("Customer already contains a project with the specified name")) {
            System.out.println("test case passed, you cannot create a duplicate project as the project already exists");
            Thread.sleep(3000);
            driver.navigate().refresh();
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } else {
            // Wait for the input field to be visible and then enter the project name
            WebElement inputField = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Add New']/following::input[1]")));
            inputField.sendKeys(projectName);
            // Wait for the project title to be visible
            WebElement projectTitle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//DIV[@class='title'])[28]")));
            String verifyProject = projectTitle.getText();
            System.out.println(verifyProject);
            // Verify if the project title matches the expected project name
            if (verifyProject.equals(projectName)) {
                System.out.println("Test case passed: Project created successfully");
            } else {
                throw new Exception("Unable to create project. Project title does not match the expected name.");
            }
        }
    }
}
