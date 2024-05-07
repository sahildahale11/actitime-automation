package com.orangehrm.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginPageOrangeHrm {
    WebDriver driver;

    public LoginPageOrangeHrm(WebDriver driver) {
        this.driver = driver;

    }

    public void chromeSettings()
    {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("121");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        // maximize the window
        driver.manage().window().maximize();
    }

    public void login(String username, String password) {
        driver.findElement(By.name("username")).sendKeys(username);

        //Locate the Password element
        driver.findElement(By.name("password")).sendKeys(password);


        //locate login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }

    public void logout() {
        driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']/following-sibling::i")).click();


        // Click on Logout button
        driver.findElement(By.xpath("//a[text()='Logout']")).click();
    }

    public void verifyMsg(String errorMsg) throws Exception {
        if (errorMsg.equals("Invalid credentials")) {
            System.out.println("Test case Passed With Invalid credentials");
        } else {
            throw new Exception("Test case Failed: Error msg not displaying on display Invalid credentials");
        }
    }

    public void requiredMsg(String massage) throws Exception {
        if (massage.equals("Required")) {
            System.out.println("Test Case Passed With 'Required' Massage Display ");
        } else {
            throw new Exception("Testcase Failed :Required Massage not displaying on fields");
        }
    }

    public void addEmployee(String firstName, String middleName, String lastName, String id) {
        driver.findElement(By.name("firstName")).sendKeys(firstName);
        driver.findElement(By.name("middleName")).sendKeys(middleName);
        driver.findElement(By.name("lastName")).sendKeys(lastName);
        driver.findElement(By.xpath("//label[text()='Employee Id']/following::input[1]")).sendKeys(id);

    }

}
