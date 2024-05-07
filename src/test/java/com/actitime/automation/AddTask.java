package com.actitime.automation;

// Script for add Task

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.LocalDateTime;
import java.util.List;

public class AddTask {
    public static void main(String[] args) throws Exception {
        // get the current day of month
        int dayOfMonth = LocalDateTime.now().getDayOfMonth();
        System.out.println(dayOfMonth);

        // 'MARCH' Convert into 'March'
        String currentMonth = LocalDateTime.now().getMonth().name(); // first get current month name
        String actualCurrentMonth = currentMonth.charAt(0) + currentMonth.substring(1, currentMonth.length()).toLowerCase();


        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("121");
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);

        // maximize the window
        driver.manage().window().maximize();

        // navigate to URl
        driver.get("https://online.actitime.com/sd1/tasks/tasklist.do");
        Thread.sleep(10000);
        //Login To username And password
        driver.findElement(By.name("username")).sendKeys("sahil.dahale98@gmail.com");
        driver.findElement(By.name("pwd")).sendKeys("Pass@123");
        driver.findElement(By.xpath("//a[@id='loginButton']/child::div")).click();

        Thread.sleep(10000);

        String timeTrack = driver.findElement(By.xpath("//div[@id='container_tt']/following-sibling::div[1]")).getText();
        System.out.println(timeTrack);

        if (timeTrack.equals("Time-Track")) {
            System.out.println("Successfully landed on Time-Track module");
        } else {
            throw new Exception("Unable to login application");
        }
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@id='container_tasks']/following::div[1]")).click();
        Thread.sleep(5000);
        // Click on company name and then click on project
        //driver.findElement(By.xpath("//div[text()='All Customers']/following::div[2]")).click();
        driver.findElement(By.xpath("//div[text()='All Customers']/following::div[11]")).click();

        // Add Task
        driver.findElement(By.xpath("//div[@id='taskListBlock']/descendant::div[10]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='Flight operations']/following::input[1]")).sendKeys("Aqualens");
        Thread.sleep(2000);
        // Types of Work
        driver.findElement(By.xpath("//div[@class='classicBridge-taskPanel-TypesOfWorkSelector-trigger--U96GRjul']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='manufacturing ']")).click();
        Thread.sleep(1000);
        //Priority
        driver.findElement(By.xpath("//div[@class='classicBridge-taskPanel-CFDropdownSelector-dot--GgwhXVg0']")).click();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("(//span[@class='components-TruncatedText-oneLine--k4DPsC7f'][text()='High'])[3]")).click();
        Thread.sleep(2000);
        // value custom field
        driver.findElement(By.xpath("//div[text()='Value (custom field)']/following::button[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='ScrollbarsCustom']//span[text()='Useful']")).click();
        Thread.sleep(2000);
        //Budget
        driver.findElement(By.xpath("//div[text()='Budget, $ (custom field)']/following::input[1]")).sendKeys("50000");
        Thread.sleep(2000);
        //code
        driver.findElement(By.xpath("//div[text()='Code (custom field)']/following::input[1]")).sendKeys("415128");
        Thread.sleep(2000);
        //Deadline
        driver.findElement(By.xpath("//div[@class='detailsRow']//div[text()='Set up deadline']")).click();
        String monthXpath = "//td[starts-with(@title,'" + actualCurrentMonth + "')]/div";
        System.out.println(monthXpath);
      List<WebElement>  days = driver.findElements(By.xpath(monthXpath));
      for ( WebElement daysElement:days )
      {
          String day = daysElement.getText();
          System.out.println(day);
          // check if the day value is equals with day of month then select that day
          //also convert dayOfMonth into String for comparison
          if (day.equals(String.valueOf(dayOfMonth)))
          {
              daysElement.click();
          }
      }
      Thread.sleep(2000);
//      //Estimate
//        driver.findElement(By.xpath("//div[@class='timeEditor editable empty']/child::div[1]")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//div[@class='timeEditor editable empty']/child::div[1]")).sendKeys("50:00");
//        Thread.sleep(3000);
//     // Description
//        driver.findElement(By.xpath("(//textarea[@class='textarea'])[8]")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("(//textarea[@class='textarea'])[8]")).sendKeys("A fictional account of a misfit navigating life's challenges with humor, resilience, and unexpected insights, spanning various adventures");
//Thread.sleep(3000);
        //Click on Add Task Button
        driver.findElement(By.xpath("(//DIV[@class='components_button_label'][text()='Add Task'])[3]")).click();
        Thread.sleep(2000);
        String verifyTAsk = driver.findElement(By.xpath("//div[@title='Aqualens']")).getText();
        if (verifyTAsk.equals("Aqualens")){
            System.out.println("Succefully created Task");
        }
        else
        {
            throw new Exception("Unable to create Task");
        }
    }
}
