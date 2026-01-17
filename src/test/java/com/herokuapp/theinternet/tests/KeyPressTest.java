package com.herokuapp.theinternet.tests;

import com.herokuapp.theinternet.pages.EditorPage;
import com.herokuapp.theinternet.pages.KeyPressPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import com.herokuapp.theinternet.utilities.TestUtilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KeyPressTest extends TestUtilities
{
    @Test
    public void keyPressTest()
    {
        logger.info("START: KeyPress test");

        KeyPressPage keyPressPage = new KeyPressPage(driver, logger);
        keyPressPage.openPage();

        Keys key = Keys.UP;
        keyPressPage.pressKey(key);

        String expectedKeyResult = "You entered: " + key.name();
        String actualKeyResult = keyPressPage.getResult();

        Assert.assertEquals(actualKeyResult, expectedKeyResult);
    }

    @Test
    public void actionKeyPressTest()
    {
        logger.info("START: KeyPress test");

        KeyPressPage keyPressPage = new KeyPressPage(driver, logger);
        keyPressPage.openPage();

        Keys key = Keys.DOWN;

        new Actions(driver)
                .sendKeys(key)
                .build()
                .perform();

        String expectedKeyResult = "You entered: " + key.name();
        String actualKeyResult = keyPressPage.getResult();

        Assert.assertEquals(actualKeyResult, expectedKeyResult);
    }
}
