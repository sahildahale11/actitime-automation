package com.realtime.scnerios.question;

import com.actitime.automation.common.CommonFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class SuccessfullyLoggedIn {
    WebDriver driver;
    @BeforeClass
    public void setup() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("121");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(7000);

    }
    @Test
    public void loginToFaceBook()
    {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        String expectdResult ="Swag Labs";
        String text = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='app_logo']"))).getText();
        System.out.println(text);
        if (text.equals("Swag Labs"))
        {
            System.out.println("Test case passed");
        }
        else {
            System.out.println("Test case Failed");
        }



    }
}
