package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewWindowPage extends BasePage
{
    //constructor
    public NewWindowPage(WebDriver driver, Logger logger)
    {
        super(driver, logger);
    }

    //locators
    By newWindowLocator = By.xpath("//a[text()='Click Here']");

    public void openNewWindow()
    {
        click(newWindowLocator);
    }

}
