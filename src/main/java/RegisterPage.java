import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class RegisterPage {
    private WebDriver driver;
    private final String inputFields = ".//input";
    private final By invalidPasswordText = By.xpath(".//p[text()='Некорректный пароль']");
    private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By enterLink = By.xpath(".//a[text()='Войти']");
    Urls urls = new Urls();
    public RegisterPage() {
    }
    public void setDriver(WebDriver driver){
        this.driver = driver;
    }
    public void registerUser(List<String> user){
        driver.get(urls.baseUrl+urls.registerPoint);
        List<WebElement> inputs = driver.findElements(By.xpath(inputFields));
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(inputs.get(0)));
        inputs.get(0).sendKeys(user.get(0));
        inputs.get(1).sendKeys(user.get(1));
        inputs.get(2).sendKeys(user.get(2));
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(registerButton));
        driver.findElement(registerButton).click();
    }
    public void enterLinkClick(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(enterLink));
        driver.findElement(enterLink).click();
    }
    public boolean checkInvalidPasswordText(){
        boolean actual = false;
        try {
            new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOfElementLocated(invalidPasswordText));
            if (driver.findElement(invalidPasswordText).getText().equals("Некорректный пароль")){
            actual =  true;}
        } catch (Exception e) {
            throw new RuntimeException(e);
            }
        finally {
            return actual;
        }
    }
}
