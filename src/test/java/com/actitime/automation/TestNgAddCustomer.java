/*
package com.actitime.automation;

import com.commonfunction.automation.CommonFunction;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNgAddCustomer {
    WebDriver driver;

    @BeforeClass(groups = "regression")
    public void setup() throws InterruptedException {
        CommonFunction commonFunction = new CommonFunction();
        driver = commonFunction.launchBrowser("chrome");
        driver.get("https://online.actitime.com/sd1/tasks/tasklist.do");
        Thread.sleep(5000);
        commonFunction.loginForActitime();
        Thread.sleep(10000);

    }

    @Test(groups = "regression")
    public void addTask() throws Exception {
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
        Thread.sleep(2000);
        // Click on New Customer

        driver.findElement(By.xpath("//div[text()='+ New Customer']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='customerNameDiv']/child::input")).sendKeys("Mr.john Palekar");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='inputContainer']/following::textarea[8]")).sendKeys("Blah Blah Balh");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='customerImportDiv']/descendant::div[6]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='itemRow cpItemRow ' and text()='Big Bang Company']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
        Thread.sleep(3000);
        String alreadyExist = driver.findElement(By.xpath("//div[text()='Customer with the specified name already exists']")).getText();
        if (alreadyExist.equals("Customer with the specified name already exists")) {
            System.out.println("The test case passed; you cannot create a duplicate customer as the customer already exists");
            Thread.sleep(3000);
            driver.navigate().refresh();
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } else {
            String verifyCustumer = driver.findElement(By.xpath("//div[@id='taskListBlock']/descendant::div[6]")).getText();
            if (verifyCustumer.equals("Mr.john Palekar")) {
                System.out.println("Test Case Passes,Customer Created Successfully");
            } else {
                throw new Exception("Unable to Create Customer customer");
            }

        }
    }
}
*/

package com.actitime.automation;

import com.actitime.automation.common.CommonFunction;
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

public class TestNgAddCustomer {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass(groups = "regression")
    public void setup() {
        CommonFunction commonFunction = new CommonFunction();
        driver = commonFunction.launchBrowser("chrome");
        driver.get("https://online.actitime.com/sd1/tasks/tasklist.do");
        wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Initialize WebDriverWait
        commonFunction.loginForActitime();
    }

    @Test(groups = "regression")
    public void addTask() throws InterruptedException {
        //Click on Task
        WebElement taskButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='container_tasks']/following::div[1]")));
        taskButton.click();

        // Click on Add new Button
        WebElement addNewButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Add New']")));
        addNewButton.click();

        // Verify Add New Button
        WebElement addCustomerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='+ New Customer' or text()='+ New Project' or text()='+ New Tasks' or text()='Import Tasks from CSV']")));
        String addCustomerText = addCustomerElement.getText();
        Assert.assertTrue(addCustomerText.equals("+ New Customer") || addCustomerText.equals("+ New Project") || addCustomerText.equals("+ New Tasks") || addCustomerText.equals("Import Tasks from CSV"), "Add New Button is not clickable");

        // Click on New Customer
        WebElement newCustomerButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='+ New Customer']")));
        newCustomerButton.click();

        // Fill in Customer details
        WebElement customerNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='customerNameDiv']/child::input")));
        customerNameInput.sendKeys("Mr.john Palekar");

        WebElement customerDescriptionTextarea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='inputContainer']/following::textarea[8]")));
        customerDescriptionTextarea.sendKeys("Blah Blah Blah");

        // Select Customer
        WebElement customerSelectButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='customerImportDiv']/descendant::div[6]")));
        customerSelectButton.click();

        WebElement bigBangCompanyOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='itemRow cpItemRow ' and text()='Big Bang Company']")));
        bigBangCompanyOption.click();

        // Click Create Customer
        WebElement createCustomerButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Create Customer']")));
        createCustomerButton.click();

        // Check if Customer already exists
        // Check if Customer already exists
        WebElement errorMessageElement = driver.findElement(By.xpath("//div[text()='Customer with the specified name already exists']"));
        if (errorMessageElement.isDisplayed()) {
            System.out.println("The test case passed; you cannot create a duplicate customer as the customer already exists");
            driver.navigate().refresh();
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } else {
            WebElement verifyCustomerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='taskListBlock']/descendant::div[contains(text(), 'Mr.john Palekar')]")));
            Thread.sleep(10000);
            String verifyCustomerText = verifyCustomerElement.getText();
            System.out.println("Verify Customer Text: " + verifyCustomerText); // Debug statement
            Assert.assertEquals(verifyCustomerText, "Mr.john Palekar", "Expected customer name does not match the actual name");
            System.out.println("Test Case Passes, Customer Created Successfully");
        }

    }
}
