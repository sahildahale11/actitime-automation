/*
package com.orangehrm.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PimModule {
    public static void main(String[] args) throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("121");
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);

        // String filepath = "C:/Users/HP/Downloads/1.png/";

        // maximize the window
        driver.manage().window().maximize();

        // navigate to URl
        driver.get("https://opensource-demo.orangehrmlive.com/");

        Thread.sleep(10000);
        LoginPage loginPage = new LoginPage(driver);

        // Locate the userName Element
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");

        //Locate the Password element
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        //locate login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

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
        //click on PIM Module
        WebElement pim = driver.findElement(By.xpath("//span[text()='PIM']/parent::a"));
        pim.click();
        Thread.sleep(5000);

        String pimText = driver.findElement(By.xpath("//h6[text()='PIM']")).getText();
        // Thread.sleep(5000);
        System.out.println(pimText);
        if (pimText.equals("PIM")) {
            System.out.println("Successfully landed on PIM module");
        } else {
            throw new Exception("Not landing on the PIM module");
        }


        Thread.sleep(10000);

        //Click on Add Button
        WebElement add = driver.findElement(By.xpath("//div[@class='orangehrm-container']/preceding::button[1]"));
        add.click();

        Thread.sleep(5000);

        // Add Employee UserName Field With Valid

        loginPage.addEmployee("Mr.John", "Michal", "palvin", "2515");
        driver.findElement(By.xpath("//button[text()=' Save ']")).click();
        Thread.sleep(10000);

        // Blank First Name And LastName
        driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
        Thread.sleep(5000);
        loginPage.addEmployee("", "hhgurhg", "", "5115");
        driver.findElement(By.xpath("//button[text()=' Save ']")).click();
        Thread.sleep(3000);
        String requiredMassage = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]")).getText();
        loginPage.requiredMsg(requiredMassage);

        // Blank FirstName
        driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
        Thread.sleep(5000);
        loginPage.addEmployee("", "Ram", "Pathak", "5912");
        driver.findElement(By.xpath("//button[text()=' Save ']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]")).getText();
        loginPage.requiredMsg(requiredMassage);

        // Blank LastName
        driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
        Thread.sleep(5000);
        loginPage.addEmployee("Ram", "ShriRAm", "", "7893");
        driver.findElement(By.xpath("//button[text()=' Save ']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]")).getText();
        loginPage.requiredMsg(requiredMassage);
    }

}
*/
