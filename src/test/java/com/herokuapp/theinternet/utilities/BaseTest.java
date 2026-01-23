package com.herokuapp.theinternet.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.lang.reflect.Method;

public class BaseTest
{
    protected WebDriver driver;
    protected Logger logger;

    protected String testSuiteName;
    protected String testName;
    protected String testMethodName;

    @Parameters ({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void methodSetup(@Optional("chrome") String browser, ITestContext context, Method method)
    {
        String testName = context.getCurrentXmlTest().getName();
        logger = LogManager.getLogger(testName);

        DriverFactory factory = new DriverFactory(browser, logger);
        driver = factory.createWebDriver();

        this.testSuiteName = context.getSuite().getName();
        this.testName = testName;
        this.testMethodName = method.getName();
    }

    @AfterMethod(alwaysRun = true)
    public void methodTeardown()
    {
        logger.info("END: closing driver");
        driver.quit();
    }
}
