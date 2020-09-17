package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class BasePage {
    protected WebDriver webDriver;
    private By addRemoveLink = By.linkText("Add/Remove Elements");
    public BasePage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public AddRemoveElementsPage clickOnAddRemoveLink(){
        WebElement element = webDriver.findElement(addRemoveLink);
        element.click();
        return new AddRemoveElementsPage(webDriver);
    }
}
