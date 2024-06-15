package com.actitime.automation;


import com.actitime.automation.common.BaseClass;
import com.actitime.automation.common.CommonFunction;
import com.actitime.automation.page.TaskPage;
import com.actitime.automation.page.TestNgLoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class TestNgPrintAllTask extends BaseClass {

    WebDriver driver;

    TestNgLoginPage testNgLoginPage;

    CommonFunction commonFunction;

    TaskPage taskPage;

    @BeforeClass
    public void Setup() {
        commonFunction = new CommonFunction();
        testNgLoginPage = new TestNgLoginPage(driver);
        driver = commonFunction.launchBrowser("chrome");
        driver.get("https://online.actitime.com/sd1/tasks/tasklist.do");
        taskPage = new TaskPage(driver);

    }
    @BeforeMethod
    public  void login()
    {

        commonFunction.loginUserforactiTime("Sahil.dahale98@gmail.com","Pass@123");
    }

    @Test
    public void PrintTaskName() {
        commonFunction.click(taskPage.taskModule); // Click on task module
        commonFunction.click(taskPage.project); // Click on project -- flight operation
        commonFunction.click(taskPage.checkBox); // Click on checkbox

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class)
                .ignoring(org.openqa.selenium.StaleElementReferenceException.class);

        List<WebElement> taskNames = taskPage.getTaskList();
        for (WebElement element : taskNames) {
            try {
                wait.until(ExpectedConditions.visibilityOf(element));
                if (element.isDisplayed()) {
                    System.out.println(element.getText());
                } else {
                    Actions actions = new Actions(driver);
                    actions.scrollToElement(element).perform();
                    System.out.println(element.getText());
                }
            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                System.out.println("Encountered StaleElementReferenceException, retrying...");
                // Refetch the elements
            } catch (org.openqa.selenium.TimeoutException e) {
                System.out.println("TimeoutException: " + e.getMessage());
            }
        }
    }

}

//    @AfterClass
//    public void tearDown()
//    {
//        driver.quit();
//    }

