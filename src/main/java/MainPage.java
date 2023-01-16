import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;
    private By personalAccountLink = By.xpath(".//a[@href = '/account']");
    private By enterAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private By mainLogo = By.xpath(".//a[@href='/' and @class='active']");
    private By constructorButton = By.xpath(".//p[text()='Конструктор']/parent::a");
}
