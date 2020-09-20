package pages;

import com.aventstack.extentreports.Status;
import helper.ScreenShotHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Clase para Login 
 * 
 * @author Grupo 3 1. Cintia Melendrez Alaro 2. Fabiola Monrroy Vera 3. Giovanna
 *         Osinaga Terrazas 4. Gonzalo Osco Hernandez 5. Jhoseline Sharon
 *         Montenegro Pareja 6. Jorge Luis Mollericón García 7. Oscar Alejandro
 *         Parrado Ugarte 8. Raúl Rubén Pacheco Sandoval
 * @version 1.1
 * @variables userInput, passWordInput, loginButton, errorMessage
 **/

public class LoginPage extends BasePage {

    private By userInput = By.id("username");
    private By passWordInput = By.id("password");
    private By loginButton = By.xpath("//*[@id=\"login\"]/button");
    private By errorMessage = By.id("flash");

    
	/**
	 * Constructor: AddRemoveElementsPage
	 * @param WebDriver
	 */
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }
    
	/**
	 * metodo: typeUserName
	 * @param String userName
	 */
    public void typeUserName(String userName){
        WebElement element = webDriver.findElement(userInput);
        element.sendKeys(userName);
    }
	/**
	 * metodo: typePassWord
	 * @param String passWord
	 */
    public void typePassWord(String passWord){
        WebElement element = webDriver.findElement(passWordInput);
        element.sendKeys(passWord);
    }
	/**
	 * metodo: clickOnLoginButton 
	 */
    public void clickOnLoginButton(){
        WebElement element = webDriver.findElement(loginButton);
        element.click();
    }
	/**
	 * metodo: loginAs
	 * @return SecurePage(webDriver);
	 */
    public SecurePage loginAs(String userName, String passWord){
        typeUserName(userName);
        typePassWord(passWord);
        clickOnLoginButton();
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Login");
        return new SecurePage(webDriver);
    }
	/**
	 * metodo: isErrorMessageVisible
	 * @return booelan
	 **/
    public boolean isErrorMessageVisible(){
        try {
            WebDriverWait wait = new WebDriverWait(webDriver,3);
            wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(errorMessage)));
            return true;
        }catch (Exception e){
            return false;
        }
    }
	/**
	 * metodo: isLoginPageDisplayed
	 * @return booelan
	 **/
    public boolean isLoginPageDisplayed(){
        return webDriver.findElement(loginButton).isDisplayed();
    }

}