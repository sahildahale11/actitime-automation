package com.actitime.automation;

import com.commonfunction.automation.CommonFunction;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TaskModule {

    public static void main(String[] args) throws Exception {
        CommonFunction commonFunction = new CommonFunction();
        WebDriver driver =commonFunction.launchBrowser("chrome");
        driver.get("https://online.actitime.com/sd/timetrack/enter.do");
        Thread.sleep(6000);
        // Login
        commonFunction.loginUserforactiTime("Sahil.dahale98@gmail.com","Pass@123");
        Thread.sleep(3000);
        //Verify Successfully landed on time-track
        String timeTrack = driver.findElement(By.xpath("//div[@id='container_tt']/following-sibling::div[1]")).getText();
        commonFunction.verifyMassage(timeTrack);
        Thread.sleep(3000);
        //Click on Task Module
        driver.findElement(By.xpath("//div[@id='container_tasks']/following::div[1]")).click();
        Thread.sleep(5000);
        // Task -Search Bar
        driver.findElement(By.xpath("//div[@id='taskManagementPage']/descendant::input[1]")).sendKeys("Big Bang Company");
        // Verify search
//        String searchText = driver.findElement(By.xpath("//span[text()='Big' or text()='Bang' or text()='Company']")).getText();
//        if (searchText.equals("Big Bang Company"))
//        {
//            System.out.println("Search successfully");
//        }
//        else {
//            throw new Exception("unable  to search ");
//        }
        Thread.sleep(3000);
        // Scnerio for Addnew Button
        // click on Add New Button and verify button is clickable or not
//        driver.findElement(By.xpath("//div[text()='Add New']")).click();
//        String addCustumertext = driver.findElement(By.xpath("//div[text()='+ New Customer' or text()='+ New Project' or text()='+ New Tasks']")).getText();
//        if (addCustumertext.equals("+ New Customer") || addCustumertext.equals("+ New Project") || addCustumertext.equals("+ New Tasks")) {
//            System.out.println("Test Case pass : Add New Button Clickable");
//        } else {
//            throw new Exception("unable to search");
//        }
//        Thread.sleep(2000);
//
        // Add Customer
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
        String verifyCustumer = driver.findElement(By.xpath("//div[@id='taskListBlock']/descendant::div[6]")).getText();
        if (verifyCustumer.equals("Mr.john Palekar"))
        {
            System.out.println("Customer Created");
        }
        else {
            throw new Exception("Unable to add customer");
        }
        Thread.sleep(2000);
        //Verify a feature for Add New Customer can not be empty
        driver.findElement(By.xpath("//div[text()='Add New']")).click();
        driver.findElement(By.xpath("//div[text()='+ New Customer']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='customerNameDiv']/child::input"));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='inputContainer']/following::textarea[8]"));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='customerImportDiv']/descendant::div[6]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='itemRow cpItemRow ' and text()='Big Bang Company']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
        Thread.sleep(2000);
        String verifyBlankData = driver.findElement(By.xpath("//div[text()='Customer name cannot be empty']")).getText();
        if (verifyBlankData.equals("Customer name cannot be empty"))
        {
            System.out.println("Test Case pass,Customer name cannot be empty and Customer Can not be created");
        }
        else {
            throw new Exception("Customer Created Successfully");
        }
        driver.findElement(By.xpath("//div[text()='Create Customer']/following::div[2]")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();


//        // Add Project
//        driver.findElement(By.xpath("//div[text()='Add New']")).click();
//        Thread.sleep(1500);
//        driver.findElement(By.xpath("//div[text()='+ New Project']")).click();
//        Thread.sleep(1500);
//        driver.findElement(By.xpath("//div[@id='createProjectPopup']/descendant::input[1]")).sendKeys("AquaBlueLens");
//        driver.findElement(By.xpath("//div[@id='createProjectPopup_content']/descendant::div[23]")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//div[text()='Mr.john Palekar' and @class='itemRow cpItemRow ']")).click();
//        driver.findElement(By.xpath("//textarea[@Placeholder='Add Project Description']")).sendKeys("AquaBlueLens New Model Launch");
//        driver.findElement(By.xpath("//div[text()='Create Project']")).click();
//        String verifyAddTask = driver.findElement(By.xpath("//div[@class='titleEditButtonContainer']/child::div[1]")).getText();
//        if (verifyAddTask.equals("AquaBlueLens"))
//        {
//            System.out.println("Test Case Passed,Add Task Successfully");
//        }
//        else{
//            throw new Exception("Unable to create a New Task");
//        }


    }
}
