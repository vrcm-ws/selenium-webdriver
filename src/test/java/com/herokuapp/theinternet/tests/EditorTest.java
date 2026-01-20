package com.herokuapp.theinternet.tests;

import com.herokuapp.theinternet.pages.AlertPage;
import com.herokuapp.theinternet.pages.EditorPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import com.herokuapp.theinternet.utilities.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditorTest extends TestUtilities
{
    @Test
    public void alertTest()
    {
        logger.info("START: Editor test");

        WelcomePage welcomePage = new WelcomePage(driver, logger);
        welcomePage.openPage();

        EditorPage editorPage = welcomePage.clickWYSIWYGLink();
        editorPage.closeBanner();

        String expectedEditorText = "Your content goes here.";
        String actualEditorText =  editorPage.getEditorText();

        Assert.assertEquals(actualEditorText, expectedEditorText);
    }
}
