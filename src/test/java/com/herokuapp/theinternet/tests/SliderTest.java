package com.herokuapp.theinternet.tests;

import com.herokuapp.theinternet.pages.HoverPage;
import com.herokuapp.theinternet.pages.SliderPage;
import com.herokuapp.theinternet.utilities.TestUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SliderTest extends TestUtilities
{
    @Test
    public void sliderTest()
    {
        Actions actions = new Actions(driver);

        SliderPage sliderPage = new SliderPage(driver, logger);
        sliderPage.openPage();

        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));

        new Actions(driver)
                .dragAndDropBy(slider, -50, 0)
                .build()
                .perform();

        /*
        actions.click(slider).build().perform();

        for (int i = 0; i < 3; i++)
        {
            actions.sendKeys(Keys.ARROW_RIGHT).build().perform();
        }

         */

        System.out.println(slider.getAttribute("min"));
        System.out.println(slider.getAttribute("max"));
        System.out.println(slider.getAttribute("step"));

        System.out.println(slider.getSize());
        System.out.println(slider.getSize().getWidth());
    }
}
