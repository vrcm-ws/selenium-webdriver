package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static java.lang.Math.round;


public class SliderPage extends BasePage
{
    private String url = "https://the-internet.herokuapp.com/horizontal_slider";

    //locators
    private By sliderLocator = By.xpath("//input[@type='range']");
    private By sliderValuelocator = By.xpath("//span[@id='range']");


    public SliderPage(WebDriver driver, Logger logger)
    {
        super(driver, logger);
    }

    public void openPage()
    {
        openPage(url);
    }

    public void moveSliderTo(double position)
    {
        WebElement slider = locateElement(sliderLocator);
        Actions actions = new Actions(driver);
        Keys key;

        double offset = 0;

        double max = Double.parseDouble(slider.getAttribute("max"));
        double step = Double.parseDouble(slider.getAttribute("step"));

        double start = max / 2;

        offset = Math.abs((position - start) / step);

        if (position < start)
        {
            key = Keys.ARROW_LEFT;
        }
        else if (position > start)
        {
            key = Keys.ARROW_RIGHT;
        }
        else
        {
            key = Keys.ENTER;
        }

        actions.click(slider).build().perform();

        for (int i = 0; i < offset; i++)
        {
            actions.sendKeys(key).build().perform();
        }
    }

    public String getSliderValue()
    {
        return locateElement(sliderValuelocator).getText();
    }
}
