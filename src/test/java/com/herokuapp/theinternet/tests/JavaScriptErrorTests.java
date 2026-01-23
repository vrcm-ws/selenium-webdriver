package com.herokuapp.theinternet.tests;

import com.herokuapp.theinternet.pages.JavaScripErrorPage;
import com.herokuapp.theinternet.utilities.TestUtilities;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class JavaScriptErrorTests extends TestUtilities
{
    @Test
    public void jsErrorTest()
    {

        SoftAssert softAssert = new SoftAssert();
        JavaScripErrorPage jsErrorPage = new JavaScripErrorPage(driver, logger);

        jsErrorPage.openPage();

        List<LogEntry> logs = getBrowserLogs();

        for (LogEntry log : logs)
        {
            if (log.getLevel().toString().equals("SEVERE"))
            {
                softAssert.fail("SEVERE ERROR: " + log.getMessage());
            }
        }

        softAssert.assertAll();
    }
}
