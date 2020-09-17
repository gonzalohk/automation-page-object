package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class AddRemoveElementsPage extends BasePage {

    private By addButton = By.xpath("//*[@id='content']/div/button");
    private By removeButton = By.className("added-manually");

    public AddRemoveElementsPage(WebDriver webDriver){
        super(webDriver);
    }

    public void addElementButton (){
        WebElement element = webDriver.findElement(addButton);
        element.click();
        WebDriverWait wait = new WebDriverWait(webDriver, 3);
        wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(removeButton)));
    }

    public List <WebElement> deleteButtons (){
        return webDriver.findElements(removeButton);
    }
}