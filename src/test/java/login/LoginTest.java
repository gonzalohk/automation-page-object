package login;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecurePage;

public class LoginTest extends BaseTest {
    @BeforeMethod
    public void init(){
         webDriver.get(URL + "login");
    }

    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(webDriver);
        SecurePage securePage = loginPage.loginAs("tomsmith", "SuperSecretPassword!");
        Assert.assertTrue(securePage.isPageSecureDisplayed());
        Assert.assertEquals(securePage.getUserNameText(), "Logout");

    }

    @Test
    public void testInvalidCredentials() {
        LoginPage loginPage = new LoginPage(webDriver);
        SecurePage securePage = loginPage.loginAs("test", "test123");
        Assert.assertTrue(loginPage.isErrorMessageVisible());
        Assert.assertTrue(securePage.isPageSecureDisplayed(), "La pagina no se mostro");
    }

    @Test
    public void testLogOut() {
        LoginPage loginPage = new LoginPage(webDriver);
        SecurePage securePage = loginPage.loginAs("tomsmith", "SuperSecretPassword!");
        loginPage = securePage.clickOnLogOutButton();
        Assert.assertTrue(loginPage.isLoginPageDisplayed());

    }
}