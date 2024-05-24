import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Localizadores {
    private WebDriver driver;
    @Test void localizadores() {
    // 1. Localizador By.id("string"):
    // Localizar un elemento a través de su atributo de identificación
       By locator = By.id("id_element");
    // 2. Localizador By.name("string"):
    // Localizar un elemento a través del atributo de nombre (name)
       By locator_name = By.name("name_element");
    // 3. Localizador By.className("class")
    // localizar un elemento a través de su atributo de clase (class)
       By locator_class = By.className("class_element");
    // 4. Localizador By.tagName("tag")
    // Localizar elementos utilizando el nombre de la etiqueta HTML del elemento.
       By locator_tagName = By.tagName("tagName_element");
    // 5. Localizador By.linkText("string")
    // Localizar elementos HTML por el texto visible de un enlace
      By locator_linkText = By.tagName("texto_link");
    // 6. Localizador By.partialLinkText("string")
    // seleccionar un elemento HTML por una parte del texto visible de un enlace
       By locatro_partialLinkText = By.partialLinkText("partiaLink_element");
    // 7. Localizador By.cssSelector("string")
    // Localizar un elemento utilizando selectores CSS
        By locator_cssSelector = By.cssSelector("selectorCSS");
    // 8. Localizador By.xpath("string");
    // Localizar un elemento HTML utilizando la sintaxis XPath "XML Path Language"
        By locator_Xpath = By.xpath("//input[@name='q'");
    }
    @After
    public void tearDown() {
        driver.quit();
    }

}
