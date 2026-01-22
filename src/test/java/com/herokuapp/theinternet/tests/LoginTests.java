package com.herokuapp.theinternet.tests;

import com.herokuapp.theinternet.utilities.DataProviderCSV;
import com.herokuapp.theinternet.utilities.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.SecureAreaPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

import java.util.Map;

public class LoginTests extends TestUtilities
{
    @Test
    public void loginTest()
    {
        WelcomePage welcomePage = new WelcomePage(driver, logger);

        String username = "tomsmith";
        String password = "SuperSecretPassword!";

        welcomePage.openPage();

        LoginPage loginPage = welcomePage.clickFormAuthenticationLink( );
        SecureAreaPage secureAreaPage = loginPage.login(username, password);

        Assert.assertEquals(secureAreaPage.getCurrentURL(), secureAreaPage.getPageURL());
        Assert.assertTrue(secureAreaPage.isLogoutButtonVisible());

        String expectedSuccessMessage = "You logged into a secure area!";
        Assert.assertTrue(secureAreaPage.getAlertText().contains(expectedSuccessMessage));
    }

    @Test(priority = 1, dataProvider = "csvReader", dataProviderClass = DataProviderCSV.class)
    public void loginNegativeTest(Map<String, String> testData)
    {
        String test = testData.get("test");
        String username = testData.get("username");
        String password = testData.get("password");
        String expectedErrorMessage = testData.get("expectedMessage");
        String description = testData.get("description");

        logger.info("START: Negative Login Test #" + test + " : " + description);

        WelcomePage welcomePage = new WelcomePage(driver, logger);

        // open main page
        welcomePage.openPage();

        // Click on Form Authentication link
        LoginPage loginPage = welcomePage.clickFormAuthenticationLink();

        // enter username and password
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);

        // push log in button
        loginPage.clickSubmit();

        // Verification
        String actualErrorMessage = loginPage.getAlertText();
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
    }
}
