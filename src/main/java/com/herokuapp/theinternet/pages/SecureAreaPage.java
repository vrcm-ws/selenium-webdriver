package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SecureAreaPage extends BasePage
{
    private String pageURL = "https://the-internet.herokuapp.com/secure";

    //locators
    private By logoutButtonLocator = By.xpath("//a[@href='/logout']");
    private By alertLocator = By.xpath("//div[@id='flash']");

    public SecureAreaPage(WebDriver driver, Logger logger)
    {
        super(driver, logger);
    }

    public String getPageURL()
    {
        return pageURL;
    }

    public boolean isLogoutButtonVisible()
    {
        return locateElement(logoutButtonLocator).isDisplayed();
    }

    public String getAlertText()
    {
        return locateElement(alertLocator).getText();
    }

    public LoginPage logout()
    {
        click(logoutButtonLocator);

        return new LoginPage(driver, logger);
    }
}
