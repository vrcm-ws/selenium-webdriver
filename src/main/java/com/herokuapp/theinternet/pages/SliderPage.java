package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SliderPage extends BasePage
{
    private String url = "https://the-internet.herokuapp.com/horizontal_slider";

    //locators
    private By sliderLocator = By.xpath("//input[@type='range']");


    public SliderPage(WebDriver driver, Logger logger)
    {
        super(driver, logger);
    }

    public void openPage()
    {
        openPage(url);
    }
}
