import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    Urls urls = new Urls();
    private final By emailInput = By.xpath(".//input[@name='name']");
    private final By passwordInput = By.xpath(".//input[@name='Пароль']");
    private final By enterAccountButton = By.xpath(".//button[text()='Войти']");
    private final By registerLink = By.xpath(".//a[@href = '/register']");
    private final By forgotPasswordLink = By.xpath(".//a[@href = '/forgot-password']");

    public LoginPage() {
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Авторизация пользователя")
    public void loginUser(String email, String password) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlContains(urls.loginPoint));
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

    @Step("Нажатие ссылки 'Зарегестироваться'")
    public void registerLinkClick() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(registerLink));
        driver.findElement(registerLink).click();
    }

    @Step("Нажатие ссылки 'Восстановить пароль'")
    public void forgotPasswordLinkClick() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlContains(urls.loginPoint));
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(forgotPasswordLink));
        driver.findElement(forgotPasswordLink).click();
    }

}
