package com.automation.demo.site;

import com.actitime.automation.page.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class RegisterTest {
    WebDriver driver;
    RegisterPage registerPage;

    @BeforeClass
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("stable");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();
        registerPage = new RegisterPage(driver);
    }

    @Test
    public void register() {
        driver.findElement(this.registerPage.firstName).sendKeys("Sahil");
        driver.findElement(registerPage.lastName).sendKeys("Dahale");
        driver.findElement(registerPage.address).sendKeys("Shivaji Nagar near Bank of Maharashtra Hingoli");
        driver.findElement(registerPage.emailId).sendKeys("sahil.dahale724@gmail.com");
        driver.findElement(registerPage.mobileNo).sendKeys("9657400682");
        driver.findElement(registerPage.radioButtonMale).click();
        driver.findElement(registerPage.hobbiesCricket).click();
        driver.findElement(registerPage.hobbiesHockey).click();
        driver.findElement(registerPage.hobbiesMovies).click();

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.elementToBeClickable(registerPage.languagesDropdown)).click();
        registerPage.selectLanguage("English");
        registerPage.selectByValueforSkills("Android");

        // Wait until the Country dropdown is visible and clickable
        WebElement countryDropdown = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement element = driver.findElement((By) registerPage.Countrydropdown);
                if (element.isDisplayed() && element.isEnabled()) {
                    return element;
                }
                return null;
            }
        });
        countryDropdown.click();

        // Wait until the select2 country container is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("select2-country-container")));
        wait.until(ExpectedConditions.elementToBeClickable(registerPage.Countrydropdown)).click();
        registerPage.SelectCountry("India");
    }
}
