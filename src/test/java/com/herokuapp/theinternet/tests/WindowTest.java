package com.herokuapp.theinternet.tests;

import com.herokuapp.theinternet.pages.NewWindowPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import com.herokuapp.theinternet.pages.WindowPage;
import com.herokuapp.theinternet.utilities.TestUtilities;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class WindowTest extends TestUtilities
{
    @Test
    public void newWindowTest()
    {
        logger.info("START: Window test");

        WelcomePage welcomePage = new WelcomePage(driver, logger);
        welcomePage.openPage();

        WindowPage windowPage = welcomePage.clickMultipleWindowsLink();
        windowPage.openNewWindow();

        Actions actions = new Actions(driver);
        actions.pause(Duration.ofSeconds(1));

        NewWindowPage newWindowPage = windowPage.switchtoNewWindowPage();

        String pageSource = newWindowPage.getPageSource();
        String expectedText = "New Window";

        Assert.assertTrue(pageSource.contains(expectedText), "New page does not contain expected text");
    }

}
