package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage
{
    protected WebDriver driver;
    protected Logger logger;

    private Duration timeout = Duration.ofSeconds(10);

    public BasePage(WebDriver driver, Logger logger)
    {
        this.driver = driver;
        this.logger = logger;
    }

    protected Duration getTimeout()
    {
        return this.timeout;
    }

    protected void setTimeout(Duration timeout)
    {
        this.timeout = timeout;
    }


    public String getCurrentURL()
    {
        return driver.getCurrentUrl();
    }

    protected void openPage(String url)
    {
        driver.get(url);
    }

    /**
     * Locates and returns a WebElement
     * @param locator Locator of the element
     * @return Element located
     */
    protected WebElement locateElement(By locator)
    {
        return driver.findElement(locator);
    }

    protected void click(By locator)
    {
        waitForVisibilityOf(locator, timeout);
        locateElement(locator).click();
    }

    protected void type(By locator, String text)
    {
        waitForVisibilityOf(locator, timeout);
        locateElement(locator).sendKeys(text);
    }

    protected void waitFor(ExpectedCondition<WebElement> condition, Duration timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(condition);
    }

    protected void waitForVisibilityOf(By locator, Duration timeoutInSeconds)
    {
        try
        {
            waitFor(ExpectedConditions.visibilityOfElementLocated(locator), timeoutInSeconds);
        }
        catch (StaleElementReferenceException e)
        {
            logger.info(e.getMessage());
        }
    }
}
