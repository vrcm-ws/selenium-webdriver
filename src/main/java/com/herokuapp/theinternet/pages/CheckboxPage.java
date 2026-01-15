package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckboxPage extends BasePage
{
    //constructor
    public CheckboxPage(WebDriver driver, Logger logger)
    {
        super(driver, logger);
    }

    //locators
    By checkboxLocator = By.xpath("//input[@type='checkbox']");

    public void checkAllCheckboxes()
    {
        List<WebElement> checkboxes = locateElements(checkboxLocator);

        for(WebElement checkbox : checkboxes)
        {
            if(!checkbox.isSelected())
            {
                checkbox.click();
            }
        }
    }

    public boolean areAllCheckboxesChecked()
    {
        List<WebElement> checkboxes = locateElements(checkboxLocator);

        for(WebElement checkbox : checkboxes)
        {
            if(!checkbox.isSelected())
            {
                return false;
            }
        }

        return true;
    }

}
