import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    Urls urls = new Urls();
    private By emailInput = By.xpath(".//input[@name='name']");
    private By passwordInput = By.xpath(".//input[@name='Пароль']");
    private By enterAccountButton = By.xpath(".//button[text()='Войти']");
    private By registerLink = By.xpath(".//a[@href = '/register']");
    private By forgotPasswordLink = By.xpath(".//a[@href = '/forgot-password']");

    public LoginPage() {}
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
    public void loginUser(String email, String password){
        driver.get(urls.baseUrl + urls.loginPoint);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(emailInput));
        driver.findElement(emailInput).sendKeys(email);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(passwordInput));
        driver.findElement(passwordInput).sendKeys(password);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(enterAccountButton));
        driver.findElement(enterAccountButton).click();
    }
}
