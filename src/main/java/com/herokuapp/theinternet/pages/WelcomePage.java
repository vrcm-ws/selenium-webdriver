package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePage
{
    private String url = "https://the-internet.herokuapp.com/";

    //locators
    By formAutheticationLocator = By.xpath("//a[text()='Form Authentication']");
    By checkboxesLocator = By.xpath("//a[text()='Checkboxes']");
    By dropdownLocator = By.xpath("//a[text()='Dropdown']");
    By jsAlertsLocator = By.xpath("//a[text()='JavaScript Alerts']");
    By multipleWindowLocator = By.xpath("//a[text()='Multiple Windows']");
    By wysiwygLocator = By.xpath("//a[text()='WYSIWYG Editor']");

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

    public CheckboxPage clickCheckboxesLink()
    {
        logger.info("Clicking Checkboxes link");

        //driver.findElement(formAutheticationLocator).click();
        click(checkboxesLocator);

        return new CheckboxPage(driver, logger);
    }

    public DropdownPage clickDropdownLink()
    {
        logger.info("Clicking Dropdown link");

        click(dropdownLocator);

        return new DropdownPage(driver, logger);
    }

    public AlertPage clickAlertsLink()
    {
        logger.info("Clicking JS Alerts link");

        click(jsAlertsLocator);

        return new AlertPage(driver, logger);
    }

    public WindowPage clickMultipleWindowsLink()
    {
        logger.info("Clicking Multiple Windows link");

        click(multipleWindowLocator);

        return new WindowPage(driver, logger);
    }

    public EditorPage clickWYSIWYGLink()
    {
        logger.info("Clicking WYSIWYG Editor link");

        click(wysiwygLocator);

        return new EditorPage(driver, logger);
    }
}
