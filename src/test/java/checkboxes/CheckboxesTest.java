package checkboxes;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckboxesPage;

public class CheckboxesTest extends BaseTest {
    @BeforeMethod
    public void init(){
        webDriver.get(URL + "checkboxes");
    }

    @Test
    public void testCheck(){
        CheckboxesPage checkboxesPage = new CheckboxesPage(webDriver);
        checkboxesPage.onclickCheckbox1();
        Assert.assertTrue(checkboxesPage.isSelectedCheck1());
    }

    @Test
    public void testUncheck(){
        CheckboxesPage checkboxesPage = new CheckboxesPage(webDriver);
        checkboxesPage.onclickCheckbox2();
        Assert.assertFalse(checkboxesPage.isSelectedCheck2());
    }

}