package pages;

import com.aventstack.extentreports.Status;
import helper.ScreenShotHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private By userInput = By.id("username");
    private By passWordInput = By.id("password");
    private By loginButton = By.xpath("//*[@id=\"login\"]/button");
    private By errorMessage = By.id("flash");

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void typeUserName(String userName){
        WebElement element = webDriver.findElement(userInput);
        element.sendKeys(userName);
    }

    public void typePassWord(String passWord){
        WebElement element = webDriver.findElement(passWordInput);
        element.sendKeys(passWord);
    }

    public void clickOnLoginButton(){
        WebElement element = webDriver.findElement(loginButton);
        element.click();
    }

    public SecurePage loginAs(String userName, String passWord){
        typeUserName(userName);
        typePassWord(passWord);
        clickOnLoginButton();
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Login");
        return new SecurePage(webDriver);
    }

    public boolean isErrorMessageVisible(){
        try {
            WebDriverWait wait = new WebDriverWait(webDriver,3);
            wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(errorMessage)));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean isLoginPageDisplayed(){
        return webDriver.findElement(loginButton).isDisplayed();
    }

}