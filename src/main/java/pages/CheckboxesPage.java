package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import javax.swing.*;

public class CheckboxesPage extends BasePage {

    private By form = By.id("checkboxes");
    private By checkboxOne = By.xpath("//*[@id=\"checkboxes\"]/input[1]");
    private By checkboxTwo = By.xpath("//*[@id=\"checkboxes\"]/input[2]");

    public CheckboxesPage(WebDriver webDriver){
        super(webDriver);
    }

    public void onclickCheckbox1(){
        WebElement checked = webDriver.findElement(checkboxOne);
        System.out.println(checked.isSelected());
        checked.click();
    }

    public void onclickCheckbox2(){
        WebElement checked = webDriver.findElement(checkboxTwo);
        System.out.println(checked.isSelected());
        checked.click();
    }
}