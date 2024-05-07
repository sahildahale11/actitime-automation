package com.actitime.automation;

import com.commonfunction.automation.CommonFunction;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class PrintAllTask {
    public static void main(String[] args) throws Exception {
        CommonFunction commonFunction = new CommonFunction();
        WebDriver driver = commonFunction.launchBrowser("chrome");
        driver.get("https://online.actitime.com/sd1/tasks/tasklist.do");
        Thread.sleep(5000);

        commonFunction.loginForActitime();
        Thread.sleep(7000);
        Actions actions = new Actions(driver);

        driver.findElement(By.xpath("//div[@id='container_tasks']/following::div[1]")).click();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//div[@class='checkbox inactive']/child::div")).click();
        driver.findElement(By.xpath("//div[text()='All Customers']/following::div[11]")).click();
        Thread.sleep(3000);

        List<WebElement> taskRows = driver.findElements(By.xpath("//tr[contains(@class,'taskRow')]/td[2]//div[@class='title']"));
        for (WebElement we : taskRows) {
            if (we.isDisplayed()) {
                String weText = we.getText();
                System.out.println(weText);
            } else {
                Actions actions1 = new Actions(driver);
                actions1.scrollToElement(we).build().perform();
                String weText = we.getText();
                System.out.println(weText);
            }
        }
// Click on All check box
        driver.findElement(By.xpath("//tr[@class='headers']/descendant::div[2]")).click();
        Thread.sleep(3000);
        // Click on move to
        driver.findElement(By.xpath("//div[text()='Move to' and @class='moveTo button']")).click();
        Thread.sleep(3000);
        // click on select customer
        driver.findElement(By.xpath("//div[@class='emptySelection' and text()='- Select Customer -']")).click();
        Thread.sleep(7000);
        // select and click on customer
        driver.findElement(By.xpath("//div[@class='emptySelection' and text()='- Select Customer -']/following::div[10]")).click();

        Thread.sleep(3000);
        // click on project
        driver.findElement(By.xpath("//div[@class='emptySelection'][text()='- Select Project -']")).click();
        Thread.sleep(3000);
        // select and click on project
        driver.findElement(By.xpath("//div[@class='itemRow cpItemRow '][text()='Flight operations']/following-sibling::div[2]")).click();
        Thread.sleep(3000);
        //click on move button
        driver.findElement(By.xpath("(//div[@class='ok button' and text()='Move'])[2]")).click();
        Thread.sleep(2000);
//      String moveTask = driver.findElement(By.xpath("//span[text()='Total for 0 tasks:']")).getText();
//      Thread.sleep(6000);
//
//      if (moveTask.equals("Total for 0 tasks:"))
//      {
//          System.out.println("Task moved Successfully");
//      }
//      else
//      {
//          throw new Exception("Task not Moved");
//      }

        WebElement checkBoxButton = null;
        try {
            checkBoxButton = driver.findElement(By.xpath("//tr[@class='headers']/descendant::div[2]"));
            if (checkBoxButton.isSelected()) {
                System.out.println("Task not Moved");
            } else {
                throw new Exception("Task moved Successful");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Checkbox element not found");
        } catch (Exception ex) {
            System.out.println("Test case passed"+ex.getMessage());
        }


driver.navigate().refresh();
Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@id='taskListBlock']/preceding::div[text()='Lenskart']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//tr[@class='headers']/descendant::div[2]")).click();

        try {
           WebElement checkBoxButton1 = driver.findElement(By.xpath("//tr[@class='headers']/descendant::div[2]"));
            if (checkBoxButton1.isSelected()) {
                System.out.println("Task moved successfully");
            } else {
                throw new Exception("Task Not Moved");
            }
        }  catch (Exception ex) {
            System.out.println("Test case passed "+ex.getMessage());
        }

// right hand scroll
      actions.scrollByAmount(100,0);
        // left hand side
        actions.scrollByAmount(-100,0);
        // vaericall
        actions.scrollByAmount(0,100);
        actions.scrollByAmount(0,-100);

        WebElement ddd =driver.findElement(By.xpath("//iframe[@name='aswift_3']"));
        driver.switchTo().frame(ddd);

        driver.switchTo().frame(1);

        driver.switchTo().frame("aswift_2");
        driver.switchTo().parentFrame();


        driver.switchTo().newWindow(WindowType.TAB);
        driver.switchTo().newWindow(WindowType.WINDOW);




    }
}
