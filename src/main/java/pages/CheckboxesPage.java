package pages;

import com.aventstack.extentreports.Status;
import helper.ScreenShotHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Clase para el CheckBoxesPage
 * 
 * @author Grupo 3 1. Cintia Melendrez Alaro 2. Fabiola Monrroy Vera 3. Giovanna
 *         Osinaga Terrazas 4. Gonzalo Osco Hernandez 5. Jhoseline Sharon
 *         Montenegro Pareja 6. Jorge Luis Mollericón García 7. Oscar Alejandro
 *         Parrado Ugarte 8. Raúl Rubén Pacheco Sandoval
 * @version 1.1
 * @variables form, checkboxOne, checkboxTwo
 **/

public class CheckboxesPage extends BasePage {

    private By form = By.id("checkboxes");
    private By checkboxOne = By.xpath("//*[@id=\"checkboxes\"]/input[1]");
    private By checkboxTwo = By.xpath("//*[@id=\"checkboxes\"]/input[2]");

	/**
	 * Constructor: CheckboxesPage
	 * @param WebDriver
	 */
    public CheckboxesPage(WebDriver webDriver){
        super(webDriver);
    }
	/**
	 * metodo: onclickCheckbox1
	 */
    public void onclickCheckbox1(){
        WebElement element = webDriver.findElement(checkboxOne);
        System.out.println(element.isSelected());
        element.click();
    }
	/**
	 * metodo: onclickCheckbox2
	 */
    public void onclickCheckbox2(){
        WebElement element = webDriver.findElement(checkboxTwo);
        System.out.println(element.isSelected());
        element.click();
    }
	/**
	 * metodo: isSelectedCheck1
	 */
    public boolean isSelectedCheck1(){
        WebElement element = webDriver.findElement(checkboxOne);
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Select Check");
        return element.isSelected();
    }
	/**
	 * metodo: isSelectedCheck2
	 */
    public boolean isSelectedCheck2(){
        WebElement element = webDriver.findElement(checkboxOne);
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Select Check");
        return element.isSelected();
    }
}