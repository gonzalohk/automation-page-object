package elements;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddRemoveElementsPage;
import pages.BasePage;

import java.util.List;

public class AddRemoveElementsTest extends BaseTest {
    @BeforeMethod
    public void init(){

        webDriver.get("https://the-internet.herokuapp.com/");
        basePage = new BasePage(webDriver);
    }

    @Test
    public void testAddElement(){
        AddRemoveElementsPage addRemoveElementsPage = basePage.clickOnAddRemoveLink();
        for (int i=0; i<10; i++) {
            addRemoveElementsPage.addElementButton();
        }
        Assert.assertEquals(addRemoveElementsPage.deleteButtons().size(), 10);
    }

    @Test
    public void testRemoveElement(){
        AddRemoveElementsPage addRemoveElementsPage = basePage.clickOnAddRemoveLink();
        for (int i=0; i<10; i++) {
            addRemoveElementsPage.addElementButton();
        }
        List<WebElement> deletebuttons = addRemoveElementsPage.deleteButtons();
        for (int i=0; i<10; i++) {
            WebElement deleteButton = deletebuttons.get(i);
            deleteButton.click();
        }
        deletebuttons = addRemoveElementsPage.deleteButtons();
        Assert.assertEquals(deletebuttons.size(), 0);

    }


}