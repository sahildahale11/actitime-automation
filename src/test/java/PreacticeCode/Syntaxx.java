package PreacticeCode;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.function.Function;

public class Syntaxx {

    public static void main(String[] args) throws IOException {
        ChromeOptions option = new ChromeOptions();
        option.setBrowserVersion("125");
        option.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(option);
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();

        // Fluent Wait
        // Waiting 30 seconds for an element to be present on the page, checking
        // for its presence once every 5 seconds.
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(Exception.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("foo"));
            }
        });

        //Take ScreenShot
        File screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotAs,new File("ss.png"));

        // Upload a File
       WebElement uploadFile= driver.findElement(By.xpath("Elid"));
       uploadFile.sendKeys("C:\\Users\\HP\\Desktop\\Saurabh_Jain_Resume.pdf");


    }

}
