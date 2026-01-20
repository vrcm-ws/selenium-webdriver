package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EditorPage extends BasePage
{
    //constructor
    public EditorPage(WebDriver driver, Logger logger)
    {
        super(driver, logger);
    }

    //locators
    By closeBannerButton = By.xpath("//div[@aria-label='Close']/*[name()='svg']");
    By iFrameLocator = By.xpath("//iframe[@id='mce_0_ifr']");
    By editorLocator = By.xpath("//body[@id='tinymce']");

    public void closeBanner()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try
        {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(closeBannerButton));

            if (element != null)
            {
                element.click();
            }
        }
        catch (Exception e)
        {
            logger.info(e.getMessage());
        }
    }

    public String getEditorText()
    {
        switchToFrame(iFrameLocator);

        return locateElement(editorLocator).getText();
    }
}
