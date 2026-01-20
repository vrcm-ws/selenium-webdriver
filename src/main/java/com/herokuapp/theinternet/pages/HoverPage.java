package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HoverPage extends BasePage
{
    private String url = "https://the-internet.herokuapp.com/hovers";

    //locators
    private By avatarLocator = By.xpath("//div[@class='figure']");
    private By viewprofileLocator = By.xpath(".//a[contains(text(), 'View profile')]");


    public HoverPage(WebDriver driver, Logger logger)
    {
        super(driver, logger);
    }

    public void openPage()
    {
        openPage(url);
    }

    public void openUserProfile(int index)
    {
        List<WebElement> avatars = locateElements(avatarLocator);
        WebElement avatar = avatars.get(index - 1);

        hoverOver(avatar);

        avatar.findElement(viewprofileLocator).click();
    }

}
