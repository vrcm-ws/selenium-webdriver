package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DragAndDropPage extends BasePage
{
    private String pageURL = "https://the-internet.herokuapp.com/drag_and_drop";

    public DragAndDropPage(WebDriver driver, Logger logger)
    {
        super(driver, logger);
    }

    //locators
    private By columnALocator = By.xpath("//div[@id='column-a']");
    private By columnBLocator = By.xpath("//div[@id='column-b']");
    private By columnAHeaderLocator = By.xpath("//div[@id='column-a']");
    private By columnBHeaderLocator = By.xpath("//div[@id='column-b']");

    public void openPage()
    {
        openPage(pageURL);
    }

    public void abDragAndDrop()
    {
        actionsDragAndDrop(columnALocator, columnBLocator);
    }

    public void baDragAndDrop()
    {
        jsDragAndDrop(columnALocator, columnBLocator);
    }

    public String getColumnAText()
    {
        return locateElement(columnALocator).getText();
    }

    public String getColumnBText()
    {
        return locateElement(columnBLocator).getText();
    }
}
