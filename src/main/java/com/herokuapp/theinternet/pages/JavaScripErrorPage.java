package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class JavaScripErrorPage extends BasePage
{
    String url = "https://the-internet.herokuapp.com/javascript_error";

    public JavaScripErrorPage(WebDriver driver, Logger logger)
    {
        super(driver, logger);
    }

    public void openPage()
    {
        openPage(url);
    }
}
