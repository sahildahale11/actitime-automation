package com.actitime.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TaskPage {
    WebDriver driver;
    public  TaskPage(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    public By taskModule = By.id("container_tasks");

    public By project =By.xpath("//div[text()='All Customers']/following::div[11]");

    //public By taskModule = By.xpath("//div[@id='container_tasks']/following::div[1]");

   // public By project = By.xpath("//div[text()='All Customers']/following::div[11]");

    // driver.findElement replace  by @FindBy Annotation
    @FindBy(xpath = "//tr[@class='headers']/descendant::div[2]")
    public WebElement checkBox;
    @FindBy(xpath = "//tr[contains(@class,'taskRow')]/td[2]//div[@class='title']")
    public List<WebElement> taskList;


}
