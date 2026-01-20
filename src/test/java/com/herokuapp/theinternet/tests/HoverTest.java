package com.herokuapp.theinternet.tests;

import com.herokuapp.theinternet.pages.HoverPage;
import com.herokuapp.theinternet.utilities.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HoverTest extends TestUtilities
{
    @Parameters({"user"})
    @Test
    public void userProfileTest(int user)
    {
        HoverPage hoverPage = new HoverPage(driver, logger);

        hoverPage.openPage();

        hoverPage.openUserProfile(user);

        Assert.assertTrue(hoverPage.getCurrentURL().contains("/users/" + user));
    }
}
