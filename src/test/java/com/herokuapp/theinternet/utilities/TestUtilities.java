package com.herokuapp.theinternet.utilities;

import org.testng.annotations.DataProvider;

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
}
