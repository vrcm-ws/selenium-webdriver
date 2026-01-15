package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SecureAreaPage extends BasePage
{
    private String pageURL = "https://the-internet.herokuapp.com/secure";

    //constructor
    public SecureAreaPage(WebDriver driver, Logger logger)
    {
        super(driver, logger);
    }

    //locators
    private By logoutButtonLocator = By.xpath("//a[@href='/logout']");
    private By flashMessageLocator = By.xpath("//div[@id='flash']");


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
        return locateElement(flashMessageLocator).getText();
    }

    public LoginPage logout()
    {
        click(logoutButtonLocator);

        return new LoginPage(driver, logger);
    }
}
