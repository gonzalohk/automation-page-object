package pages;

import com.aventstack.extentreports.Status;
import helper.ScreenShotHelper;
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
        super(webDriver);
        this.webDriver = webDriver;
    }

    public boolean isPageSecureDisplayed(){
        WebElement element = webDriver.findElement(pageSecure);
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Display");
        return element.isDisplayed();
    }

    public LoginPage clickOnLogOutButton(){
        webDriver.findElement(logoutButton).click();
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Display");
        return new LoginPage(webDriver);
    }

    public String getUserNameText(){
        return webDriver.findElement(logoutButton).getText();
    }
}