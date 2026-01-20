package com.herokuapp.theinternet.tests;

import com.herokuapp.theinternet.pages.SliderPage;
import com.herokuapp.theinternet.utilities.TestUtilities;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.text.DecimalFormat;

public class SliderTest extends TestUtilities
{

    @Test(dataProvider = "positions")
    public void sliderTest(int number,  double position)
    {
        logger.info("START: Slider test # " + number + " at " + position);

        Actions actions = new Actions(driver);

        DecimalFormat df = new DecimalFormat("###.#");

        SliderPage sliderPage = new SliderPage(driver, logger);
        sliderPage.openPage();

        sliderPage.moveSliderTo(position);

        String expectedSliderValue = df.format(position);
        String actualSliderValue = sliderPage.getSliderValue();

        Assert.assertEquals(actualSliderValue, expectedSliderValue);
    }
}
