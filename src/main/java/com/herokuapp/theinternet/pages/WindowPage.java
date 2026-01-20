package com.herokuapp.theinternet.pages;


import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowPage extends BasePage
{
    //constructor
    public WindowPage(WebDriver driver, Logger logger)
    {
        super(driver, logger);
    }

    //locators
    private By newWindowLocator = By.xpath("//a[text()='Click Here']");

    public void openNewWindow()
    {
        click(newWindowLocator);
    }

    public NewWindowPage switchtoNewWindowPage()
    {
        switchToWindow("New Window");

        return new NewWindowPage(driver, logger);
    }

}
