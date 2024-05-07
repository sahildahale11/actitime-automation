package com.actitime.automation;

import com.commonfunction.automation.CommonFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestNgLoginPage {
    WebDriver driver;

    CommonFunction commonFunction;

    public TestNgLoginPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    public By username = By.id("username");

    public By password =By.name("pwd");

    @FindBy(id="loginButton")
    WebElement loginButton;
    public void login(String username,String password)
    {
        commonFunction = new CommonFunction();
        driver.findElement(this.username).sendKeys(username);
        driver.findElement(this.password).sendKeys(password);
        commonFunction.click(loginButton);

    }


}
