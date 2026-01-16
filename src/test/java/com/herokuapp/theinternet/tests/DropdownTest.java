package com.herokuapp.theinternet.tests;

import com.herokuapp.theinternet.pages.DropdownPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import com.herokuapp.theinternet.utilities.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DropdownTest extends TestUtilities
{
    @Parameters({ "option" })
    @Test
    public void optionsTest(int option)
    {
        logger.info("START: OptionTest: " + option);

        WelcomePage welcomePage = new WelcomePage(driver, logger);

        welcomePage.openPage();

        DropdownPage dropdownPage = welcomePage.clickDropdownLink();

        dropdownPage.selectOption(option);

        String selectedOption = dropdownPage.getSelectedOption();
        String expectedOption = "Option " + option;

        Assert.assertEquals(selectedOption, expectedOption);
    }
}
