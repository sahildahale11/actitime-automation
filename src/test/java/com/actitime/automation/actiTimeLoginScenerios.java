package com.actitime.automation;

import com.actitime.automation.common.CommonFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class actiTimeLoginScenerios {
    public static void main(String[] args) throws Exception {
        CommonFunction commonFunction = new CommonFunction();
        WebDriver driver = commonFunction.launchBrowser("chrome");

        driver.get("https://online.actitime.com/sd1/tasks/tasklist.do");
        Thread.sleep(10000);

        //Login To username And password With Positive Scnerios
        commonFunction.loginUserforactiTime("sahil.dahale98@gmail.com","Pass@123");
        Thread.sleep(3000);
        String timeTrack = driver.findElement(By.xpath("//div[@id='container_tt']/following-sibling::div[1]")).getText();
        commonFunction.verifyMassage(timeTrack);
        Thread.sleep(6000);
        // Logout Application
        driver.findElement(By.xpath("//tr[@class='logoutContainer']/descendant::a[2]")).click();
        String headerContainer = driver.findElement(By.id("headerContainer")).getText();
        if (headerContainer.equals("Please identify yourself"))
        {
            System.out.println("Successfully Logout");
        }
        else {
            throw new Exception("Unable to logout");
        }
        // NEGATIVE SCNERIOS
        //To Verify Login feature With Invalid Credentials
        commonFunction.loginUserforactiTime("abc@gmail.com","Pass@122");
        Thread.sleep(3000);
        String verifyLoginMsg =driver.findElement(By.xpath("//span[text()='Username or Password is invalid. Please try again.']")).getText();
        commonFunction.verifyInvalidCredentialsMassage(verifyLoginMsg);
        driver.navigate().refresh();

        // To Verify Login feature With Invalid username and valid password
        commonFunction.loginUserforactiTime("abc@gmail.com","Test@1234");
        Thread.sleep(3000);
         verifyLoginMsg =driver.findElement(By.xpath("//span[text()='Username or Password is invalid. Please try again.']")).getText();
        commonFunction.verifyInvalidCredentialsMassage(verifyLoginMsg);
        driver.navigate().refresh();

        // To Verify Login feature With valid username and Invalid password
        commonFunction.loginUserforactiTime("cybersuccess@yopmail.com","Pass@122");
        Thread.sleep(3000);
        verifyLoginMsg =driver.findElement(By.xpath("//span[text()='Username or Password is invalid. Please try again.']")).getText();
        commonFunction.verifyInvalidCredentialsMassage(verifyLoginMsg);
        driver.navigate().refresh();
        // To Verify Login feature With Blank Credentials
        commonFunction.loginUserforactiTime("","");
        Thread.sleep(3000);
        verifyLoginMsg =driver.findElement(By.xpath("//span[text()='Username or Password is invalid. Please try again.']")).getText();
        commonFunction.verifyInvalidCredentialsMassage(verifyLoginMsg);
        driver.navigate().refresh();
        // To Verify Login feature With Blank username and valid Password
        commonFunction.loginUserforactiTime("","Test@1234");
        Thread.sleep(3000);
        verifyLoginMsg =driver.findElement(By.xpath("//span[text()='Username or Password is invalid. Please try again.']")).getText();
        commonFunction.verifyInvalidCredentialsMassage(verifyLoginMsg);
        driver.navigate().refresh();
        // To Verify Login feature With Blank username and valid Password
        commonFunction.loginUserforactiTime("cybersuccess@yopmail.com","");
        Thread.sleep(3000);
        verifyLoginMsg =driver.findElement(By.xpath("//span[text()='Username or Password is invalid. Please try again.']")).getText();
        commonFunction.verifyInvalidCredentialsMassage(verifyLoginMsg);
        driver.navigate().refresh();
    }

}
