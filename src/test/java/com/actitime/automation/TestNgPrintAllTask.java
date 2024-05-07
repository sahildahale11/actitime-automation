package com.actitime.automation;

import com.actitime.automation.pages.TaskPage;
import com.commonfunction.automation.BaseClass;
import com.commonfunction.automation.CommonFunction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

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
    public void PrintTaskName()
    {
        commonFunction.click(taskPage.taskModule);
        commonFunction.click(taskPage.project);
        List<WebElement> taskNames = taskPage.taskList;
        for (WebElement element : taskNames)
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOfAllElements(element));
            if (element.isDisplayed())
            {
                System.out.println(element.getText());
            }
            else {
                Actions actions = new Actions(driver);
                actions.scrollToElement(element).build().perform();

            }
        }

        }
    }
//    @AfterClass
//    public void tearDown()
//    {
//        driver.quit();
//    }

