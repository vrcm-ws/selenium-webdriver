package com.herokuapp.theinternet.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.DataProvider;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class TestUtilities extends BaseTest
{
    @DataProvider(name = "positions")
    protected Object[][] files()
    {
        return new Object[][] { {1, 0.5},
                                {2, 1.0},
                                {3, 1.5},
                                {4, 2.0},
                                {5, 2.5},
                                {6, 3.0},
                                {7, 3.5},
                                {8, 4.0},
                                {9, 4.0},
                                {10, 5.0} };
    }

    protected void takeScreenshot(String filename)
    {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File ss = ts.getScreenshotAs(OutputType.FILE);

        List<String> pathElements = new ArrayList<>(List.of(System.getProperty("user.dir"), "target", "screenshots", getDate(), testSuiteName, testName, testMethodName));
        Path directory = Paths.get(String.join(File.separator, pathElements) + File.separator + getTime() + "_" + filename + ".png");

        try
        {
            if(directory.getParent() != null)
            {
                Files.createDirectories(directory.getParent());
            }

            Files.copy(ss.toPath(), directory, StandardCopyOption.REPLACE_EXISTING);
        }
        catch (IOException e)
        {
            logger.info("ERROR: {}", e.getMessage());
        }
    }

    private String getDate()
    {
        return (new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    }

    private String getTime()
    {
        return (new SimpleDateFormat("HH-mm-ss-SSS").format(new Date()));
    }

    /**
     * Get lofs from browser console
     * @return List of LogEntries
     */
    protected List<LogEntry> getBrowserLogs()
    {
        LogEntries logs = driver.manage().logs().get("browser");

        return logs.getAll();
    }
}
