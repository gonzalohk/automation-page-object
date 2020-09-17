package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecurePage extends BasePage {
    private WebDriver webDriver;
    private By pageSecure = By.id("content");
    private By logoutButton = By.xpath("//*[@id=\"content\"]/div/a/i");


    public SecurePage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public boolean isPageSecureDisplayed(){
        WebElement element = webDriver.findElement(pageSecure);
        return element.isDisplayed();
    }

    public LoginPage clickOnLogOutButton(){
        webDriver.findElement(logoutButton).click();
        return new LoginPage(webDriver);
    }

    public String getUserNameText(){
        return webDriver.findElement(logoutButton).getText();
    }


}