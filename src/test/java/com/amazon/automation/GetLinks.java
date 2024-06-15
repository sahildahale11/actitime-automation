package com.amazon.automation;

import com.actitime.automation.common.CommonFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class GetLinks {
    public static void main(String[] args) throws InterruptedException, IOException {
        CommonFunction commonFunction = new CommonFunction();
        WebDriver driver = commonFunction.launchBrowser("chrome");
        driver.get("https://amazon.in/");
        Thread.sleep(5000);

        List<WebElement> Weblinks = driver.findElements(By.tagName("a")); // this gives us address that's why we convert into string


        // Iterate through the list of the elements
        for (WebElement element : Weblinks) {
            String link = element.getAttribute("href");
            if (link != null && !link.startsWith("javaScript:")) {
                // Convert String URL into Actual URl
                URL url = new URL(link);

                //Opening connection for an URL using port
                URLConnection connection = url.openConnection();

                //cast connection var into HTTPurl connection
                // downcasting
                HttpURLConnection urlConnection = (HttpURLConnection)connection;

                // hit the URL
                urlConnection.connect();

                // get status code
                int statuscode = urlConnection.getResponseCode();
                if (statuscode !=200)
                {
                    System.out.println("Broken link "+statuscode +" "+ link);
                }


            }

        }

driver.quit();
    }
}
