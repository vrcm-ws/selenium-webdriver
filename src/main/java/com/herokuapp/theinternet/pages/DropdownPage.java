package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage
{
    //constructor
    public DropdownPage(WebDriver driver, Logger logger)
    {
        super(driver, logger);
    }

    //locators
    By dropdownLocator = By.xpath("//select[@id='dropdown']");

    public void selectOption(int option)
    {
        //SELECT class
        Select dropdown = new Select(locateElement(dropdownLocator));

        //#1
        //dropdown.selectByIndex(option);

        //#2
        dropdown.selectByValue("" + option);

        //#3
        //dropdown.selectByVisibleText("Option " + option);
    }

    public String getSelectedOption()
    {
        Select dropdown = new Select(locateElement(dropdownLocator));

        return dropdown.getFirstSelectedOption().getText();
    }
}
