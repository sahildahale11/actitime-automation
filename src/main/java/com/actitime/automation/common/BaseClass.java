package com.actitime.automation.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {
    WebDriver driver;
  public WebDriver launchBrowser(String browserName)
  {
      switch (browserName)
      {
          case "chrome":
              ChromeOptions options = new ChromeOptions();
              options.setBrowserVersion("121");
              options.addArguments("--remote-allow-origins=*");
              driver = new ChromeDriver(options);
          case "edge":
              ChromeOptions edgeoptions = new ChromeOptions();
              edgeoptions.setBrowserVersion("121");
              edgeoptions.addArguments("--remote-allow-origins=*");
              driver = new ChromeDriver(edgeoptions);
          case "firefox":
              ChromeOptions firefoxoptions = new ChromeOptions();
              firefoxoptions.setBrowserVersion("121");
              firefoxoptions.addArguments("--remote-allow-origins=*");
              driver = new ChromeDriver(firefoxoptions);
          default:
              ChromeOptions chromeOptions = new ChromeOptions();
              chromeOptions.setBrowserVersion("121");
              chromeOptions.addArguments("--remote-allow-origins=*");
              driver = new ChromeDriver(chromeOptions);
      }
      driver.manage().window().maximize();
      return driver;
  }
}
