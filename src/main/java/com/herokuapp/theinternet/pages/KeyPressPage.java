package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KeyPressPage extends BasePage
{
    private String pageURL = "https://the-internet.herokuapp.com/key_presses";

    //locators
    private By inputField = By.xpath("//input[@id='target']");
    private By inputDisplay = By.xpath("//p[@id='result']");

    //constructor
    public KeyPressPage(WebDriver driver, Logger logger)
    {
        super(driver, logger);
    }

    public void openPage()
    {
        openPage(pageURL);
    }

    public void pressKey(Keys key)
    {
        press(inputField, key);
    }

    public String getResult()
    {
        return locateElement(inputDisplay).getText();
    }
}
