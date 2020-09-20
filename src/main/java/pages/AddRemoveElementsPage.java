package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

/**
 * Clase para Adicionar y remover elementos
 * 
 * @author Grupo 3 1. Cintia Melendrez Alaro 2. Fabiola Monrroy Vera 3. Giovanna
 *         Osinaga Terrazas 4. Gonzalo Osco Hernandez 5. Jhoseline Sharon
 *         Montenegro Pareja 6. Jorge Luis Mollericón García 7. Oscar Alejandro
 *         Parrado Ugarte 8. Raúl Rubén Pacheco Sandoval
 * @version 1.1
 * @variables addButton, removeButton
 **/

public class AddRemoveElementsPage extends BasePage {

	private By addButton = By.xpath("//*[@id='content']/div/button");
	private By removeButton = By.className("added-manually");

	/**
	 * Constructor: AddRemoveElementsPage
	 * @param WebDriver
	 */

	public AddRemoveElementsPage(WebDriver webDriver) {
		super(webDriver);
	}

	/**
	 * metodo: addElementButton
	 */
	public void addElementButton() {
		WebElement element = webDriver.findElement(addButton);
		element.click();
		WebDriverWait wait = new WebDriverWait(webDriver, 3);
		wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(removeButton)));
	}

	/**
	 * metodo: deleteButtons
	 * 
	 * @param webDriver.findElements(removeButton);
	 */

	public List<WebElement> deleteButtons() {
		return webDriver.findElements(removeButton);
	}
}