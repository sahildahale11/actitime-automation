package com.actitime.automation;
// add task using Actions Class
import com.actitime.automation.common.CommonFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.LocalDateTime;
import java.util.List;

public class AddTaskUsingActionsClass {
    WebDriver driver;

    public static void main(String[] args) throws Exception {
        // get the current day of month
        int dayOfMonth = LocalDateTime.now().getDayOfMonth();
        System.out.println(dayOfMonth);

        // 'MARCH' Convert into 'March'
        String currentMonth = LocalDateTime.now().getMonth().name(); // first get current month name
        String actualCurrentMonth = currentMonth.charAt(0) + currentMonth.substring(1, currentMonth.length()).toLowerCase();
      CommonFunction commonFunction = new CommonFunction();
      WebDriver driver =commonFunction.launchBrowser("chrome");


    System.out.println("get driver"+driver);
        // navigate to URl
        driver.get("https://online.actitime.com/sd1/tasks/tasklist.do");
        Thread.sleep(5000);

        //object for Actions Class
        Actions actions = new Actions(driver);
        actions.sendKeys(driver.findElement(By.id("username")), "sahil.dahale98@gmail.com").build().perform();
        actions.sendKeys(driver.findElement(By.name("pwd")), "Pass@123").build().perform();
        actions.moveToElement(driver.findElement(By.id("loginButton"))).click().build().perform();
        Thread.sleep(5000);
// Verify Time-Track Dashboard
        String timeTrack = driver.findElement(By.xpath("//div[@id='container_tt']/following-sibling::div[1]")).getText();
        System.out.println(timeTrack);

        if (timeTrack.equals("Time-Track")) {
            System.out.println("Successfully landed on Time-Track module");
        } else {
            throw new Exception("Unable to login application");
        }
        Thread.sleep(2000);
        //Click on Tasks
        actions.moveToElement(driver.findElement(By.xpath("//div[text()='Tasks']"))).click().build().perform();
        //click on Company Name
        actions.moveToElement(driver.findElement(By.xpath("//div[text()='All Customers']/following::div[11]"))).click().build().perform(); Thread.sleep(3000);
        //Click on Add Task
        actions.moveToElement(driver.findElement(By.xpath("(//div[text()='Add Task'])[1]"))).click().build().perform();
        Thread.sleep(3000);
        // Enter Task Name
        actions.sendKeys(driver.findElement(By.xpath("//span[text()='Flight operations']/following::input[1]")), "Lenskart").build().perform();
        // Deadline
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='detailsRow']//div[text()='Set up deadline']"))).click().build().perform();
        String monthXpath = "//td[starts-with(@title,'" + actualCurrentMonth + "')]/div";
        //System.out.println(monthXpath);
        List<WebElement> days = driver.findElements(By.xpath(monthXpath));
        for (WebElement daysElement : days) {
            String day = daysElement.getText();
            System.out.println(day);
            // check if the day value is equals with day of month then select that day
            //also convert dayOfMonth into String for comparison
            if (day.equals(String.valueOf(dayOfMonth))) {
                daysElement.click();
            }
        }
        Thread.sleep(2000);
        //Type of Work
        actions.moveToElement(driver.findElement(By.xpath("//div[text()='Type of Work']/following::div[2]"))).click().build().perform();
        actions.moveToElement(driver.findElement(By.xpath("//span[text()='engineering (default)']/following::span[4]"))).click().build().perform();
        // Priority
        actions.moveToElement(driver.findElement(By.xpath("//div[text()='Priority']/following::button[1]"))).click().build().perform();Thread.sleep(2000);
        actions.moveToElement(driver.findElement(By.xpath("//div[text()='Priority']/following::span[6]"))).click().build().perform();
        // value custom field
        actions.moveToElement(driver.findElement(By.xpath("//div[text()='Value (custom field)']/following::button[1]"))).click().build().perform();
        Thread.sleep(2000);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='ScrollbarsCustom']//span[text()='Useful']"))).click().build().perform();
        Thread.sleep(2000);
        //Budget
        actions.sendKeys(driver.findElement(By.xpath("//div[text()='Budget, $ (custom field)']/following::input[1]")), "50000").build().perform();
        Thread.sleep(2000);
        //code
        actions.sendKeys(driver.findElement(By.xpath("//div[text()='Code (custom field)']/following::input[1]")), "48498465").build().perform();
        Thread.sleep(2000);
        //Estimate
//        actions.moveToElement(driver.findElement(By.xpath("//div[@class='timeEditor editable empty']/child::div[1]"))).click().build().perform();
//        Thread.sleep(2000);
//        actions.sendKeys(driver.findElement(By.xpath("//div[@class='timeEditor editable empty']/child::div[1]")), "50:00").build().perform();
//        Thread.sleep(3000);
        driver.findElement(By.xpath("(//DIV[@class='components_button_label'][text()='Add Task'])[3]")).click();
        Thread.sleep(3000);
        String verifyTAsk = driver.findElement(By.xpath("//div[@title='Lenskart']")).getText();
        if (verifyTAsk.equals("Lenskart")) {
            System.out.println("Successfully created Task");
        } else {
            throw new Exception("Unable to create Task");
        }
        Thread.sleep(3000);
        actions.sendKeys(driver.findElement(By.xpath("//div[@id='taskListBlock']/descendant::input[1]")),"Lenskart").build().perform();
        Thread.sleep(3000);
       String verifySearch= driver.findElement(By.xpath("//span[text()='Lenskart']")).getText();
       if (verifySearch.equals("Lenskart"))
       {
           System.out.println("Search successful");
       }
       else
       {
        throw new Exception("unable to search Correct Task");
       }
    }
    }

