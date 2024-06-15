package com.actitime.automation.page;

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

    //without pagefactory

    public By taskModule = By.id("container_tasks"); // task module path

    public By project =By.xpath("//div[text()='All Customers']/following::div[11]"); // project path --Flight Operation

    // using pageFactory
    // driver.findElement replace  by @FindBy Annotation
    @FindBy(xpath = "//tr[@class='headers']/descendant::div[2]") // click on checkbox select all tasks
    public WebElement checkBox;
    @FindBy(xpath = "//tr[contains(@class,'taskRow')]/td[2]//div[@class='title']") // path to get alll the task one by one
    public List<WebElement> taskList;


    public List<WebElement> getTaskList() {
        return taskList;
    }
}
