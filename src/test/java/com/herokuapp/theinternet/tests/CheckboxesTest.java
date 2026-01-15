package com.herokuapp.theinternet.tests;

import com.herokuapp.theinternet.TestUtilities;
import com.herokuapp.theinternet.pages.CheckboxPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTest extends TestUtilities
{
    @Test
    public void checkboxesTest()
    {
        WelcomePage welcomePage = new WelcomePage(driver, logger);

        welcomePage.openPage();
        CheckboxPage checkboxPage = welcomePage.clickCheckboxesLink();

        checkboxPage.checkAllCheckboxes();

        Assert.assertTrue(checkboxPage.areAllCheckboxesChecked());
    }
}
