package com.demo.qa;

import com.actitime.automation.page.DemoQaPage;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoQaTest {
    WebDriver driver;
    DemoQaPage demoQaPage;

    @BeforeClass
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("stable");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
        demoQaPage = new DemoQaPage(driver);
    }

    @Test
    public void Forms() {
        driver.findElement(By.id(String.valueOf(demoQaPage.forms))).click();
        driver.findElement((By) demoQaPage.PracticeForm).click();
        driver.findElement((By) demoQaPage.firstName).sendKeys("Sahil");
        driver.findElement((By) demoQaPage.lastName).sendKeys("Dahale");
        driver.findElement((By) demoQaPage.mobileNo).sendKeys("sahil.dahale724@gmail.com");
        driver.findElement((By) demoQaPage.radioButtom).click();
        driver.findElement((By)demoQaPage.mobileNo).sendKeys("9657400682");
        driver.findElement((By)demoQaPage.subjects).sendKeys("Java");
        driver.findElement((By)demoQaPage.sport).click();
        driver.findElement((By)demoQaPage.reading).click();
        driver.findElement((By)demoQaPage.music).click();


    }

}
