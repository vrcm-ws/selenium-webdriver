package com.herokuapp.theinternet.utilities;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory
{
    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private String browser;
    private Logger logger;

    public DriverFactory(String browser, Logger logger)
    {
        this.browser = browser.toLowerCase();
        this.logger = logger;
    }

    public WebDriver createWebDriver()
    {
        logger.info("Create driver: " + browser);

        switch(browser)
        {
            case "firefox":
                driver.set(new FirefoxDriver());
                break;
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                driver.set(new ChromeDriver(options));
                break;
            default:
                driver.set(new ChromeDriver());
        }

        return driver.get();
    }
}

