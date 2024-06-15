package com.realtime.scnerios.question;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class rowsAndcolumnsofWebTables {
    public static void main(String [] args)
    {
        // Browser Settings
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("125");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        // Locate the table Element
        WebElement table = driver.findElement(By.xpath("//table[@id='product'][@name='courses']"));

        // Find all the rows of the table
        List<WebElement> rows =  driver.findElements(By.tagName("tr"));

        // Iterate througn each row
        for ( WebElement row:rows)
        {
            // find all the columns within the current rows
            List<WebElement> columns= row.findElements(By.tagName("td"));

            //Iterate through each cloumn
            for (WebElement column :columns)
            {
                // print the test of each cell
                System.out.println(column.getText());
            }
            // move to the next row
            System.out.println();
        }
    }
}
