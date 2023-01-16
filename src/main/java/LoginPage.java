import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By emailInput = By.xpath(".//input[@name='name']");
    private By passwordInput = By.xpath(".//input[@name='Пароль']");
    private By enterAccountButton = By.xpath(".//button[text()='Войти']");
    private By registerLink = By.xpath(".//a[@href = '/register']");
    private By forgotPasswordLink = By.xpath(".//a[@href = '/forgot-password']");
}
