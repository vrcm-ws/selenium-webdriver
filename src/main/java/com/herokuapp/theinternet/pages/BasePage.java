package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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

    protected void press(By locator, Keys key)
    {
        waitForVisibilityOf(locator, timeout);
        locateElement(locator).sendKeys(key);
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

    protected void switchToFrame(By locator)
    {
        driver.switchTo().frame(locateElement(locator));
    }

    public void scrollToBottom()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    /** Drag 'from' element to 'to' element */
    protected void jsDragAndDrop(By from, By to) {

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(
                "function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
                        + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n"
                        + "data: {},\n" + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
                        + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n"
                        + "return event;\n" + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
                        + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
                        + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
                        + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n"
                        + "}\n" + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
                        + "var dragStartEvent =createEvent('dragstart');\n"
                        + "dispatchEvent(element, dragStartEvent);\n" + "var dropEvent = createEvent('drop');\n"
                        + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
                        + "var dragEndEvent = createEvent('dragend');\n"
                        + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
                        + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
                        + "simulateHTML5DragAndDrop(source,destination);",
                locateElement(from), locateElement(to));
    }

    protected void actionsDragAndDrop(By from, By to)
    {
        Actions action = new Actions(driver);
        action.dragAndDrop(locateElement(from), locateElement(to)).build().perform();
    }
}
