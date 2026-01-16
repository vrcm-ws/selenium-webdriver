package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPage extends BasePage
{
    //constructor
    public AlertPage(WebDriver driver, Logger logger)
    {
        super(driver, logger);
    }

    //locators
    By alertButtonLocator = By.xpath("//button[text()='Click for JS Alert']");
    By confirmButtonLocator = By.xpath("//button[text()='Click for JS Confirm']");
    By promptButtonLocator = By.xpath("//button[text()='Click for JS Prompt']");
    By resultLocator = By.xpath("//p[@id='result']");

    public void clickAlertButton()
    {
        click(alertButtonLocator);
    }

    public void clickConfirmButton()
    {
        click(confirmButtonLocator);
    }

    public void clickPromptButton()
    {
        click(promptButtonLocator);
    }

    public String getAlertText()
    {
        Alert alert = switchToAlert();
        return alert.getText();
    }

    public void acceptAlert()
    {
        Alert alert = switchToAlert();
        alert.accept();
    }

    public void dismissAlert()
    {
        switchToAlert().dismiss();
    }

    public void typeIntoAlert(String text)
    {
        Alert alert = switchToAlert();

        alert.sendKeys(text);
    }

    public String getResultText()
    {
        return locateElement(resultLocator).getText();
    }
}
