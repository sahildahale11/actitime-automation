/*
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
*/

package com.actitime.automation;

import com.commonfunction.automation.CommonFunction;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
        WebElement taskButton = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='container_tasks']/following::div[1]")));
        taskButton.click();
        // Click on Add new Button
        WebElement addNewButton = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Add New']")));
        addNewButton.click();
        String addCustomText = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='+ New Customer' or text()='+ New Project' or text()='+ New Tasks'or text()='Import Tasks from CSV']"))).getText();
        Assert.assertTrue(addCustomText.equals("+ New Customer") || addCustomText.equals("+ New Project") || addCustomText.equals("+ New Tasks") || addCustomText.equals("Import Tasks from CSV"), "Add New Button not Clickable");

        // Click on New Project
        WebElement newProjectButton = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='+ New Project']")));
        newProjectButton.click();
        String projectName = "Jain Pipes";
        WebElement projectNameInput = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sectionDetails']/child::input")));
        projectNameInput.sendKeys(projectName);
        WebElement comboBoxButton = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='comboboxButton']")));
        comboBoxButton.click();
        WebElement projectOption = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='createProjectPopup_content']//div[@class='searchItemList']/div[4]")));
        projectOption.click();
        WebElement projectDescription = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sectionDetails']/descendant::textarea")));
        projectDescription.sendKeys("Blah blah blah");
        WebElement task1Input = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Add tasks']/following::input[2]")));
        task1Input.sendKeys("Task1");
        WebElement task2Input = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Add tasks']/following::input[5]")));
        task2Input.sendKeys("Task2");
        WebElement task3Input = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Add tasks']/following::input[8]")));
        task3Input.sendKeys("Task3");
        WebElement createProjectButton = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Create Project']")));
        createProjectButton.click();

        // verify project is created or not
        try {
            WebElement customerExistMessage = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Customer already contains a project with the specified name']")));
            System.out.println(customerExistMessage.getText());
            Assert.fail("You cannot create a duplicate project as the project already exists");
        } catch (Exception e) {
            // Wait for the input field to be visible and then enter the project name
            WebElement inputField = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Add New']/following::input[1]")));
            inputField.sendKeys(projectName);
            // Wait for the project title to be visible
            WebElement projectTitle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='title' and text()='" + projectName + "']")));
            String verifyProject = projectTitle.getText();
            // Verify if the project title matches the expected project name
            Assert.assertEquals(verifyProject, projectName, "Project title does not match the expected name.");
            System.out.println("Project Name : "+projectName);
        }
    }
}
