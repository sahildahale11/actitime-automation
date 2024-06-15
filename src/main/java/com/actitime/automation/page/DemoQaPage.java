package com.actitime.automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoQaPage {
    WebDriver driver;

    public DemoQaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h5[text()='Forms']")
    public WebElement forms;
    @FindBy(xpath = "//span[text()='Practice Form']")
    public WebElement PracticeForm;
    @FindBy(id = "firstName")
    public WebElement firstName;
    @FindBy(id = "lastName")
    public WebElement lastName;
    @FindBy(id = "userEmail")
    public WebElement emailId;
    @FindBy(id = "gender-radio-1")
    public WebElement radioButtom;
    @FindBy(id = "userNumber")
    public WebElement mobileNo;
    @FindBy(id = "//div[@id='subjectsWrapper']/descendant::div[5]")
    public WebElement subjects;
    @FindBy(id = "hobbies-checkbox-1")
   public WebElement sport;
    @FindBy(id = "hobbies-checkbox-2")
    public WebElement reading;
    @FindBy(id = "hobbies-checkbox-3")
    public WebElement music;


}
