package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage
{
    //locators
    private By usernameInputLocator = By.xpath("//input[@id='username']");
    private By passwordInputLocator = By.xpath("//input[@id='password']");
    private By submitButtonLocator = By.xpath("//button[@type='submit']");
    private By flashMessageLocator = By.xpath("//div[@id='flash']");

    public LoginPage(WebDriver driver, Logger logger)
    {
        super(driver, logger);
    }

    public void enterUsername(String username)
    {
        //driver.findElement(usernameInputLocator).sendKeys(username);
        type(usernameInputLocator, username);
    }

    public void enterPassword(String password)
    {
        //driver.findElement(passwordInputLocator).sendKeys(password);
        type(passwordInputLocator, password);
    }

    public void clickSubmit()
    {
        //driver.findElement(submitbuttonLocator).click();
        click(submitButtonLocator);
    }

    public String getAlertText()
    {
        return locateElement(flashMessageLocator).getText();
    }

    public SecureAreaPage login(String username, String password)
    {
        logger.info("Logging in as " + username);

        enterUsername(username);
        enterPassword(password);
        clickSubmit();

        return new SecureAreaPage(driver, logger);
    }
}
