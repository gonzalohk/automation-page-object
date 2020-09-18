package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class BasePage {
    protected WebDriver webDriver;
    public BasePage(WebDriver webDriver){
        this.webDriver = webDriver;
    }
}
