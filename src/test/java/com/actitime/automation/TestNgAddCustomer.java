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
