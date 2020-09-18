package elements;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddRemoveElementsPage;

import java.util.List;

public class AddRemoveElementsTest extends BaseTest {
    @BeforeMethod
    public void init(){
        webDriver.get(URL + "add_remove_elements/");
    }

    @Test
    public void testAddElement(){
        AddRemoveElementsPage addRemoveElementsPage = new AddRemoveElementsPage(webDriver);
        for (int i=0; i<10; i++) {
            addRemoveElementsPage.addElementButton();
        }
        Assert.assertEquals(addRemoveElementsPage.deleteButtons().size(), 10);
    }

    @Test
    public void testRemoveElement(){
        AddRemoveElementsPage addRemoveElementsPage = new AddRemoveElementsPage(webDriver);
        for (int i=0; i<10; i++) {
            addRemoveElementsPage.addElementButton();
        }
        List<WebElement> deleteButtons = addRemoveElementsPage.deleteButtons();
        for (int i=0; i<10; i++) {
            WebElement deleteButton = deleteButtons.get(i);
            deleteButton.click();
        }
        deleteButtons = addRemoveElementsPage.deleteButtons();
        Assert.assertEquals(deleteButtons.size(), 0);

    }
}