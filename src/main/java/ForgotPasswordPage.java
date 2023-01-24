import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ForgotPasswordPage {
    private WebDriver driver;
    private Urls urls = new Urls();
    private final By enterLink = By.xpath(".//a[text()='Войти']");

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажатие кнопки 'Войти'")
    public void enterLinkClick() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlContains(urls.forgotPoint));
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(enterLink));
        driver.findElement(enterLink).click();
    }
}
