package com.herokuapp.theinternet.utilities;

import com.herokuapp.theinternet.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.Logger;

public class BaseTest
{
    protected WebDriver driver;
    protected Logger logger;

    @Parameters ({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void methodSetup(@Optional("chrome") String browser, ITestContext context)
    {
        String testName = context.getCurrentXmlTest().getName();
        logger = LogManager.getLogger(testName);

        DriverFactory factory = new DriverFactory(browser, logger);
        driver = factory.createWebDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void methodTeardown()
    {
        logger.info("END: closing driver");
        driver.quit();
    }
}
