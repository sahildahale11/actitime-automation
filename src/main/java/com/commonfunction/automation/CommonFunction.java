package com.commonfunction.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class CommonFunction {
    WebDriver driver;

    public CommonFunction() {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

//    public void CommonFunction1(WebDriver driver) {
//        this.driver=driver;
//
//    }


    public WebDriver launchBrowser(String name) {
        if (name.toLowerCase().equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.setBrowserVersion("121");
            options.addArguments("--remote-allow-origins=*");

            driver = new ChromeDriver(options);

            // maximize the window
            driver.manage().window().maximize();
        }
        return driver;

    }

    public void waitForElementToPresent(By by)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
    }
    public void waitElementToClickable(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void waitElementToClickable(By by)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public void fluentWait(By by)
    {
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .pollingEvery(Duration.ofSeconds(5))
                .withTimeout(Duration.ofSeconds(25))
                .ignoring(Exception.class);
        Function<WebDriver,WebElement> function = (var) ->{
            System.out.println("Wait until the element is avaliable...");
            waitElementToClickable(driver.findElement(by));
            return driver.findElement(by);
        };
        fluentWait.until(function);
    }
    public void enterTextWithJavaScript(String text,WebElement element)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='"+text+"';",element);
    }
    public void clickUsingJavaScript(WebElement  element)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click;",element);
    }
    public void scrollToElement(WebElement element)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
    }

    public void scrollBy(int x,int y)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy("+x+","+y+");");
    }
    public void click(WebElement element)
    {
        waitElementToClickable(element);
        element.click();
    }
    public void click(By by)
    {
        fluentWait(by);
        driver.findElement(by).click();
    }

    public void loginForActitime() {
        driver.findElement(By.name("username")).sendKeys("sahil.dahale98@gmail.com");
        driver.findElement(By.name("pwd")).sendKeys("Pass@123");
        driver.findElement(By.xpath("//a[@id='loginButton']/child::div")).click();
    }

    public void loginUserforactiTime(String username, String password) {
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("pwd")).sendKeys(password);
        driver.findElement(By.xpath("//a[@id='loginButton']/child::div")).click();

    }

    public void verifyInvalidCredentialsMassage(String msg) throws Exception {
        if (msg.equals("Username or Password is invalid. Please try again.")) {
            System.out.println("Test Case Passes,Invalid Credentials");
        } else {
            throw new Exception("Test case fail, Login Successfully");
        }
    }

    public void verifyMassage(String msg) throws Exception {
        if (msg.equals("Time-Track")) {
            System.out.println("Test Case Pass,Successfully landed on Time-Track module");
        } else {
            throw new Exception("Test case Fail,Unable to login application");
        }
    }

}
