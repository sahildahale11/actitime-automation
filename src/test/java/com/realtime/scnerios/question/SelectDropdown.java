package com.realtime.scnerios.question;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdown {
    public static void main(String [] args)
    {
        // setup
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("125");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        WebElement dropDown = driver.findElement(By.id("dropdown-class-example"));

        Select select = new Select(dropDown);
  select.selectByVisibleText("Option3");
        WebElement firstSelectedOption = select.getFirstSelectedOption();
        String text = firstSelectedOption.getText();
        System.out.println(text);

        //  Switch to Alert  Example Enter Your Name
        driver.findElement(By.xpath("//input[@id='name'][@name='enter-name']")).sendKeys("Sahil");
        driver.findElement(By.id("alertbtn")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //driver.quit();
    }

}
