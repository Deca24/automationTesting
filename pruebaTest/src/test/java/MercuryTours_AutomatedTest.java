import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

import static org.junit.Assert.*;

public class MercuryTours_AutomatedTest {

    String username = "TestDaniel8";
    String password = "Password123*";

    private WebDriver driver;

    By registerLinkLocator = By.linkText("REGISTER");
    By registerPageLocator = By.xpath("//img[@src=\"images/mast_register.gif\"]");
    By usernameLocator = By.id("email");
    By passwordLocator = By.name("password");
    By confirmPasswordLocator = By.cssSelector("input[name='confirmPassword']");
    By registerBtnLocator = By.name("submit");

    By userLocator = By.name("userName");
    By passLocator = By.name("password");
    By singInBtnLocator = By.name("submit");
    By loginSuccessfully = By.xpath("//h3[text()='Login Successfully']");
    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.edge.driver", "./webdriver/msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/index.php");
    }
    @After
    public void tearDown() throws Exception {
        //driver.quit();
    }
    @Test
    public void registerUser() throws InterruptedException {
        driver.findElement(registerLinkLocator).click();
        Thread.sleep(2000);
        if (driver.findElement(registerPageLocator).isDisplayed()) {
            driver.findElement(usernameLocator).sendKeys(username);
            driver.findElement(passwordLocator).sendKeys(password);
            driver.findElement(confirmPasswordLocator).sendKeys(password);

            driver.findElement(registerBtnLocator).click();

            System.out.println("Test: Registro exitoso");
        }
        else {
            System.out.println("Register pages was not found");
        }
        List<WebElement> fonts = driver.findElements(By.tagName("font"));
        assertEquals("Note: Your user name is " +username+ ".",fonts.get(5).getText());
    }
    @Test
    public void signIn() throws InterruptedException {
        if (driver.findElement(userLocator).isDisplayed()){
            driver.findElement(userLocator).sendKeys(username);
            driver.findElement(passLocator).sendKeys(password);

            driver.findElement(singInBtnLocator).click();

            Thread.sleep(2000);

            assertTrue(driver.findElement(loginSuccessfully).isDisplayed());

            System.out.println("Test: Inicio de sesión exitoso");
        }
        else {
            System.out.println("The user is not registered");
        }

    }
}
