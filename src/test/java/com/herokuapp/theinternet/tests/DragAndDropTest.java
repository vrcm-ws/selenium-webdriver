package com.herokuapp.theinternet.tests;

import com.herokuapp.theinternet.pages.DragAndDropPage;
import com.herokuapp.theinternet.utilities.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropTest extends TestUtilities
{
    @Test
    public void dragAndDropTest()
    {
        logger.info("START: Drag and Drop case");

        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver, logger);
        dragAndDropPage.openPage();

        dragAndDropPage.abDragAndDrop();

        Assert.assertEquals(dragAndDropPage.getColumnAText(), "B");
        Assert.assertEquals(dragAndDropPage.getColumnBText(), "A");

        dragAndDropPage.baDragAndDrop();

        Assert.assertEquals(dragAndDropPage.getColumnAText(), "A");
        Assert.assertEquals(dragAndDropPage.getColumnBText(), "B");
    }
}
