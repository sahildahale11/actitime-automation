package com.amazon.automation;

import com.commonfunction.automation.CommonFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

public class BrokenImages {
    public static void main(String[] args) throws InterruptedException {
        CommonFunction commonFunction = new CommonFunction();
        WebDriver driver = commonFunction.launchBrowser("chrome");
        driver.get("https://amazon.in/");
        Thread.sleep(5000);

        List<WebElement> brokenImage = driver.findElements(By.tagName("img")); // this gives us address that's why we convert into string


        // Iterate through the list of the elements
        for (WebElement element : brokenImage) {
            String bImage = element.getAttribute("src");
            if (bImage != null && !bImage.isEmpty()) {
                try {
                    // Open a connection to the image URL
                    HttpURLConnection connection = (HttpURLConnection) new URL(bImage).openConnection();
                    connection.setRequestMethod("HEAD");

                    // Check the response code
                    int responseCode = connection.getResponseCode();
                    if (responseCode != HttpURLConnection.HTTP_OK) {
                        System.out.println("Broken Image Found: " + bImage + " Response Code: " + responseCode);
                    }
                    connection.disconnect();
                } catch (IOException e) {
                    System.out.println("Exception occurred while checking image URL: " + bImage);
                }
            }
        }


    }
}

