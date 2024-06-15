package PreacticeCode;


import com.actitime.automation.common.CommonFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

    public class TestCode {
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
        public void userTask() throws Exception {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            // Click on Users Module
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Users'][@class='label']"))).click();

            // click on Add Users
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//th[@id='sortByPTOControl']/preceding::span[text()='All Users']"))).click();

            //click On Selected user
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Selected users']"))).click();

            //click on user
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='ellipsisLabel'][text()='Womack, Ashley']"))).click();

            //click on Apply Button
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Apply'])[2]"))).click();

            // Click on Selected Customer
            WebElement el1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='userNameSpan'][text()='Womack, Ashley']")));
            el1.click();
            Thread.sleep(5000);
            Actions actions = new Actions(driver);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='regularRateColumn']")));
            actions.scrollToElement(driver.findElement(By.xpath("//div[@class='regularRateColumn']"))).build().perform();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='regularRateColumn']"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//DIV[@class='clearButton']/self::DIV"))).click();
            WebElement ratesField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='regularRateColumn']")));
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='regularRateColumn']"))));
            actions.sendKeys(driver.findElement(By.xpath("//div[@class='regularRateColumn']")), "10000").build().perform();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//DIV[@class='hideButton_panelContainer']/self::DIV"))).click();
            driver.navigate().refresh();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//thead[@id='userListTableHeader']/following::div[12]"))).click();
            Thread.sleep(10000);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='editUserPanel']/descendant::span[3]"))).click();
            actions.scrollToElement(driver.findElement(By.xpath("//div[@class='regularRateColumn']"))).build().perform();
            WebElement ratesText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='regularRateColumn']")));
            WebElement inputElement = driver.findElement(By.xpath("//div[@class='regularRateColumn']/descendant::input[1]"));

            // Get the value attribute of the input element (text entered by the user)
            String gt = inputElement.getAttribute("value");

            // Print the text
            System.out.println("Rates : " + gt);
            Assert.assertEquals(gt, "10000.00", "Test Case Passed, Value Matched");
        }
    }








