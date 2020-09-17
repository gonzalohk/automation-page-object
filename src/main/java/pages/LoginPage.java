package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private By userInput = By.id("username");
    private By passWordInput = By.id("password");
    private By loginButton = By.xpath("//*[@id=\"login\"]/button");
    private By errorMessage = By.id("flash");

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