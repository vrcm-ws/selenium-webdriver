package com.herokuapp.theinternet.tests;

import com.herokuapp.theinternet.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.SecureAreaPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

public class LoginTests extends TestUtilities
{
    @Test
    public void loginTest()
    {
        WelcomePage welcomePage = new WelcomePage(driver, logger);

        String username = "tomsmith";
        String password = "SuperSecretPassword!";

        //Open main page
        //driver.get(url);
        welcomePage.openPage();

        // Click on Form Authentication link
        //driver.findElement(By.linkText("Form Authentication")).click();

        LoginPage loginPage = welcomePage.clickFormAuthenticationLink( );

        // enter username and password
        //driver.findElement(By.id("username")).sendKeys("tomsmith");
        //driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // push log in button
        //WebElement logInButton = driver.findElement(By.className("radius"));
        //wait.until(ExpectedConditions.elementToBeClickable(logInButton));
        //logInButton.click();

        SecureAreaPage secureAreaPage = loginPage.login(username, password);

        // verifications
        // String expectedUrl = "http://the-internet.herokuapp.com/secure";
        // Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

        Assert.assertEquals(secureAreaPage.getCurrentURL(), secureAreaPage.getPageURL());

        // log out button is visible
        //Assert.assertTrue(driver.findElement(By.xpath("//a[@class='button secondary radius']")).isDisplayed(),"logOutButton is not visible.");
        Assert.assertTrue(secureAreaPage.isLogoutButtonVisible());

        // Successful log in message
        String expectedSuccessMessage = "You logged into a secure area!";
        //String actualSuccessMessage = driver.findElement(By.id("flash")).getText();
        //Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage), "actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: " + expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);

        Assert.assertTrue(secureAreaPage.getAlertText().contains(expectedSuccessMessage));
    }

    @Parameters({ "username", "password", "expectedMessage" })
    @Test(priority = 1)
    public void loginNegativeTest(String username, String password, String expectedErrorMessage)
    {
        logger.info("START: Negative Login Test");

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
