package com.herokuapp.theinternet.utilities;

import org.testng.annotations.DataProvider;

public class TestUtilities extends BaseTest
{
    @DataProvider(name = "files")
    protected Object[][] files()
    {
        return new Object[][] { {1, "image.html" },
                                {2, "image.png" },
                                {3, "text.txt"} };
    }
}
