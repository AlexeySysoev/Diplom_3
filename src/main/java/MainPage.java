import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;
    Urls urls = new Urls();
    private final By personalAccountLink = By.xpath(".//a[@href = '/account']");
    private final By enterAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By mainLogo = By.xpath(".//a[@href='/' and @class='active']");
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']/parent::a");
    private final By bunTab = By.xpath(".//span[text()='Булки']");
    private final By sauceTab = By.xpath(".//span[text()='Соусы']");
    private final By fillingTab = By.xpath(".//span[text()='Начинки']");
    final By fluoBun = By.xpath(".//a[@href='/ingredient/61c0c5a71d1f82001bdaaa6d']");
    public MainPage(){}

    public void setDriver(WebDriver driver){
        this.driver = driver;
    }
    public void open(){
        driver.get(urls.baseUrl);
    }
    public void personalAccountLinkClick(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(personalAccountLink));
        driver.findElement(personalAccountLink).click();
    }
    public void enterAccountButtonClick(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(enterAccountButton));
        driver.findElement(enterAccountButton).click();
    }
    public void waitElement(By element){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(element));
    }
}
