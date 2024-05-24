import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.*;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class EdgeSearchTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.edge.driver", "./webdriver/msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bing.com/");
    }

    @Test
    public void testGooglePage(){
        WebElement searchbox = driver.findElement(By.name("q"));
        searchbox.clear();
        searchbox.sendKeys("Automatización de Pruebas de Software");
        searchbox.submit();

        //Implicit Wait
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Explicit Wait
        //WebDriverWait ewait = new WebDriverWait(driver, 10);
        //ewait.until(ExpectedConditions.titleContains("Automatización"));

        //Fluent Wait
        Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
                //Tiempo de espera:
                .withTimeout(10, TimeUnit.SECONDS)
                //Realice consultas cada:
                .pollingEvery(2,TimeUnit.SECONDS)
                //Ignorar la excepción en caso de que sea lanzada por el sistema
                .ignoring(NoSuchElementException.class);
        WebElement video = fwait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.linkText("Pruebas de software automatizadas para la entrega continua"));
            }
        });
        assertTrue(video.isDisplayed());
    }

    @After
    public void tearDown() {
        //driver.quit();
    }
}
