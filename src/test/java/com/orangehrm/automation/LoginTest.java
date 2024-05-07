/*
package com.orangehrm.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class LoginTest {

    public static void main(String[] args) throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("121");
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);

        // maximize the window
        driver.manage().window().maximize();

        // navigate to URl
        driver.get("https://opensource-demo.orangehrmlive.com/");
        Thread.sleep(10000);

        //getTitle() Method
        String title = driver.getTitle();
        System.out.println(title);
        Thread.sleep(2000);

        //getAttribute() Methood
        WebElement getusername = driver.findElement(By.name("username"));
        String placeholder = getusername.getAttribute("Placeholder");
        System.out.println(placeholder);

        Thread.sleep(10000);
        // Login Method Call
        LoginPage loginPage = new LoginPage(driver);

        // VALID USERNAME AND PASSWORD
        loginPage.login("Admin", "admin123");
        Thread.sleep(10000);

        // Locate the Dashboard text and get the text
        WebElement dashboard = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
        String dashboardText = dashboard.getText();
        System.out.println(dashboardText);

        if (dashboardText.equals("Dashboard")) {
            System.out.println("Successfully landed on Dashboard module");
        } else {
            throw new Exception("Unable to login application");
        }
        Thread.sleep(10000);

        WebElement searchBox =driver.findElement(By.xpath("//div[@id='app']/descendant::input[1]"));
        if (searchBox.isDisplayed())
        {
            searchBox.sendKeys("Recruitment");
        }
        driver.navigate().refresh();
Thread.sleep(3000);
        // click on profile section to perform logout operation
        loginPage.logout();

        Thread.sleep(5000);


        // CHECK WITH VALID USERNAME AND INVALID PASSWORD
        loginPage.login("Admin", "Pass@123");
        Thread.sleep(5000);
        String errorMsg = driver.findElement(By.xpath("//*[text()='Invalid credentials']")).getText();

        loginPage.verifyMsg(errorMsg);

        driver.navigate().refresh();
        Thread.sleep(5000);

        // CHECK WITH INVALID USERNAME AND VALID PASSWORD
        loginPage.login("sail", "admin123");
        Thread.sleep(5000);
        errorMsg = driver.findElement(By.xpath("//*[text()='Invalid credentials']")).getText();
        loginPage.verifyMsg(errorMsg);

        driver.navigate().refresh();
        Thread.sleep(5000);

        // CHECK WITH INVALID USERNAME AND INVALID PASSWORD
        loginPage.login("sail", "sail@123");
        Thread.sleep(5000);
        errorMsg = driver.findElement(By.xpath("//*[text()='Invalid credentials']")).getText();
        loginPage.verifyMsg(errorMsg);

        driver.navigate().refresh();
        Thread.sleep(5000);


        // CHECK REQUIRED MSG DISPLAY OR NOT


        // CHECK WITH BLANK USERNAME AND BLANK PASSWORD
        loginPage.login("", "");
        String requiredMsg = driver.findElement(By.xpath("//input[@name='_token']/following::span[1]")).getText();
        loginPage.requiredMsg(requiredMsg);
        driver.navigate().refresh();
        Thread.sleep(5000);


        //CHECK WITH BLANK PASSWORD
        loginPage.login("Admin", "");
        requiredMsg = driver.findElement(By.xpath("//input[@name='_token']/following::span[1]")).getText();
        loginPage.requiredMsg(requiredMsg);

        driver.navigate().refresh();
        Thread.sleep(5000);


        //CHECK WITH BLANK USERNAME
        loginPage.login("", "admin123");
        requiredMsg = driver.findElement(By.xpath("//input[@name='_token']/following::span[1]")).getText();
        loginPage.requiredMsg(requiredMsg);
    }

}
*/
