import experimentaltools.UniversalMethodsUi;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class testClass {
    private final By enterAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By emailInput = By.xpath(".//input[@name='name']");
    private WebDriver driver;
    private Urls urls = new Urls();
    private WebDriverSet selectDriver = new WebDriverSet();
    private UniversalMethodsUi page = new UniversalMethodsUi();
    @Test
    public void uniClick(){
        driver = selectDriver.getWebDriver();
        page.setDriver(driver);
        driver.manage().window().maximize();
        driver.get(urls.baseUrl);
        page.clickOnObj(enterAccountButton);
    }
    @Test
    public void uniClickOverLoad(){
        driver = selectDriver.getWebDriver();
        page.setDriver(driver);
        driver.manage().window().maximize();
        driver.get(urls.baseUrl);
        page.clickOnObj(enterAccountButton, urls.baseUrl);
        page.setInputValue(emailInput, "Vasyek");
    }
}
