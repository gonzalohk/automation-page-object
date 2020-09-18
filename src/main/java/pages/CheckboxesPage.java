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
        WebElement element = webDriver.findElement(checkboxOne);
        System.out.println(element.isSelected());
        element.click();
    }

    public void onclickCheckbox2(){
        WebElement element = webDriver.findElement(checkboxTwo);
        System.out.println(element.isSelected());
        element.click();
    }

    public boolean isSelectedCheck1(){
        WebElement element = webDriver.findElement(checkboxOne);
        return element.isSelected();
    }

    public boolean isSelectedCheck2(){
        WebElement element = webDriver.findElement(checkboxOne);
        return element.isSelected();
    }
}