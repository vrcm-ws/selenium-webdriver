package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

    /**
     * Find all elements using the given locator
     * @param locator Element locator
     * @return List of elements located
     */
    protected List<WebElement> locateElements(By locator)
    {
        return driver.findElements(locator);
    }

    protected void click(By locator)
    {
        waitForVisibilityOf(locator, timeout);
        locateElement(locator).click();
    }

    public String getPageTitle()
    {
        return driver.getTitle();
    }

    public String getPageSource()
    {
        return driver.getPageSource();
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

    /**
     * Wait for an alert to be present ans switch to it
     * @return Alert
     */
    protected Alert switchToAlert()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        return driver.switchTo().alert();
    }

    public void switchToWindow(String windowTitle)
    {
        String baseWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows)
        {
            if (!window.equals(baseWindow))
            {
                driver.switchTo().window(window);

                if (getPageTitle().equals(windowTitle))
                {
                    break;
                }
            }
        }
    }
}
