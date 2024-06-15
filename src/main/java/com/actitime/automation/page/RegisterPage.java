package com.actitime.automation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.security.PublicKey;

public class RegisterPage {
    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public By firstName = By.xpath("//input[@Placeholder='First Name']");
    public By lastName = By.xpath("//input[@Placeholder='Last Name']");
    public By address = By.xpath("//label[text()='Address']/following::textarea");
    public By emailId = By.xpath("//label[text()='Email address*']/following::input[1]");
    public By mobileNo = By.xpath("//label[text()='Phone*']/following::input[1]");
    public By radioButtonMale = By.xpath("//label[text()='Gender*']/following::input[1]");
    public By hobbiesCricket = By.id("checkbox1");
    public By hobbiesMovies = By.id("checkbox2");
    public By hobbiesHockey = By.id("checkbox3");
   // public By languagedropdown = By.id("msdd");
   @FindBy(id = "msdd")
   public WebElement languagesDropdown;

    @FindBy(id = "Skills")
   public WebElement skills;
    public void selectLanguage(String language) {
        languagesDropdown.click();
        WebElement langOption = driver.findElement(By.xpath("//a[text()='English']"));
        langOption.click();
    }

    public void selectByVisibleTextforSkills(String visibleText) {
        Select select = new Select(skills);
        select.selectByVisibleText(visibleText);
    }

    public void selectByValueforSkills(String value) {
        Select select = new Select(skills);
        select.selectByValue(value);

    }

    public void selectByIndexforSkills(int index) {
        Select select = new Select(skills);
        select.selectByIndex(index);

    }

    @FindBy(id = "countries")
    WebElement country;

    public void selectByVisibleTextforCountry(String visibleText) {
        Select select = new Select(country);
        select.selectByVisibleText(visibleText);
    }

    public void selectByValurforCountry(String value) {
        Select select = new Select(country);
        select.selectByValue(value);
    }

    public void selectByIndexforCountry(int index1) {
        Select select = new Select(country);
        select.selectByIndex(index1);
    }
    @FindBy(id = "select2-country-container")
    public WebElement Countrydropdown;

    public void SelectCountry(String country)
    {
        Countrydropdown.click();
        WebElement selectcountry1 = driver.findElement(By.xpath("//li[text()='India']"));
        selectcountry1.click();
    }

    @FindBy(id = "countries")
    WebElement countries;
    public void selectCountryDropdown()
    {
        countries.click();

    }



}
