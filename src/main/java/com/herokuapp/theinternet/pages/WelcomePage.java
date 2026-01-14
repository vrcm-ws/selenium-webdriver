package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePage
{
    private String url = "https://the-internet.herokuapp.com/";

    //locators
    By formAutheticationLocator = By.xpath("//a[text()='Form Authentication']");

    public WelcomePage(WebDriver driver, Logger logger)
    {
        super(driver, logger);
    }

    public void openPage()
    {
        openPage(url);
        logger.info("Page opened!");
    }

    public LoginPage clickFormAuthenticationLink()
    {
        logger.info("Clicking Form Authentication link");

        //driver.findElement(formAutheticationLocator).click();
        click(formAutheticationLocator);

        return new LoginPage(driver, logger);
    }
}
