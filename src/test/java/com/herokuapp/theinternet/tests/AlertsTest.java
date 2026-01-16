package com.herokuapp.theinternet.tests;

import com.herokuapp.theinternet.pages.AlertPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import com.herokuapp.theinternet.utilities.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsTest extends TestUtilities
{
    @Test
    public void alertTest()
    {
        logger.info("START: JS Alert test");

        WelcomePage welcomePage = new WelcomePage(driver, logger);
        welcomePage.openPage();

        AlertPage alertPage = welcomePage.clickAlertsLink();
        alertPage.clickAlertButton();

        String expectedAlertText = "I am a JS Alert";
        String actualAlertText = alertPage.getAlertText();

        Assert.assertEquals(actualAlertText, expectedAlertText);

        alertPage.acceptAlert();

        String expectedResultText = "You successfully clicked an alert";
        String actualResultText = alertPage.getResultText();

        Assert.assertEquals(actualResultText, expectedResultText);
    }

    @Test
    public void acceptConfirmTest()
    {
        logger.info("START: JS Confirm test");

        WelcomePage welcomePage = new WelcomePage(driver, logger);
        welcomePage.openPage();

        AlertPage alertPage = welcomePage.clickAlertsLink();
        alertPage.clickConfirmButton();

        String expectedAlertText = "I am a JS Confirm";
        String actualAlertText = alertPage.getAlertText();

        Assert.assertEquals(actualAlertText, expectedAlertText);

        alertPage.acceptAlert();

        String expectedResultText = "You clicked: Ok";
        String actualResultText = alertPage.getResultText();

        Assert.assertEquals(actualResultText, expectedResultText);
    }

    @Test
    public void dismmissConfirmTest()
    {
        logger.info("START: JS Confirm test");

        WelcomePage welcomePage = new WelcomePage(driver, logger);
        welcomePage.openPage();

        AlertPage alertPage = welcomePage.clickAlertsLink();
        alertPage.clickConfirmButton();

        String expectedAlertText = "I am a JS Confirm";
        String actualAlertText = alertPage.getAlertText();

        Assert.assertEquals(actualAlertText, expectedAlertText);

        alertPage.dismissAlert();

        String expectedResultText = "You clicked: Cancel";
        String actualResultText = alertPage.getResultText();

        Assert.assertEquals(actualResultText, expectedResultText);
    }

    @Test
    public void acceptPromptTest()
    {
        logger.info("START: JS Prompt test");

        WelcomePage welcomePage = new WelcomePage(driver, logger);
        welcomePage.openPage();

        AlertPage alertPage = welcomePage.clickAlertsLink();
        alertPage.clickPromptButton();

        String expectedAlertText = "I am a JS prompt";
        String actualAlertText = alertPage.getAlertText();

        Assert.assertEquals(actualAlertText, expectedAlertText);

        String testText = "This Is a Test";
        alertPage.typeIntoAlert(testText);
        alertPage.dismissAlert();

        String expectedResultText = "You entered: null";
        String actualResultText = alertPage.getResultText();

        Assert.assertEquals(actualResultText, expectedResultText);
    }

    @Test
    public void dismissPromptTest()
    {
        logger.info("START: JS Prompt test");

        WelcomePage welcomePage = new WelcomePage(driver, logger);
        welcomePage.openPage();

        AlertPage alertPage = welcomePage.clickAlertsLink();
        alertPage.clickPromptButton();

        String expectedAlertText = "I am a JS prompt";
        String actualAlertText = alertPage.getAlertText();

        Assert.assertEquals(actualAlertText, expectedAlertText);

        String testText = "This Is a Test";
        alertPage.typeIntoAlert(testText);
        alertPage.acceptAlert();

        String expectedResultText = "You entered: " + testText;
        String actualResultText = alertPage.getResultText();

        Assert.assertEquals(actualResultText, expectedResultText);
    }
}
